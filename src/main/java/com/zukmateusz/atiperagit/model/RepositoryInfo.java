package com.zukmateusz.atiperagit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RepositoryInfo {
    private String name;
    private boolean fork;
    private Owner owner;
}
