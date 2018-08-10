package com.hks.eightsortingalgorithms.controller;

import com.hks.eightsortingalgorithms.method.StraightInsertAlgorithms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "直接插入排序")
public class StraightInsertAlgorithmsController {

    @Autowired
    StraightInsertAlgorithms straightInsertAlgorithms;

    @RequestMapping(value = "/SelectHeapSorting", method = RequestMethod.POST)
    @ApiOperation("直接插入排序")
    public int[] straightInsertSorting(@RequestParam int[] args){
        return straightInsertAlgorithms.sort(args);
    }

}
