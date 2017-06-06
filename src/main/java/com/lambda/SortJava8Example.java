/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author thaonv
 */
// "Grapefruit", "Apple", "Durian", "Cherry"
public class SortJava8Example {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Grapefruit", "Apple", "Durian", "Cherry");
//        Collections.sort(list, String::compareTo);
        Collections.sort(list, (val01, val02) -> {
            return val01.compareTo(val02);
        });
        list.forEach((val) -> System.out.println(val));
    }

}
