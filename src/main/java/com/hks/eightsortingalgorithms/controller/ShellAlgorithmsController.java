package com.hks.eightsortingalgorithms.controller;

import com.hks.eightsortingalgorithms.method.ShellAlgorithms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "希尔排序")
public class ShellAlgorithmsController {

    @Autowired
    ShellAlgorithms shellAlgorithms;

    @RequestMapping("/shellSorting")
    @ApiOperation("希尔排序")
    public int[] shellSorting(int[] args){
        return shellAlgorithms.sort(args);
    }

}
