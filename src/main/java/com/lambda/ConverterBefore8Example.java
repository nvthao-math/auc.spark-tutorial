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
public class ConverterBefore8Example {

    public static void main(String[] args) {
        Converter<String, Integer> converter = new Converter<String, Integer>() {
            @Override
            public String convert(Integer from) {
                return Integer.toString(from);
            }
        };
        //
        String str = converter.convert(10);
        System.out.println(str);
    }

}
