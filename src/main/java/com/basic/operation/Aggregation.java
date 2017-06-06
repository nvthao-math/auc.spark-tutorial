/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.operation;

import com.basic.model.AvgInstance;
import com.spark.config.SparkClient;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author thaonv
 */
public class Aggregation extends SparkClient {

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        AvgInstance avgData = execute(data);
        System.out.println("Number: " + avgData.getNumber() + ", " + "count: " + avgData.getCount());
        System.out.println("average: " + avgData.average());

    }

    public static AvgInstance execute(List<Integer> data) {
        AvgInstance result = new AvgInstance(0, 0);
        result = _jsc.parallelize(data).aggregate(result, (AvgInstance inst, Integer x) -> {
            inst.increase(x);
            return inst;
        }, (AvgInstance instX, AvgInstance instY) -> {
            instX.increase(instY.getNumber(), instY.getCount());
            return instX;
        });
        return result;
    }

}
