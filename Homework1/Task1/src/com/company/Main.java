package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number in binary format");
        String input = scan.next();
        task1(input);
        System.out.println("Input number to opposite one: ");
        task2(scan.nextInt());
        task3();
        System.out.println("Input a, b: ");
        task4(scan.nextInt(),scan.nextInt());
        System.out.println("Input number and position of bit: ");
        task5(scan.nextInt(), scan.nextInt());
    }

    private static void task1(String input){
        int num=0;
        for (int i = 0; i < input.length(); i++){
            if(input.charAt(input.length()-i-1)=='1'){
               num+= 1 << i;
            }
        }
        System.out.println(num);
    }

    private static void task2(int number){
        int opositeSign = ~number + 1;
        System.out.println("Oposite number: " + opositeSign);
    }

    private static void task3(){
        byte a = Byte.MAX_VALUE;
        int count = 1;
        while (a != 0){
            count++;
            a  = (byte) (a >>1);
        }
        System.out.println("Number of bits in byte: " + count);

        short b = Short.MAX_VALUE;
        count = 1;
        while (b != 0){
            count++;
            b  = (short) (b >>1);
        }
        System.out.println("Number of short in byte: " + count);

        int c = Integer.MAX_VALUE;
        count = 1;
        while (c != 0){
            count++;
            c  = (c >>1);
        }
        System.out.println("Number of bits in int: " + count);

        long d = Long.MAX_VALUE;
        count = 1;
        while (d != 0){
            count++;
            d  =  (d >>1);
        }
        System.out.println("Number of bits in long: " + count);
    }

    private static void task4(int a, int b){
        System.out.println("GCD: " + myGcd(a,b));
    }

    private static void task5(int num, int pos){
        int res = 1 << pos;
        System.out.println("Initial number: " + Integer.toBinaryString(num));
        System.out.println("Changed number: " + Integer.toBinaryString(res^num));
    }

    private static int gcd(int u, int v)
    {
        int shift;

        /* НОД(0, n) = n; НОД(m, 0) = m. */
        if (u == 0 || v == 0)
            return u | v;

        for (shift = 0; ((u | v) & 1) == 0; ++shift)
        {
            u >>= 1;
            v >>= 1;
        }

        while ((u & 1) == 0)
            u >>= 1;

        do
        {
            while ((v & 1) == 0)
                v >>= 1;

            if (u < v)
            {
                v -= u;
            }
            else
            {
                int diff = u - v;
                u = v;
                v = diff;
            }

            v >>= 1;
        }
        while (v != 0);

        return u << shift;
    }

    private static int myGcd(int m, int n){
         /*
            Алгоритм
            1. НОД(0, n) = n; НОД(m, 0) = m;
            2. Если m, n чётные, тогда НОД(m, n) = 2 * НОД(m / 2, n / 2).
            3. Если m чётное, тогда НОД(m, n) = НОД(m / 2, n).
            4. Если n чётное, тогда НОД(m, n) = НОД(m, n / 2).
            5. Если m, n нечётные и m > n, тогда НОД(m, n) = НОД(n, m - n).
            6. Если m, n нечётные и m < n, тогда НОД(m, n) = НОД(n, n - m).
            7. Если m = n, тогда НОД(m, n) = m;
        */
         if (n == 0 || m == 0){
             return m | n;
         }
         if (m == n){
             return m;
         }

         if ((n & 1) == 0 && (m & 1) == 0){
             return myGcd(m >> 1, n >> 1) << 1;
         }
         else if ((m&1) == 0){
             return myGcd(m >> 1, n);
         }
         else if ((n&1) == 0){
             return myGcd(m, n >> 1);
         }
         else {
             if (m > n){
                 return myGcd(n, m - n);
             }
             else {
                 return myGcd(n, n-m);
             }
         }
    }
}
