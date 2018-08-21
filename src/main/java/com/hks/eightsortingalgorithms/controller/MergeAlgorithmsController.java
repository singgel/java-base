package com.hks.eightsortingalgorithms.controller;

import com.hks.eightsortingalgorithms.method.MergeAlgorithms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "归并排序（平均O(n*lg(n))、最好O(n*lg(n))、最坏O(n*lg(n))；空间复杂度：O(1)；稳定性：稳定）")
public class MergeAlgorithmsController {

    @Autowired
    MergeAlgorithms mergeAlgorithms;

    @RequestMapping(value = "/mergeSorting", method = RequestMethod.POST)
    @ApiOperation("归并排序")
    public int[] mergeSorting(@RequestParam int[] intArr) {
        return mergeAlgorithms.sort(intArr);
    }

}
