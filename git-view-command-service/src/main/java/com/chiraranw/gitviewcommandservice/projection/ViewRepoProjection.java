package com.chiraranw.gitviewcommandservice.projection;

import com.chiraranw.gitviewcommandservice.coreapi.ReposViewedEvent;
import com.chiraranw.gitviewcommandservice.model.View;
import com.chiraranw.gitviewcommandservice.repository.ViewReposRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ViewRepoProjection {

    //Handle Axon Events from this side

    private final ViewReposRepository viewReposRepository;

    @Autowired
    public ViewRepoProjection(ViewReposRepository viewReposRepository) {
        this.viewReposRepository = viewReposRepository;
    }

    @EventHandler
    private void on(ReposViewedEvent reposViewedEvent){
        this.viewReposRepository.save(new View(
                null,
                reposViewedEvent.getLogin(),
                reposViewedEvent.getFirstRepo()
        ));
    }
}
