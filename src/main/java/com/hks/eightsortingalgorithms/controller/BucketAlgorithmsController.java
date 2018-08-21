package com.hks.eightsortingalgorithms.controller;

import com.hks.eightsortingalgorithms.method.BucketAlgorithms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "基数排序（桶排序）（平均O(d(r+n))、最好O(d(n+rd))、最坏O(d(r+n))；空间复杂度：O(rd+n)；稳定性：稳定）")
public class BucketAlgorithmsController {

    @Autowired
    BucketAlgorithms bucketAlgorithms;

    @RequestMapping(value = "/bucketSorting", method = RequestMethod.POST)
    @ApiOperation("基数排序（桶排序）")
    public int[] bucketSorting(int[] intArr){
        return bucketAlgorithms.sort(intArr);
    }

}
