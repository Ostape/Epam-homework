package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number in binary format");
        String input = scan.next();
        task1(input);
        task2(-1);
        task3();
        task4(30,18);
        task5(3, 34);


    }


    private static void task1(String input){
        System.out.println("Binary to decimal: "+"\"" + input + "\"" +" -> " + Integer.parseInt(input,2));
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
        System.out.println("GCD: " + gcd(a,b));
    }

    private static void task5(int pos, int num){
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
}
