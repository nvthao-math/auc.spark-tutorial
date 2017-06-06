/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.model;

import java.io.Serializable;

/**
 *
 * @author thaonv
 */
public class AvgInstance implements Serializable {

    private int number;
    private int count;

    public AvgInstance(int number, int count) {
        this.number = number;
        this.count = count;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    public void increase(int number) {
        this.number += number;
        this.count += 1;
    }

    public void increase(int number, int count) {
        this.number += number;
        this.count += count;
    }

    public double average() {
        return this.number / this.count;
    }

}
