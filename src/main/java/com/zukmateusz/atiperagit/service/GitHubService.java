package com.zukmateusz.atiperagit.service;

import com.zukmateusz.atiperagit.http_repo.GitHttpClient;
import com.zukmateusz.atiperagit.model.BranchInfo;
import com.zukmateusz.atiperagit.model.ErrorResponse;
import com.zukmateusz.atiperagit.model.RepositoryInfo;
import com.zukmateusz.atiperagit.model.RepositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GitHubService {
    private final GitHttpClient client;

    public GitHubService(GitHttpClient client) {
        this.client = client;
    }

    public Set<RepositoryResponse> getUserRepositoriesInfo(String userName) {
        List<RepositoryInfo> usersRepositoriesInfo = client.getUserRepositoriesInfo(userName);
        return usersRepositoriesInfo.stream()
                .filter(repositoryInfo -> !repositoryInfo.fork())
                .map(repositoryInfo -> {
                    List<BranchInfo> braches = client.getBranchInfo(repositoryInfo.owner().login(), repositoryInfo.name());
                    return new RepositoryResponse(repositoryInfo.name(), repositoryInfo.owner().login(), braches);
                })
                .collect(Collectors.toSet());
    }
}


//.twist
// wirtualne watki
