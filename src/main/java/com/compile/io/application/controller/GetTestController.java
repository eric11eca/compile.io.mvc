package com.compile.io.application.controller;

import com.compile.io.application.domain.RetrieveTestResultsLogic;
import com.compile.io.application.entity.TestRecords;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class GetTestController {
    @GetMapping("/getTests")
    @ResponseBody
    public TestRecords upload(@RequestParam(name = "id") String username) {
        RetrieveTestResultsLogic retrieveTestResultsLogic = new RetrieveTestResultsLogic();
        return retrieveTestResultsLogic.retrieveTestRecords(username);
    }
}
