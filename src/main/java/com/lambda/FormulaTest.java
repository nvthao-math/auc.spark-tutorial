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
public class FormulaTest {

    public static void main(String[] args) {
        FormulaImpl imp = new FormulaImpl();
        double cal = imp.calculate(10);
        System.out.println(cal);
        double sq = imp.sqrt((int) 10.0);
        System.out.println(sq);
    }

}
