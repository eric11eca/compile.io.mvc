package com.compile.io.application.controller;

import com.compile.io.application.domain.TestLogic;
import com.compile.io.application.entity.AssignmentList;
import com.compile.io.application.entity.TestRecords;
import com.compile.io.application.entity.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AssignmentTestController {
    private TestLogic testLogic;

    @Autowired
    public AssignmentTestController(TestLogic testLogic) {
        this.testLogic = testLogic;
    }

    @PostMapping(value = "/getAssignments", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    AssignmentList getAllAssignments() {
        return new AssignmentList(testLogic.getAllAssignments());
    }

    @PostMapping(value="/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    TestRecords runTestCases(@RequestBody UploadFile newFile) {
        System.out.println(newFile.getAssignment());
        testLogic.runTestCases(newFile.getFileContent(), newFile.getAssignment(), newFile.getUsername());
        return testLogic.getTestsByUserNameAssignment( newFile.getUsername(), newFile.getAssignment());
    }
}
