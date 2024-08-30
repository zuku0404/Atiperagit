package com.zukmateusz.atiperagit.model;

import java.util.List;

public record RepositoryResponse(
        String name,
        String owner,
        List<BranchInfo> branches
) {}