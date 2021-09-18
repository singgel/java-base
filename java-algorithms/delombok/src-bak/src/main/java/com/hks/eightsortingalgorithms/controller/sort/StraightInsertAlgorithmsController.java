package com.hks.eightsortingalgorithms.controller.sort;

import com.hks.eightsortingalgorithms.method.sort.StraightInsertAlgorithms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "平均O(n²)、最好O(n)、最坏O(n²)；空间复杂度：O(1)；稳定性：稳定")
public class StraightInsertAlgorithmsController {

    @Autowired
    StraightInsertAlgorithms straightInsertAlgorithms;

    @RequestMapping(value = "/straightInsertSorting", method = RequestMethod.POST)
    @ApiOperation("直接插入排序")
    public int[] straightInsertSorting(@RequestParam int[] args){
        return straightInsertAlgorithms.sort(args);
    }

}
