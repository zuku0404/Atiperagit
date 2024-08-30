package com.zukmateusz.atiperagit.controller;

import com.zukmateusz.atiperagit.model.RepositoryResponse;
import com.zukmateusz.atiperagit.service.GitHubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/repositories")
public class GitHubController {
    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseEntity<Set<RepositoryResponse>> getUserRepositoriesInfo(@PathVariable ("username") String userName){
        Set<RepositoryResponse> userRepositoriesInfo = gitHubService.getUserRepositoriesInfo(userName);
        return new ResponseEntity(userRepositoriesInfo, HttpStatus.OK);
    }
}