/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day01cachingfibonacci;

import java.util.HashMap;

/**
 *
 * @author mer
 */
public class Fibonacci {

    private boolean isCacheOn;

    private HashMap<Integer, Long> fibsCached = new HashMap<>();
    
    private int fibsCompCount = 2; // may not be needed

    Fibonacci(boolean cacheOn) {
        isCacheOn = cacheOn;
        fibsCached.put(0, 0L); // #0
        fibsCached.put(1, 1L); // #1
    }
}
