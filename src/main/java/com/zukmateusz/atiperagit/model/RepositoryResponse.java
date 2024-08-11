package com.zukmateusz.atiperagit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RepositoryResponse {
    String name;
    String owner;
    BranchInfo [] branchInfo;

    public RepositoryResponse(RepositoryInfo repositoryInfo, BranchInfo[] branchInfo) {
        this.name = repositoryInfo.getName();
        this.owner = repositoryInfo.getOwner().getLogin();
        this.branchInfo = branchInfo;
    }
}
