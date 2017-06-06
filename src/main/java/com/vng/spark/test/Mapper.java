/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.spark.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thaonv
 */
public class Mapper {

    public String mapper(Object o) {
        try {
            long sum = 0;
            for (long i = 0; i < 10000000; i++) {
                sum += Math.random() * 100;
            }
            return InetAddress.getLocalHost().toString() + " (" + sum + ")";
        } catch (UnknownHostException ex) {
            Logger.getLogger(SparkClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

}
