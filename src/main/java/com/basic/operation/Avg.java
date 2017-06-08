/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.operation;

import com.basic.model.AvgInstance;
import static com.basic.operation.Aggregation.execute;
import com.spark.config.SparkClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

/**
 *
 * @author thaonv
 */
public class Avg extends SparkClient {

    public static void main(String[] args) {
        List<Tuple2<String, Double>> data = Arrays.asList(new Tuple2("a", 1.0), new Tuple2("a", 4.0), new Tuple2("a", 5.0),
                new Tuple2("a", 1.0), new Tuple2("a", 1.0), new Tuple2("a", 1.0),
                new Tuple2("c", 6.0), new Tuple2("c", 3.0));
        JavaPairRDD<String, Tuple2<Double, Long>> rdd = _jsc.parallelizePairs(data)
                .flatMapToPair((Tuple2<String, Double> tuple) -> toAvg(tuple))
                .reduceByKey((Tuple2<Double, Long> tx, Tuple2<Double, Long> ty) -> new Tuple2(tx._1() + ty._1(), tx._2() + ty._2()));
//        rdd.foreach(val -> System.out.println(val));
        for (Tuple2<String, Tuple2<Double, Long>> val : rdd.collect()) {
            System.out.println(val);
            double avg = val._2()._1() / val._2()._2();
            System.out.println(val._1() + ", " + avg);
        }
    }

    private static List<Tuple2<String, Tuple2<Double, Long>>> toAvg(Tuple2<String, Double> tuple) {
        List<Tuple2<String, Tuple2<Double, Long>>> result = new ArrayList<>();
        result.add(new Tuple2(tuple._1(), new Tuple2(tuple._2(), 1l)));
        return result;
    }

}
