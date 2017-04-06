package br.com.lists.controller;

import br.com.lists.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.UUID;

/**
 * Created by eric-nasc on 05/04/17.
 */

@RestController
@RequestMapping("/lists")
public class ListControlller {

    /**
     * how it works?
     * @param userId
     * @param token
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Finds all user related lists", notes = "Will bring up all lists available for this user")
    public java.util.List<List> list(@RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return Collections.emptyList();
    }

    @RequestMapping(value = "{list_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find by list Id", notes = "Get a specific list, list_id is mandatory")
    public List listById(@PathVariable("list_id") UUID listId, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create list", notes = "Create a user list")
    public List save(@RequestBody List list, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update list", notes = "Update a user list")
    public List update(@RequestBody List list, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete list", notes = "Delete a user list")
    public void delete(@RequestBody List list, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
    }

    @RequestMapping(value = "synchronize", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Synchronize lists", notes = "Synchronize all device lists on the service the approach here will be all lists will be dropped and created again")
    public java.util.List<List> synchronize(@RequestParam("id") UUID userId, @RequestParam("token") String token, @RequestBody java.util.List<List> lists) {
        return Collections.emptyList();
    }


}
