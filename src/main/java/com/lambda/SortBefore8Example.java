/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author thaonv
 */
public class SortBefore8Example {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Grapefruit", "Apple", "Durian", "Cherry");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String val : list) {
            System.out.println(val);
        }
    }

}
