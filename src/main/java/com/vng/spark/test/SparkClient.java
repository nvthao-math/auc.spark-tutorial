/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.spark.test;

import java.util.ArrayList;
import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 *
 * @author thaonv
 */
public class SparkClient {

    public static void main(String[] args) {
        System.out.println("Hallo Spark from Java!");

        final String APP_NAME = "SparkClient";
        final String MASTER = "local[*]"; // "local[4]";

        SparkConf conf = new SparkConf().setAppName(APP_NAME).setMaster(MASTER);
        conf.setJars(new String[]{"/home/cpu10869-local/NetBeansProjects/spark-test/target/first-example-1.0-SNAPSHOT.jar"});
        JavaSparkContext sc = new JavaSparkContext(conf);

        List tasks = new ArrayList();
        for (int i = 0; i < 16; i++) {
            tasks.add("Task: " + i);
        }
        //Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");

        JavaRDD<String> parallelTasks = sc.parallelize(tasks, 16);

        Mapper m = new Mapper();
        String result = parallelTasks
                .map(m::mapper)
                .reduce((a, b) -> a + "," + b);

        System.out.println(result);
    }

}
