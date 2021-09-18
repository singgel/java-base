package com.hks.eightsortingalgorithms.controller.sort;

import com.hks.eightsortingalgorithms.method.sort.SelectAlgorithms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "平均O(n²)、最好O(n²)、最坏O(n²)；空间复杂度：O(1)；稳定性：不稳定")
public class SelectAlgorithmsController {

    @Autowired
    SelectAlgorithms selectAlgorithms;

    @RequestMapping(value = "/selectSorting", method = RequestMethod.POST)
    @ApiOperation("选择排序")
    public int[] selectSorting(@RequestParam int[] intArr) {
        return selectAlgorithms.sort(intArr);
    }

}
