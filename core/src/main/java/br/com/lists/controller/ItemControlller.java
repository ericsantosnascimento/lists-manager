package br.com.lists.controller;

import br.com.lists.Item;
import io.swagger.annotations.ApiOperation;
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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Finds all items related to the provided lists", notes = "Will bring up all items releasted to this user and list")
    public List<Item> items(@PathVariable("list_id") UUID listId, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return Collections.emptyList();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find by list Id", notes = "Get a specific item by id")
    public Item itemById(@PathVariable("list_id") UUID listId, @PathVariable UUID id, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create item", notes = "Create an item from the provided payload")
    public Item save(@PathVariable("list_id") UUID listId, @RequestBody Item item, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update item", notes = "Update an item from the provided payload")
    public Item update(@PathVariable("list_id") UUID listId, @RequestBody Item item, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete item", notes = "Delete an item from the provided payload")
    public void delete(@PathVariable("list_id") UUID listId, @RequestBody Item item, @RequestParam("id") UUID userId, @RequestParam("token") String token) {

    }

    @RequestMapping(value = "synchronize", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Synchronize lists", notes = "Synchronize all device lists on the service the approach here will be all lists will be dropped and created again")
    public java.util.List<br.com.lists.List> synchronize(@RequestParam("id") UUID userId, @RequestParam("token") String token, @RequestBody List<Item> lists) {
        return Collections.emptyList();
    }

}
