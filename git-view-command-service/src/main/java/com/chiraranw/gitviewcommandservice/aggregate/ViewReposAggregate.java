package com.chiraranw.gitviewcommandservice.aggregate;

import com.chiraranw.gitviewcommandservice.coreapi.ReposViewedEvent;
import com.chiraranw.gitviewcommandservice.coreapi.ViewReposCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Aggregate
@NoArgsConstructor
public class ViewReposAggregate {


    @AggregateIdentifier
    private String id;
    private String login;
    private String firstRepo;

    @EventSourcingHandler
    private void on(ReposViewedEvent reposViewedEvent) {
        this.id = reposViewedEvent.getId();
        this.login = reposViewedEvent.getLogin();
        this.firstRepo = reposViewedEvent.getFirstRepo();
    }
    //

    @CommandHandler
    public ViewReposAggregate(ViewReposCommand viewReposCommand) {
        AggregateLifecycle.apply(new ReposViewedEvent(
                Objects.requireNonNull(viewReposCommand.getId()),
                Objects.requireNonNull(viewReposCommand.getLogin()),
                Objects.requireNonNull(viewReposCommand.getFirstRepo())
        ));
    }


}
