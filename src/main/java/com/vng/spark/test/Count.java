/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.spark.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author thaonv
 */
public class Count {

    private static final String FILENAME = "/home/cpu10869-local/sandbox/VOIP/collector6577_08_VOIP_2017_04_10_08_33_14_535.log";

    public static void main(String[] args) {
        int count = 0;
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            br = new BufferedReader(new FileReader(FILENAME));
            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
                String[] parts = sCurrentLine.split("\t");
//                System.out.println(parts[6]);
                if (parts[6].equals("406") || parts[6].equals("3071")) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Total records: " + count);
    }

}
