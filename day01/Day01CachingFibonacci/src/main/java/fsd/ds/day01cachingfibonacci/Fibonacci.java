/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day01cachingfibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *
 * @author mer
 */
public class Fibonacci {

    private boolean isCacheOn;

    HashMap<Integer, BigInteger> fibsCached = new HashMap<>();

    int fibsCompCount = 2; // may not be needed

    Fibonacci(boolean cacheOn) {
        isCacheOn = cacheOn;
        fibsCached.put(0, BigInteger.valueOf(0)); // #0
        fibsCached.put(1, BigInteger.valueOf(1)); // #1
    }
//
//    public long getNthFib(int n) {
//
//        if (n <= 1) {
//            return n;
//        }
//        return getNthFib(n - 1) + getNthFib(n - 2);
//    }
//    

    public BigInteger getNthFib(int n) {

        if (n <= 1) {
            
            return BigInteger.valueOf(n);

        } else if (isCacheOn && fibsCached.containsKey(n)) {

            return fibsCached.get(n);

        } else if (isCacheOn && !fibsCached.containsKey(n)) {

            int i = n;

            while (!fibsCached.containsKey(i)) {

                i--;
            }

            while (!fibsCached.containsKey(n)) {

                BigInteger first = fibsCached.get(i - 1);
                BigInteger second = fibsCached.get(i);
                BigInteger nth = first.add(second);
                
                fibsCached.put(i + 1, nth);
                fibsCompCount++;
                i++;

            }
            return fibsCached.get(n);
        } 

        // if not caching 
        
        BigInteger first = BigInteger.valueOf(0);
        BigInteger second = BigInteger.valueOf(1);
        BigInteger nth = BigInteger.valueOf(1);

        for (int i = 2; i <= n; i++) {

            nth = first.add(second);
            first = second;
            second = nth;
            fibsCompCount++;
        }
        return nth;
    }

    @Override
    public String toString() { // returns all cached Fib values, comma-space-separated on a single line
        // return String.join(", ", fibsCached.values());

        // String str = fibsCached.keySet().stream().map(key -> fibsCached.get(key)).collect(Collectors.joining(", ", "{", "}"));
        String str = fibsCached.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));

        return str;
    }

}
