package com.robosh.ejournal.controller;


import com.robosh.ejournal.service.SubmitHomeworkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submit-homework")
@AllArgsConstructor
public class SubmitHomeworkController {

    private final SubmitHomeworkService submitHomeworkService;

    @GetMapping("/submit")
    public String submitTest() {
        return submitHomeworkService.createFile();
    }

    @GetMapping("/show-directory")
    public String showDirectory() {
        return submitHomeworkService.showDirectory();
    }

    @GetMapping("/start-shell")
    public String startShellScript() {
        return submitHomeworkService.startShellScript();
    }
}
