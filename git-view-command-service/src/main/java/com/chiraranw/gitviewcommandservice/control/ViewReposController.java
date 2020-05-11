package com.chiraranw.gitviewcommandservice.control;

import com.chiraranw.gitviewcommandservice.coreapi.ViewReposCommand;
import com.chiraranw.gitviewcommandservice.model.View;
import com.chiraranw.gitviewcommandservice.service.ViewReposService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(value = "/git/v1/")
public class ViewReposController {

    private final ViewReposService viewReposService;
    private final CommandGateway commandGateway;

    @Autowired
    public ViewReposController(ViewReposService viewReposService, CommandGateway commandGateway) {
        this.viewReposService = viewReposService;
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/view/{login}", method = RequestMethod.GET)
    public ResponseEntity<View> view(@PathVariable("login") String login) {

        View view = this.viewReposService.view(login);
        //view is never null!
        if (!Objects.isNull(view.getLogin())) {
            String id = UUID.randomUUID().toString();
            commandGateway.send(new ViewReposCommand(id, view.getLogin(), view.getFirstRepo()));
        }
        return new ResponseEntity<View>(view, HttpStatus.OK);
    }


}
