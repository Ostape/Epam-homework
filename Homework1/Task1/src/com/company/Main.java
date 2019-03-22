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
