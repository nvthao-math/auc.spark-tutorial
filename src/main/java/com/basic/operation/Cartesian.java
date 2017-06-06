/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.operation;

import com.spark.config.SparkClient;
import java.util.Arrays;
import java.util.List;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

/**
 *
 * @author thaonv
 */
public class Cartesian extends SparkClient {

    public static void main(String[] args) {
        List<Integer> listX = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listY = Arrays.asList(6, 7, 8, 9);
        JavaRDD<Integer> xRDD = _jsc.parallelize(listX);
        JavaRDD<Integer> yRDD = _jsc.parallelize(listY);
        JavaPairRDD<Integer, Integer> result = xRDD.cartesian(yRDD);
        result.collect().forEach(x -> System.out.println(x));
    }

}
