package com.hks.eightsortingalgorithms.controller;

import com.hks.eightsortingalgorithms.method.SelectHeapAlgorithms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "平均O(n*lg(n))、最好O(n*lg(n))、最坏O(n*lg(n))；空间复杂度：O(1)；稳定性：不稳定")
public class SelectHeapAlgorithmsController {

    @Autowired
    SelectHeapAlgorithms selectHeapAlgorithms;

    @RequestMapping(value = "/SelectHeapSorting", method = RequestMethod.POST)
    @ApiOperation("选择堆排序")
    public int[] SelectHeapSorting(@RequestParam int[] intArr){
        return selectHeapAlgorithms.sort(intArr);
    }


}
