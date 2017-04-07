package br.com.lists.service;

import br.com.lists.domain.List;
import br.com.lists.repository.ListRepository;
import br.com.lists.request.ListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by eric-nasc on 07/04/17.
 */
@Service
public class ListService {

    private ListRepository listRepository;

    @Autowired
    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public List save(ListRequest listRequest, UUID userId, String token) {
        List list = mapListRequestToList(listRequest, userId);
        listRepository.save(list);
        return null;
    }

    public void delete(ListRequest listRequest, UUID userId, String token) {
        List list = mapListRequestToList(listRequest, userId);
        listRepository.delete(list);
    }

    public java.util.List<List> getAllLists(UUID userId, String token) {
        return (java.util.List<List>) listRepository.findAll();
    }

    public List getById(UUID listId, UUID userId, String token) {
        return listRepository.findOne(listId);
    }

    private List mapListRequestToList(ListRequest listRequest, UUID userId) {
        List list = new List();
        list.setName(listRequest.name());
        list.setRemoved(Boolean.FALSE);
        list.setUserId(userId);
        return list;
    }
}
