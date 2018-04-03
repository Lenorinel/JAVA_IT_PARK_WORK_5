package Education;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int c = 0;
        System.out.println("Please enter size of your massive like m*m");
        int m = scanner.nextInt();
//получаем ввода числа с клавиатуры и задаем размер квадратного массива
        int[][] a = new int[m][m];
//заполняем массив рандомными числами
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = random.nextInt(11);
//выводим массив на экран, чтобы видел пользователь
        for (int i[] : a) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
//       суммируем в обходе числа с i позицей и последний индекс - i
        for (int i = 0; i < a.length; i++)
            c += a[i][a.length - 1 - i];
        System.out.println("Сумма чисел побочной диагонали равна: " + c);

    }
}
