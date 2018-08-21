package com.hks.eightsortingalgorithms.controller;

import com.hks.eightsortingalgorithms.method.QuickAlgorithms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "快速排序（平均O(n*lg(n))、最好O(n*lg(n))、最坏O(n²)；空间复杂度：O(n*lg(n))；稳定性：不稳定）")
public class QuickAlgorithmsController {

    @Autowired
    QuickAlgorithms quickAlgorithms;

    @RequestMapping(value = "/quickSorting", method = RequestMethod.POST)
    @ApiOperation("快速排序")
    public int[] quickSorting(@RequestParam int[] intArr) {
        return quickAlgorithms.sort(intArr);
    }

}
