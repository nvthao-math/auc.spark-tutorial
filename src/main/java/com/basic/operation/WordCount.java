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
public class WordCount extends SparkClient {

    public static void main(String[] args) {
        List<Tuple2<String, Tuple2<Integer, Long>>> list = Arrays.asList(new Tuple2("a", new Tuple2(2, 100l)), new Tuple2("a", new Tuple2(5, 200l)),
                new Tuple2("c", new Tuple2(20, 500l)), new Tuple2("d", new Tuple2(50, 300l)));
        JavaPairRDD<String, Tuple2<Integer, Long>> rdd = _jsc.parallelizePairs(list).reduceByKey((Tuple2<Integer, Long> tupleX, Tuple2<Integer, Long> tupleY) -> {
            Integer x = tupleX._1() + tupleY._1();
            Long y = tupleX._2() + tupleY._2();
            Tuple2<Integer, Long> result = new Tuple2(x, y);
            return result;
        });
        rdd.collect().forEach(x -> System.out.println(x));
    }

}
