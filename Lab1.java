import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {

    // ===================== ЗАДАНИЕ 1. МЕТОДЫ =====================

    // 1. Дробная часть
    public double fraction(double x) {
        return x - (int) x;
    }

    // 2. Сумма двух последних цифр
    public int sumLastNums(int x) {
        int last = Math.abs(x) % 10;
        int preLast = Math.abs(x) / 10 % 10;
        return last + preLast;
    }

    // 3. Букву в число
    public int charToNum(char x) {
        return x - '0';
    }

    // 4. Есть ли позитив
    public boolean isPositive(int x) {
        return x > 0;
    }

    // 5. Двузначное
    public boolean is2Digits(int x) {
        x = Math.abs(x);
        return x >= 10 && x <= 99;
    }

    // ===================== ЗАДАНИЕ 2. УСЛОВИЯ =====================

    // 1. Модуль числа
    public int abs(int x) {
        return x < 0 ? -x : x;
    }

    // 2. Безопасное деление
    public double safeDiv(int x, int y) {
        if (y == 0) return 0;
        return (double) x / y;
    }

    // 3. Тридцать пять
    public boolean is35(int x) {
        boolean div3 = x % 3 == 0;
        boolean div5 = x % 5 == 0;
        return (div3 || div5) && !(div3 && div5);
    }

    // 4. Строка сравнения
    public String makeDecision(int x, int y) {
        if (x < y) return x + " < " + y;
        if (x > y) return x + " > " + y;
        return x + " == " + y;
    }

    // 5. Тройной максимум
    public int max3(int x, int y, int z) {
        int max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }

    // ===================== ЗАДАНИЕ 3. ЦИКЛЫ =====================

    // 1. Числа подряд
    public String listNums(int x) {
        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            for (int i = 0; i <= x; i++) {
                sb.append(i);
                if (i < x) sb.append(" ");
            }
        } else {
            for (int i = 0; i >= x; i--) {
                sb.append(i);
                if (i > x) sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 2. Числа наоборот
    public String reverseListNums(int x) {
        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            for (int i = x; i >= 0; i--) {
                sb.append(i);
                if (i > 0) sb.append(" ");
            }
        } else {
            for (int i = x; i <= 0; i++) {
                sb.append(i);
                if (i < 0) sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 3. Чётные числа
    public String chet(int x) {
        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            for (int i = 0; i <= x; i += 2) {
                sb.append(i);
                if (i + 2 <= x) sb.append(" ");
            }
        } else {
            for (int i = 0; i >= x; i -= 2) {
                sb.append(i);
                if (i - 2 >= x) sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 4. Степень числа
    public int pow(int x, int y) {
        if (y < 0) {
            return 0; // отрицательная степень для int → 0
        }
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    // 5. Длина числа
    public int numLen(long x) {
        if (x == 0) return 1;
        x = Math.abs(x);
        int len = 0;
        while (x > 0) {
            x /= 10;
            len++;
        }
        return len;
    }

    // ===================== ЗАДАНИЕ 4. МАССИВЫ =====================

    // 1. Поиск первого вхождения
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    // 2. Поиск последнего вхождения
    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    // 3. Максимум по модулю
    public int maxAbs(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }
        return max;
    }

    // 4. Добавление одного элемента
    public int[] add(int[] arr, int x, int pos) {
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        result[pos] = x;
        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }
        return result;
    }

    // 5. Добавление массива в массив
    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }
        return result;
    }

    // ===================== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ =====================

    private int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число!");
                sc.nextLine();
            }
        }
    }

    private double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите вещественное число!");
                sc.nextLine();
            }
        }
    }

    private char readDigitChar(Scanner sc) {
        while (true) {
            System.out.print("Введите цифру (0-9): ");
            String s = sc.next();
            if (s.length() == 1 && s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                return s.charAt(0);
            }
            System.out.println("Ошибка: нужна одна цифра от 0 до 9!");
        }
    }

    private int[] readArray(Scanner sc) {
        int n = readInt(sc, "Введите размер массива: ");
        while (n <= 0) {
            System.out.println("Размер должен быть положительным!");
            n = readInt(sc, "Введите размер массива: ");
        }
        int[] arr = new int[n];
        System.out.println("Введите " + n + " элементов:");
        for (int i = 0; i < n; i++) {
            arr[i] = readInt(sc, "  arr[" + i + "] = ");
        }
        return arr;
    }

    // ===================== ГЛАВНЫЙ МЕТОД С МЕНЮ =====================

    public static void main(String[] args) {
        Lab1 lab = new Lab1();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Лабораторная работа №1 (Вариант 1) ===");
            System.out.println("Выберите задание:");
            System.out.println("1 - Задание 1 (Методы)");
            System.out.println("2 - Задание 2 (Условия)");
            System.out.println("3 - Задание 3 (Циклы)");
            System.out.println("4 - Задание 4 (Массивы)");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            int choice = lab.readInt(sc, "");

            if (choice == 0) break;

            switch (choice) {
                case 1 -> {
                    System.out.println("\n--- Задание 1. Методы ---");
                    System.out.println("1. fraction");
                    System.out.println("2. sumLastNums");
                    System.out.println("3. charToNum");
                    System.out.println("4. isPositive");
                    System.out.println("5. is2Digits");
                    int t = lab.readInt(sc, "Номер задачи: ");
                    switch (t) {
                        case 1 -> {
                            double x = lab.readDouble(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.fraction(x));
                        }
                        case 2 -> {
                            int x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.sumLastNums(x));
                        }
                        case 3 -> {
                            char ch = lab.readDigitChar(sc);
                            System.out.println("Результат: " + lab.charToNum(ch));
                        }
                        case 4 -> {
                            int x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.isPositive(x));
                        }
                        case 5 -> {
                            int x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.is2Digits(x));
                        }
                        default -> System.out.println("Нет такой задачи");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Задание 2. Условия ---");
                    System.out.println("1. abs");
                    System.out.println("2. safeDiv");
                    System.out.println("3. is35");
                    System.out.println("4. makeDecision");
                    System.out.println("5. max3");
                    int t = lab.readInt(sc, "Номер задачи: ");
                    switch (t) {
                        case 1 -> {
                            int x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.abs(x));
                        }
                        case 2 -> {
                            int x = lab.readInt(sc, "Делимое: ");
                            int y = lab.readInt(sc, "Делитель: ");
                            System.out.println("Результат: " + lab.safeDiv(x, y));
                        }
                        case 3 -> {
                            int x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.is35(x));
                        }
                        case 4 -> {
                            int x = lab.readInt(sc, "Первое число: ");
                            int y = lab.readInt(sc, "Второе число: ");
                            System.out.println("Результат: " + lab.makeDecision(x, y));
                        }
                        case 5 -> {
                            int x = lab.readInt(sc, "Первое: ");
                            int y = lab.readInt(sc, "Второе: ");
                            int z = lab.readInt(sc, "Третье: ");
                            System.out.println("Результат: " + lab.max3(x, y, z));
                        }
                        default -> System.out.println("Нет такой задачи");
                    }
                }
                case 3 -> {
                    System.out.println("\n--- Задание 3. Циклы ---");
                    System.out.println("1. listNums");
                    System.out.println("2. reverseListNums");
                    System.out.println("3. chet");
                    System.out.println("4. pow");
                    System.out.println("5. numLen");
                    int t = lab.readInt(sc, "Номер задачи: ");
                    switch (t) {
                        case 1 -> {
                            int x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.listNums(x));
                        }
                        case 2 -> {
                            int x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.reverseListNums(x));
                        }
                        case 3 -> {
                            int x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.chet(x));
                        }
                        case 4 -> {
                            int x = lab.readInt(sc, "Основание: ");
                            int y = lab.readInt(sc, "Степень: ");
                            System.out.println("Результат: " + lab.pow(x, y));
                        }
                        case 5 -> {
                            long x = lab.readInt(sc, "Введите число: ");
                            System.out.println("Результат: " + lab.numLen(x));
                        }
                        default -> System.out.println("Нет такой задачи");
                    }
                }
                case 4 -> {
                    System.out.println("\n--- Задание 4. Массивы ---");
                    System.out.println("1. findFirst");
                    System.out.println("2. findLast");
                    System.out.println("3. maxAbs");
                    System.out.println("4. add (один элемент)");
                    System.out.println("5. add (массив)");
                    int t = lab.readInt(sc, "Номер задачи: ");
                    switch (t) {
                        case 1 -> {
                            int[] arr = lab.readArray(sc);
                            int x = lab.readInt(sc, "Искомое значение: ");
                            System.out.println("Результат: " + lab.findFirst(arr, x));
                        }
                        case 2 -> {
                            int[] arr = lab.readArray(sc);
                            int x = lab.readInt(sc, "Искомое значение: ");
                            System.out.println("Результат: " + lab.findLast(arr, x));
                        }
                        case 3 -> {
                            int[] arr = lab.readArray(sc);
                            System.out.println("Результат: " + lab.maxAbs(arr));
                        }
                        case 4 -> {
                            int[] arr = lab.readArray(sc);
                            int x = lab.readInt(sc, "Значение: ");

                            int pos;
                            while (true) {
                                pos = lab.readInt(sc, "Позиция (от 0 до " + arr.length + "): ");
                                if (pos >= 0 && pos <= arr.length) {
                                    break;
                                }
                                System.out.println("Ошибка: позиция должна быть от 0 до " + arr.length + "!");
                            }

                            System.out.println("Результат: " + Arrays.toString(lab.add(arr, x, pos)));
                        }
                        case 5 -> {
                            int[] arr = lab.readArray(sc);
                            System.out.println("Массив для вставки:");
                            int[] ins = lab.readArray(sc);

                            int pos;
                            while (true) {
                                pos = lab.readInt(sc, "Позиция (от 0 до " + arr.length + "): ");
                                if (pos >= 0 && pos <= arr.length) {
                                    break;
                                }
                                System.out.println("Ошибка: позиция должна быть от 0 до " + arr.length + "!");
                            }

                            System.out.println("Результат: " + Arrays.toString(lab.add(arr, ins, pos)));
                        }
                        default -> System.out.println("Нет такой задачи");
                    }
                }
                default -> System.out.println("Неверный выбор");
            }
        }

        System.out.println("Работа завершена.");
        sc.close();
    }
}