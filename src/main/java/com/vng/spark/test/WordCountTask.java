///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vng.spark.test;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import com.google.gson.Gson;
//import java.util.Arrays;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaSparkContext;
//import scala.Tuple2;
//
///**
// *
// * @author thaonv
// */
//public class WordCountTask {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(WordCountTask.class);
//
//    public static void main(String[] args) {
//        String path = "/home/cpu10869-local/sandbox/VOIP/test_raw.txt";
////        new WordCountTask().run(path);
////
////        checkArgument(args.length > 1, "Please provide the path of input file as first parameter.");
////        new WordCountTask().run(args[0]);
//        new WordCountTask().run(path);
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(path));
//    }
//
//    public void run(String inputFilePath) {
//        String master = "local[*]";
////        String master = "spark://cpu10869:7077";
//        //
//        SparkConf conf = new SparkConf()
//                .setAppName(WordCountTask.class.getName())
//                .setMaster(master)
//                .set("spark.ui.port‌​", "7077")
//                .set("spark.executor.instances", "2")
//                .set("spark.executor.cores", "4")
//                .set("spark.eventLog.enabled", "true")
//                .set("spark.eventLog.dir", "/home/cpu10869-local/NetBeansProjects/spark-job/")
//                //                .setJars(SparkContext.jarOfClass(this.getClass()).)
//                //                .setJars(new String[]{"target/first-example-1.0-SNAPSHOT.jar"})
//                .set("spark.executor.memory", "1g");
//        JavaSparkContext context = new JavaSparkContext(conf);
//        context.textFile(inputFilePath)
//                .flatMap(text -> Arrays.asList(text.split("\t")).iterator())
//                .mapToPair(word -> new Tuple2<>(word, 1))
//                .reduceByKey((a, b) -> {
//                    int sum = 0;
//                    sum = a + b;
//                    return sum;
//                })
//                .foreach(result -> LOGGER.info(
//                String.format("Word [%s] count [%s].", result._1(), result._2)));
//    }
//
//    public static class Pixel {
//
//        private int x;
//        private int y;
//
//        public Pixel(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public String toString() {
//            return x + ", " + y;
//        }
//        
//    }
//    
////        public static void test(String inputFilePath) {
////        String master = "local[*]";
////        //
////        SparkConf conf = new SparkConf()
////                .setAppName(VOIPStatsJob.class.getName())
////                .setMaster(master)
////                .set("spark.ui.port‌​", "7077")
////                .set("spark.executor.instances", "2")
////                .set("spark.executor.cores", "4")
////                .set("spark.executor.memory", "1g");
////        JavaSparkContext sc = new JavaSparkContext(conf);
////        // Load the input data, which is a text file read from the command line
////        JavaRDD<String> input = sc.textFile(inputFilePath);
////        JavaPairRDD<String, Integer> timePhone = input.flatMap(line -> Arrays.asList(line.split("\t")))
////                .mapToPair(t -> new Tuple2(t, 1))
////                .reduceByKey((x, y) -> (int) x + (int) y);
////        System.out.println("========= VALUE =======");
////        timePhone.foreach(result -> LOGGER.info(result._1() + ", " + result._2()));
//////        System.out.println(counts.values());
//////        counts.saveAsTextFile("/home/cpu10869-local/sandbox/VOIP/result.txt");
////    }
//
//}
