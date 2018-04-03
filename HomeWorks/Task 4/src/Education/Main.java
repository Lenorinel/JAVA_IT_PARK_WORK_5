package Education;

import java.util.Scanner;

public class Main {
    // функция
    public static long convert(char a[]) { //передаем массив Char, получаем long
        int[] b = new int[a.length]; //создаем доп массив, размера получаемого массива
        int k = 0;
        long n = 0;
        for (int i = 0; i < a.length; i++) {
            k = a[i] - 48; // неявным преобразованием получаем число первой цифры массива и вычитаем 48(начало
            //нумерации чисел в ASCII) чтобы получить число из цифры;
            b[i] = k; //заполняем массив b числами, полученными из цифр массива а
        }
        for (int i = b.length - 1; i >= 0; i--) {
            n += (long) Math.pow(10, i) * b[b.length - 1 - i]; //пробегаясь по эл-там массива b умножаем
            // каждое число на то количество 10, сколько их нужно для получения его разряда и суммируем
        }
        return n;
    }


    public static void main(String[] args) {
        char[] a = "12345678910".toCharArray();


        System.out.print(convert(a) + 15);

    }


}
