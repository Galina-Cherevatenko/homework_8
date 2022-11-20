package org.example.homework_1.task1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double Summa;
    int procent, n;

    System.out.println("Введите сумму вклада:");
    Summa = in.nextDouble();
    System.out.println("Введите процент:");
    procent = in.nextInt();
    System.out.println("Введите количество лет:");
    n = in.nextInt();
    in.close();
    System.out.printf("Ваш доход составит: %.2f", dohodCount (Summa, procent, n) );

}
public static double dohodCount (double Sum, int procent, int n) {
    double DohodZagod, Dohod, Profit;
        DohodZagod = 0;
        Dohod = 0;
        for (int i = 1; i <= n; i++) {
            Profit = Sum * (1 + (double) procent / 100);
            DohodZagod = Profit - Sum;
            if (DohodZagod > 42500)
                DohodZagod = DohodZagod - (DohodZagod - 42500) * 0.13;
            Sum = Sum + DohodZagod;
            Dohod = Dohod + DohodZagod;
        }
        return Dohod;
    }
}
