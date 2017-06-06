///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vng.spark.test;
//
//import com.google.gson.Gson;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaPairRDD;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import scala.Tuple2;
//
///**
// *
// * @author thaonv
// */
//public class wordCountJava8 {
//
//    public static Gson GSON = new Gson();
//
//    public static void main(String[] args) {
//        String path = "/home/cpu10869-local/sandbox/VOIP/test_raw.txt";
//        Tuple2<Integer, Integer> var01 = new Tuple2<>(100, 200);
//        Tuple2<Integer, Integer> var02 = new Tuple2<>(200, 400);
//        Tuple2<Integer, Integer> var03 = new Tuple2<>(var01._1() + var02._1(), var01._2() + var02._2());
//        System.out.println(GSON.toJson(var03));
//        //
////        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("test-wordcount");
////        JavaSparkContext sc = new JavaSparkContext(conf);
////        JavaRDD<String> input = sc.textFile(path);
////        JavaRDD<String> words = input.flatMap(line -> Arrays.asList(line.split("\t")).iterator());
////        JavaPairRDD<String, Integer> counts = words.mapToPair(t -> new Tuple2(t, 1))
////                .reduceByKey((x, y) -> (int) x + (int) y);
////        List<Tuple2<String, Integer>> result = counts.collect();
////        System.out.println("------------------" + GSON.toJson(result));
////
////
//        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("test-wordCount");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//        JavaRDD<String> input = sc.textFile(path);
//        List<Tuple2<String, Integer>> result = input.flatMapToPair(line -> getLine(line).iterator()).reduceByKey((x, y) -> x + y).collect();
//        for (Tuple2<String, Integer> val : result) {
//            System.out.println("key: " + val._1() + ", value: " + val._2());
//        }
//    }
//
//    public static List<Tuple2<String, Integer>> getLine(String line) {
//        List<Tuple2<String, Integer>> data = new ArrayList<>();
//        String[] parts = line.split("\t");
//        for (String str : parts) {
//            data.add(new Tuple2(str, 1));
//        }
//        return data;
//    }
//
//}
