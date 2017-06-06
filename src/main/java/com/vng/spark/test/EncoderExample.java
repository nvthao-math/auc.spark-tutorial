/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.spark.test;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.functions;
import static org.apache.spark.sql.functions.col;
import scala.Tuple2;

/**
 *
 * @author thaonv
 */
public class EncoderExample {

    public static Gson GSON = new Gson();

    public static void main(String[] args) {
        final String APP_NAME = "SparkClient";
        final String MASTER = "local[*]"; // "local[4]";
        SparkConf conf = new SparkConf().setAppName(APP_NAME).setMaster(MASTER);
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        //
        List<String> data = Arrays.asList("abc", "abc", "xyz");
        Dataset<String> ds = sqlContext.createDataset(data, Encoders.STRING());
//        ds.select(ds.toDF().co)
        System.out.println("============================================");
        System.out.println("----> " + (ds));
        Object obj = ds.collect();
        System.out.println("----> " + GSON.toJson(obj));
        //
        Encoder<Tuple2<String, Integer>> encoder2 = Encoders.tuple(Encoders.STRING(), Encoders.INT());
        List<Tuple2<String, Integer>> data2 = Arrays.asList(new Tuple2("a", 1), new Tuple2("a", 12), new Tuple2("b", 4), new Tuple2("b", 3), new Tuple2("c", 18));
        Dataset<Tuple2<String, Integer>> ds2 = sqlContext.createDataset(data2, encoder2);
        ds2.show();
        //
        List<Employee> listEmployee = Arrays.asList(new Employee("111", "john", 21, 2000), new Employee("222", "mary", 21, 2000),
                new Employee("333", "john", 40, 1500), new Employee("444", "ben", 40, 4000));
//        Dataset<Employee> empDs = sqlContext.createDataset(listEmployee, Encoders.bean(Employee.class));
        DataFrame empDf = sqlContext.createDataFrame(listEmployee, Employee.class);
        empDf.show();
        DataFrame AgeDf = empDf.select(empDf.col("age").plus(5).alias("age +5"), col("name").alias("name-age"));
        AgeDf.show();
        // query 
        empDf.select(empDf.col("age")).filter("age > 20").groupBy(empDf.col("age")).agg(functions.max(empDf.col("salary")).alias("avg-s")).show();
//        for (Row val : empAvg) {
//            System.out.println(val.get(0) + ", " + val.get(1) + ", " + val.get(2));
//        }
    }

}
