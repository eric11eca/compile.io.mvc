package com.compile.io.application.controller;

import com.compile.io.application.entity.UploadFile;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UploadController {
    @PostMapping(value="/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String newEmployee(@RequestBody UploadFile newFile) {
        System.out.println(newFile.getUsername());
        System.out.println(newFile.getAssignment());
        return "Submitted";
    }
}
