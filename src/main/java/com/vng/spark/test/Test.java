/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.spark.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

/**
 *
 * @author thaonv
 */
public class Test {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("App1").setMaster("local[*]");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        //
        List<Tuple2<String, Long>> listA = Arrays.asList(new Tuple2("a", 12l), new Tuple2("c", 11l), new Tuple2("b", 10l));
        JavaPairRDD<String, Long> aRDD = jsc.parallelizePairs(listA).distinct();
        aRDD.foreach(x -> System.out.println(x));
        //
        List<Integer> listB = Arrays.asList(1, 2, 1, 3);
        System.out.println("-----------------------------------");
        Map<String, Long> map = aRDD.collectAsMap();
        System.out.println(map);

    }

}
