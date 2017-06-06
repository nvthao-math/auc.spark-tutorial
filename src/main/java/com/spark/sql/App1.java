/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spark.sql;

import com.google.gson.Gson;
import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;

/**
 *
 * @author thaonv
 */
public class App1 {

    public static Gson GSON = new Gson();

    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("App1").setMaster("local[*]");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        //
        SQLContext sqlSpark = new SQLContext(jsc);
        String logFile = "/home/cpu10869-local/workspace/tools/spark/spark-2.1.0-bin-hadoop2.7/README.md";
        JavaRDD<String> logData = jsc.textFile(logFile).cache();
        List<String> listA = logData.filter(line -> {
            return line.contains("a");
        }).collect();
        //
        for (String val : listA) {
            System.out.println(val);
        }
        
        jsc.close();

    }

}
