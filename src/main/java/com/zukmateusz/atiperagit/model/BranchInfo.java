package com.zukmateusz.atiperagit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BranchInfo {
    private String name;
    private CommitInfo commit;
}
