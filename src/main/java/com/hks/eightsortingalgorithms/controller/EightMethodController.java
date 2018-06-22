package com.hks.eightsortingalgorithms.controller;

import com.hks.eightsortingalgorithms.method.SelectAlgorithms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EightMethodController {

    @Autowired
    SelectAlgorithms selectAlgorithms;

    @RequestMapping(value = "/selectSorting")
    public void selectSorting(){

    }

}
