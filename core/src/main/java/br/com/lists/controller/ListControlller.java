package br.com.lists.controller;

import br.com.lists.domain.List;
import br.com.lists.request.ListRequest;
import br.com.lists.service.ListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by eric-nasc on 05/04/17.
 */

@RestController
@RequestMapping("/lists")
public class ListControlller {

    private ListService listService;

    @Autowired
    public ListControlller(ListService listService) {
        this.listService = listService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Finds all user related lists", notes = "Will bring up all lists available for this user")
    public java.util.List<List> list(@RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return listService.getAllLists(userId, token);
    }

    @RequestMapping(value = "{list_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find by list Id", notes = "Get a specific list, list_id is mandatory")
    public List listById(@PathVariable("list_id") UUID listId, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return listService.getById(listId, userId, token);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create list", notes = "Create list")
    public List save(@RequestBody ListRequest listRequest, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return listService.save(listRequest, userId, token);
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update list", notes = "Update list")
    public List update(@RequestBody ListRequest listRequest, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return listService.save(listRequest, userId, token);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete list", notes = "Delete list")
    public void delete(ListRequest listRequest, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        listService.delete(listRequest, userId, token);
    }

    @RequestMapping(value = "synchronize", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Synchronize lists", notes = "Synchronize all device lists on the service the approach here will be all lists will be dropped and created again")
    public java.util.List<List> synchronize(@RequestBody java.util.List<List> lists, @RequestParam("user_id") UUID userId, @RequestParam("token") String token) {
        return listService.synchronize(lists, userId, token);
    }


}
