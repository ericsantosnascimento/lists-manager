package br.com.lists.service;

import br.com.lists.domain.Item;
import br.com.lists.repository.ItemRepository;
import br.com.lists.request.ItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by eric-nasc on 07/04/17.
 */
@Service
public class ItemService {

    private ItemRepository itemRepository;
    private UserService userService;

    @Autowired
    public ItemService(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public Item save(ItemRequest itemRequest, UUID listId, UUID userId, String token) {
        userService.checkUserSession(userId, token);
        Item item = mapItemRequestToItem(itemRequest, listId);
        return itemRepository.save(item);
    }

    public void delete(ItemRequest itemRequest, UUID listId, UUID userId, String token) {
        userService.checkUserSession(userId, token);
        Item list = mapItemRequestToItem(itemRequest, listId);
        itemRepository.delete(list);
    }

    public List<Item> getItemsByListId(UUID listId, UUID userId, String token) {
        userService.checkUserSession(userId, token);
        return itemRepository.findByListId(listId);
    }

    public Item getById(UUID listId, UUID itemId, UUID userId, String token) {
        userService.checkUserSession(userId, token);
        return itemRepository.findByIdAndListId(itemId, listId);
    }

    private Item mapItemRequestToItem(ItemRequest itemRequest, UUID listId) {
        Item item = new Item();
        item.setName(itemRequest.name());
        item.setQuantity(itemRequest.quantity());
        item.setRemoved(Boolean.FALSE);
        item.setChecked(itemRequest.isMarkedAsCheck());
        item.setListId(listId);
        return item;
    }


}
