package com.chiraranw.gitviewcommandservice.service;

import com.chiraranw.gitviewcommandservice.model.View;
import com.chiraranw.gitviewcommandservice.repository.ViewReposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewReposService {

    private  final ViewReposRepository viewReposRepository;
    private final GitHubService gitHubService;

    @Autowired
    public ViewReposService(ViewReposRepository viewReposRepository, GitHubService gitHubService) {
        this.viewReposRepository = viewReposRepository;
        this.gitHubService = gitHubService;
    }

    public View save(View view){
       return  this.viewReposRepository.save(view);
    }

    //Good practise to make these calls in the service
    public View view(String login){
            return this.gitHubService.getRepos(login);
    }

}
