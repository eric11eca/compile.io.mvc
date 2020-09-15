package com.compile.io.application.entity;

import java.util.Set;

public class AssignmentList {
    private Set<String> allAssignments;

    public AssignmentList(Set<String> allAssignments) {
        this.allAssignments = allAssignments;
    }

    public Set<String> getAllAssignments() {
        return allAssignments;
    }
}
