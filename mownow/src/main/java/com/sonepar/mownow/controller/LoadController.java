package com.sonepar.mownow.controller;


import com.sonepar.mownow.models.Mower;
import com.sonepar.mownow.service.MowerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
class LoadController {

    private final MowerService mowerService;

    public LoadController(MowerService mowerService) {
        this.mowerService = mowerService;
    }

    @GetMapping("/")
    public String index() {
        return mowerService
                .initMower("src/main/resources/example1.txt")
                .stream()
                .map(Mower::orient)
                .map(Mower::toString)
                .collect(Collectors.joining(System.getProperty("line.separator")));
    }


}
