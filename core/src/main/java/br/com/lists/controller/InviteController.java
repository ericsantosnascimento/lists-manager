package br.com.lists.controller;

import br.com.lists.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by eric-nasc on 06/04/17.
 */
@RestController
@RequestMapping("/lists/{list_id}/invites")
public class InviteController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get invite link", notes = "get the invite link to invite more people to edit the list")
    public String getInviteLink(@PathVariable("list_id") UUID listId, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return "http://lists.com/invite?" + UUID.randomUUID();
    }

    @RequestMapping(value = "accept", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Accept the invite", notes = "accept the invite sent from one user")
    public List accept(@PathVariable("list_id") UUID listId, @RequestParam("invite_id") UUID inviteId, @RequestParam("id") UUID userId, @RequestParam("token") String token) {
        return null;
    }
}

