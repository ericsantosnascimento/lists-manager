package br.com.lists.service;

import br.com.lists.domain.List;
import br.com.lists.repository.ListRepository;
import br.com.lists.request.ListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by eric-nasc on 07/04/17.
 */
@Service
public class ListService {

    private ListRepository listRepository;
    private UserService userService;

    @Autowired
    public ListService(ListRepository listRepository, UserService userService) {
        this.listRepository = listRepository;
        this.userService = userService;
    }

    public List save(ListRequest listRequest, UUID userId, String token) {
        userService.checkUserSession(userId, token);
        List list = mapListRequestToList(listRequest, userId);
        return listRepository.save(list);
    }

    public void delete(ListRequest listRequest, UUID userId, String token) {
        userService.checkUserSession(userId, token);
        List list = mapListRequestToList(listRequest, userId);
        listRepository.delete(list);
    }

    public java.util.List<List> getAllLists(UUID userId, String token) {
        userService.checkUserSession(userId, token);
        return (java.util.List<List>) listRepository.findAll();
    }

    public List getById(UUID listId, UUID userId, String token) {
        userService.checkUserSession(userId, token);
        return listRepository.findOne(listId);
    }

    private List mapListRequestToList(ListRequest listRequest, UUID userId) {
        List list = new List();
        list.setName(listRequest.name());
        list.setRemoved(Boolean.FALSE);
        list.setUserId(userId);
        return list;
    }

    @Transactional
    public java.util.List<List> synchronize(java.util.List<ListRequest> lists, UUID userId, String token) {
        userService.checkUserSession(userId, token);
        java.util.List<List> listsToPersist = lists.stream().map(listRequest -> mapListRequestToList(listRequest, userId)).collect(Collectors.toList());
        return (java.util.List<List>) listRepository.save(listsToPersist);
    }
}
