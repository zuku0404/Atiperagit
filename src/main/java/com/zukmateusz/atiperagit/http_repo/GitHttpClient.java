package com.zukmateusz.atiperagit.http_repo;

import com.zukmateusz.atiperagit.model.BranchInfo;
import com.zukmateusz.atiperagit.model.RepositoryInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface GitHttpClient {

    @GetExchange("/users/{username}/repos")
    List<RepositoryInfo> getUserRepositoriesInfo(@PathVariable("username") String userName);

    @GetExchange("/repos/{login}/{repository}/branches")
    List<BranchInfo> getBranchInfo(@PathVariable("login") String login, @PathVariable("repository") String repositoryName);
}
