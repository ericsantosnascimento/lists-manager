package br.com.lists.controller;

import br.com.lists.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.UUID;

/**
 * Created by eric-nasc on 05/04/17.
 */

@RestController
@RequestMapping("lists")
public class ListControlller {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public java.util.List<List> list(@RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return Collections.emptyList();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public java.util.List<List> listById(@PathVariable("list_id") UUID listId, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List save(@RequestBody List list, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public List update(@RequestBody List list, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody List list, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
    }

}
