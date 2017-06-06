/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lambda;

/**
 *
 * @author thaonv
 */
public class ConveterJava8Example {

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.toString(from);
        String str = converter.convert(100);
        System.out.println(str);
    }

}
