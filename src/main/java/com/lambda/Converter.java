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
@FunctionalInterface
public interface Converter<T, F> {

    T convert(F from);

}
