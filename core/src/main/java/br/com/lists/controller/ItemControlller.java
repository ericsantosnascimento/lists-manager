package br.com.Items.controller;

import br.com.lists.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by eric-nasc on 05/04/17.
 */

@RestController
@RequestMapping("lists/{list_id}/items")
public class ItemControlller {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> items(@PathVariable("list_id") UUID listId) {
        return Collections.emptyList();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Item itemById(@PathVariable UUID id) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Item save(@RequestBody Item item) {
        return null;
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Item update(@RequestBody Item item) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Item item) {
    }

}
