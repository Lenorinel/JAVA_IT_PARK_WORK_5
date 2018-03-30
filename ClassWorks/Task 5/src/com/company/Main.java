package com.company;

import java.util.Scanner;

public class Main {

    public static int SUMM(int n) {
        int s = 0;
        while (n != 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), t;
        //int x = scanner.nextInt();
        t = SUMM(n);
        System.out.println(t);

    }
}
