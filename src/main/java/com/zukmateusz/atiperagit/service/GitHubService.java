package com.zukmateusz.atiperagit.service;

import com.zukmateusz.atiperiagit.model.BranchInfo;
import com.zukmateusz.atiperiagit.model.ErrorResponse;
import com.zukmateusz.atiperiagit.model.RepositoryInfo;
import com.zukmateusz.atiperiagit.model.RepositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GitHubService {
    private final RestTemplate restTemplate;
    private final String userNotExistMessage = "given github user not existing ";

    @Autowired
    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> getUserRepositoriesInfo(String userName) {
        try {
            RepositoryInfo[] repositoriesInfoArray = getRepositoryInfo(userName);
            List<RepositoryResponse> response = new ArrayList<>();
            for (RepositoryInfo repositoryInfo : repositoriesInfoArray) {
                if (!repositoryInfo.isFork()) {
                    BranchInfo[] branchesInfoArray = getBranchInfo(repositoryInfo);
                    response.add(new RepositoryResponse(repositoryInfo, branchesInfoArray));
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (HttpClientErrorException ex) {
            int statusCode = ex.getStatusCode().value();
            ErrorResponse errorResponse = new ErrorResponse(statusCode, userNotExistMessage);
            return ResponseEntity.status(statusCode).body(errorResponse);
        }
    }

    private RepositoryInfo[] getRepositoryInfo(String username) throws HttpClientErrorException {
        String repoInfoUrl = "https://api.github.com/users/" + username + "/repos";
        ResponseEntity<RepositoryInfo[]> repoInfoResponse = restTemplate.getForEntity(repoInfoUrl, RepositoryInfo[].class);
        return Objects.requireNonNull(repoInfoResponse.getBody());
    }

    private BranchInfo[] getBranchInfo(RepositoryInfo repositoryInfo) {
        String repositoryName = repositoryInfo.getName();
        String login = repositoryInfo.getOwner().getLogin();
        String branchInfoUrl = "https://api.github.com/repos/" + login + "/" + repositoryName + "/branches";
        ResponseEntity<BranchInfo[]> branchInfoResponse = restTemplate.getForEntity(branchInfoUrl, BranchInfo[].class);
        return branchInfoResponse.getBody();
    }
}
