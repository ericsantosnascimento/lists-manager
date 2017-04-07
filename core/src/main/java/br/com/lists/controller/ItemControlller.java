package br.com.lists.controller;

import br.com.lists.domain.Item;
import br.com.lists.request.ItemRequest;
import br.com.lists.service.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by eric-nasc on 05/04/17.
 */

@RestController
@RequestMapping("/lists/{list_id}/items")
public class ItemControlller {

    private ItemService itemService;

    @Autowired
    public ItemControlller(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Finds all items related to the provided lists", notes = "Will bring up all items releasted to this user and list")
    public List<Item> getItemsByListId (@PathVariable("list_id") UUID listId, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return itemService.getItemsByListId(listId, userId, token);
    }

    @RequestMapping(value = "{item_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find by list Id", notes = "Get a specific item by id")
    public Item itemById(@PathVariable("list_id") UUID listId, @PathVariable("item_id") UUID itemId, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return itemService.getById(listId, itemId, userId, token);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create item", notes = "Create an item from the provided payload")
    public Item save(@PathVariable("list_id") UUID listId, @RequestBody ItemRequest itemRequest, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return itemService.save(itemRequest, listId, userId, token);
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update item", notes = "Update an item from the provided payload")
    public Item update(@PathVariable("list_id") UUID listId, @RequestBody ItemRequest itemRequest, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return itemService.save(itemRequest, listId, userId, token);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete item", notes = "Delete an item from the provided payload")
    public void delete(@PathVariable("list_id") UUID listId, @RequestBody ItemRequest itemRequest, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        itemService.delete(itemRequest, listId, userId, token);
    }

    @RequestMapping(value = "synchronize", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Synchronize lists", notes = "Synchronize all device lists on the service the approach here will be all lists will be dropped and created again")
    public java.util.List<br.com.lists.List> synchronize(@RequestBody List<Item> items, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return Collections.emptyList();
    }

}
