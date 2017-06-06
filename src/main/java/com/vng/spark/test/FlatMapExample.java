///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vng.spark.test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.SparkConf;
//
///**
// *
// * @author thaonv
// */
//public class FlatMapExample {
//
//    public static void main(String[] args) throws Exception {
//        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("FlatMapExample");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//
//        // Parallelized with 2 partitions
//        JavaRDD<String> rddX = sc.parallelize(
//                Arrays.asList("spark rdd example", "sample example"),
//                2);
//
//        // map operation will return List of Array in following case
//        JavaRDD<String[]> rddY = rddX.map(e -> e.split(" "));
//        List<String[]> listUsingMap = rddY.collect();
//
//        // flatMap operation will return list of String in following case
//        JavaRDD<String> rddY2 = rddX.flatMap(e -> Arrays.asList(e.split(" ")).iterator());
//        List<String> listUsingFlatMap = rddY2.collect();
//    }
//
//}
