package AstonTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AstonTest {
    public static void main(String[] args) {
        System.out.println(new Task().getTASK());

        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("Введите 2 числа для сравнения или (Выход) для выхода:");
            if (sc.hasNextInt()) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(operationCompare(a, b));
                mathOperations(a, b);
            } else {
                if (sc.nextLine().equalsIgnoreCase("выход")) {
                    flag = false;
                } else {
                    System.out.println("Некорректный ввод");
                }
            }
        }

        flag = true;
        while (flag) {
            System.out.println("Введите 2 строки для сравнения или (Выход) для выхода:");
            String s1 = sc.nextLine();
            if (!s1.equalsIgnoreCase("выход")) {
                String s2 = sc.nextLine();
                System.out.println(stringEquals(s1, s2));
            } else {
                flag = false;
                sc.close();
            }
        }

        System.out.println("Четные цифры массива: ");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(divArray(arr));
    }

    public static String operationCompare(int a, int b) {
        if (a > b) {
            return "a>b";
        } else if (a == b) {
            return "a==b";
        } else {
            return "a<b";
        }
    }

    public static void mathOperations(int a, int b) {
        try {
            int sum = Math.addExact(a, b);
            System.out.println("Сумма: " + sum);
        } catch (ArithmeticException e) {
            System.out.println("Переполнение при сложении");
        }
        try {
            int multiply = Math.multiplyExact(a, b);
            System.out.println("Произведение: " + multiply);
        } catch (ArithmeticException e) {
            System.out.println("Переполнение при умножении");
        }
        try {
            int diffab = Math.subtractExact(a, b);
            int diffba = Math.subtractExact(b, a);
            System.out.println("a - b = " + diffab + "\n" + "b - a = " + diffba);
        } catch (ArithmeticException e) {
            System.out.println("Переполнение при вычитании");
        }
        try {
            if (b == 0) {
                throw new ArithmeticException("b=0, а на ноль делить нельзя");
            }
            double divab = (double) a / b;
            System.out.println("Частное a/b = " + divab);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (a == 0) {
                throw new ArithmeticException("b=0, а на ноль делить нельзя");
            }
            double divba = (double) b / a;
            System.out.println("Частное b/a = " + divba);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

    public static List<Integer> divArray(int[] arr) {
        List<Integer> newArr = new ArrayList<>();
        for (int i : arr) {
            if (i % 2 == 0) {
                newArr.add(i);
            }
        }
        return newArr;
    }

    public static String stringEquals(String s1, String s2) {
        if (s1 == null || s2 == null) return "Одна из строк пустая";
        if (s1 == null && s2 == null) return "Строки пустые";
        if (s1.equals(s2)) {
            return "Строки идентичны";
        } else {
            return "Строки неидентичны";
        }
    }
}