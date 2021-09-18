package com.hks.eightsortingalgorithms.controller.search;

import com.hks.eightsortingalgorithms.method.search.BinarySearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "二分查找")
public class BinarySearchController {

    @Autowired
    BinarySearch binarySearch;

    @RequestMapping(value = "/binarySearch", method = RequestMethod.POST)
    @ApiOperation("二分查找")
    public int binarySearch(@ApiParam("intArr数组要有序")@RequestParam int[] intArr, @RequestParam int key) {
        return binarySearch.search(intArr, key);
    }

}
