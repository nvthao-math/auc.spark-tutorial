/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.operation;

import com.spark.config.SparkClient;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

/**
 *
 * @author thaonv
 */
public class ToMap extends SparkClient {

    public static void main(String[] args) {
        List<Tuple2<Long, String>> listEmp = Arrays.asList(new Tuple2(112233, "John"), new Tuple2(445566, "Tony"), new Tuple2(887799, "Thomas"));
        JavaPairRDD<Long, String> rdd = _jsc.parallelizePairs(listEmp);
        Map<Long, String> map = rdd.collectAsMap();
        System.out.println(map);
    }

}
