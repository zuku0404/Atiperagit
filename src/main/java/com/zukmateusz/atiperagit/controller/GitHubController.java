package com.zukmateusz.atiperagit.controller;

import com.zukmateusz.atiperagit.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repositories")
public class GitHubController {
    private final GitHubService gitHubService;

    @Autowired
    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseEntity<?> getUserRepositoriesInfo(@PathVariable ("username") String userName){
        return gitHubService.getUserRepositoriesInfo(userName);
    }
}
