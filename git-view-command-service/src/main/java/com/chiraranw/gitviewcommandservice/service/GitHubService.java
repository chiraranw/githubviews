package com.chiraranw.gitviewcommandservice.service;

import com.chiraranw.gitviewcommandservice.model.Repo;
import com.chiraranw.gitviewcommandservice.model.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GitHubService {

    private final WebClient.Builder builder;

    @Autowired
    public GitHubService(@Qualifier("getClient") WebClient.Builder builder) {
        this.builder = builder;
    }

    //Only fire the send(command) is view.login is not null
    public View getRepos(String login) {
        View temp = new View();
        Optional<Repo> repo = this.builder
                .build()
                .get()
                .uri("https://api.github.com/users/" + login + "/repos")
                .retrieve()
                .bodyToFlux(Repo.class)
                .toStream()
                .findFirst();
        repo.ifPresent(r -> {
            temp.setLogin(login);
            temp.setFirstRepo(r.getName());
        });

        return temp;
    }

}
