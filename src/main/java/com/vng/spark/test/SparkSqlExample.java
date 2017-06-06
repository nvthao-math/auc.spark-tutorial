/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.spark.test;

import com.google.gson.Gson;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.functions;
import static org.apache.spark.sql.functions.col;

/**
 *
 * @author thaonv
 */
public class SparkSqlExample {

    public static Gson GSON = new Gson();

    public static void main(String[] args) {
        final String APP_NAME = "SparkClient";
        final String MASTER = "local[*]"; // "local[4]";
        SparkConf conf = new SparkConf().setAppName(APP_NAME).setMaster(MASTER);
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        System.out.println("============================================");
        DataFrame df = sqlContext.read().json("/home/cpu10869-local/workspace/data/test/employee");
//        df.schema().add(Employee.class);
        df.show();
        System.out.println("============================================");
        df.printSchema();
        System.out.println("============================================");
        df.select("name").show();
        df.select("id").show();
        df.select("age").show();
        df.select("age", "id").show();
        System.out.println("===================== AGE PLUS +1 =======================");
        df.select(col("name"), col("age").plus(1)).show();
        System.out.println("=============================");
        df.filter(col("age").gt(26)).show();
        System.out.println("=============================");
        df.groupBy("age").count().show();
        //
        System.out.println("==============================");
        df.registerTempTable("people");
        DataFrame older = sqlContext.sql("SELECT name, id FROM people WHERE age BETWEEN 22 AND 29");
//        Row[] rows = older.collect();
        //
        DataFrame dfPost = df.groupBy(col("age")).agg(functions.countDistinct(col("name")).alias("NAME"), functions.countDistinct(col("id")).alias("ID"));
//        for (Row val : rows) {
//            System.out.println(val);
//        }
        dfPost.show();
    }

}
