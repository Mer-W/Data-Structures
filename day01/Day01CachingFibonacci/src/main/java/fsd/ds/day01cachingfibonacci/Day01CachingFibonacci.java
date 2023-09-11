/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fsd.ds.day01cachingfibonacci;

/**
 *
 * @author mer
 */
public class Day01CachingFibonacci {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci(false);

        System.out.println(fib.toString());

        int n = 80;

        long timer = System.currentTimeMillis();

        System.out.println("get fib n = " + n + ": " + fib.getNthFib(n));

        // System.out.println(fib.toString());
        System.out.println("fibs computed: " + fib.fibsCompCount);

        System.out.println("\ntime elapsed: " + (System.currentTimeMillis() - timer));

        Fibonacci fibCached = new Fibonacci(true);

        System.out.println("\n\n");

        long timer2 = System.currentTimeMillis();

        System.out.println("get fib n = " + n + ": " + fibCached.getNthFib(n));


        
        System.out.println("fibs computed: " + fibCached.fibsCompCount);

        System.out.println("\ntime elapsed: " + (System.currentTimeMillis() - timer2));

//              n = 20;
//              
//                     System.out.println("get fibCached n = " + n + ": " + fibCached.getNthFib(n));
//       
                  System.out.println("\n" + fibCached.toString());
//              
//              System.out.println("fibs computed: " + fibCached.fibsCompCount);
    }
}
