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
public class Subtraction extends SparkClient {

    public static void main(String[] args) {
        List<Tuple2<String, Integer>> listEmp = Arrays.asList(new Tuple2("John", 1122), new Tuple2("Kenedy", 2233),
                new Tuple2("Mary", 3344), new Tuple2("Bob", 4455), new Tuple2("Shoma", 5566));
        List<Tuple2<String, Integer>> listStaff = null;//Arrays.asList(new Tuple2("John", 1122), new Tuple2("Mary", 3344));
        JavaPairRDD<String, Integer> empRDD = _jsc.parallelizePairs(listEmp);
        JavaPairRDD<String, Integer> staffRDD = _jsc.parallelizePairs(listStaff);
        // subtraction by key
        List<Tuple2<String, Integer>> listSubtract = empRDD.subtractByKey(staffRDD).collect();
        System.out.println("------- List of subtraction ------");
        for (Tuple2<String, Integer> val : listSubtract) {
            System.out.println(val._1() + ", " + val._2());
        }
        // intersect 
        List<Tuple2<String, Integer>> listIntersect = empRDD.intersection(staffRDD).collect();
        System.out.println("----- List of Intersection ------");
        for (Tuple2<String, Integer> val : listIntersect) {
            System.out.println(val._1() + ", " + val._2());
        }
    }

}
