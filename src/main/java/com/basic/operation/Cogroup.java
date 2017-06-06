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
import scala.Tuple2;

/**
 *
 * @author thaonv
 */
public class Cogroup extends SparkClient {

    public static void main(String[] args) {
        List<Tuple2<Integer, String>> listX = Arrays.asList(new Tuple2(1, "apple"), new Tuple2(2, "banana"),
                new Tuple2(3, "orange"), new Tuple2(4, "kiwi"));
        List<Tuple2<Integer, String>> listY = Arrays.asList(new Tuple2(5, "computer"), new Tuple2(1, "laptop"),
                new Tuple2(1, "desktop"), new Tuple2(4, "iPad"));
        List<Tuple2<Integer, Integer>> listZ = Arrays.asList(new Tuple2(1, 1000l), new Tuple2(2, 2000l));
        JavaPairRDD<Integer, String> xRDD = _jsc.parallelizePairs(listX);
        JavaPairRDD<Integer, String> yRDD = _jsc.parallelizePairs(listY);
        JavaPairRDD<Integer, Integer> zRDD = _jsc.parallelizePairs(listZ);
        JavaPairRDD gRDD = xRDD.cogroup(yRDD, zRDD);
        gRDD.collect().forEach(x -> System.out.println(x));
    }

}
