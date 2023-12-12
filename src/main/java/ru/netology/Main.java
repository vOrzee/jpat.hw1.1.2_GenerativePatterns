package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int n, m, f;

        logger.log("Здороваемся с пользователем.");
        System.out.println("Здравствуй, пользователь!");

        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        try {
            n = scanner.nextInt();
            if (n < 1) throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println("Вы ввели какую-то гадость, до свидания.");
            logger.log("Некорректный ввод числа n");
            return;
        }
        System.out.print("Введите верхнюю границу для значений: ");
        try {
            m = scanner.nextInt();
            if (m < 1) throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println("Вы ввели какую-то гадость, до свидания.");
            logger.log("Некорректный ввод числа m");
            return;
        }

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(m + 1));
        }
        System.out.println("Вот случайный список: " + list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        try {
            f = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели какую-то гадость, до свидания.");
            logger.log("Некорректный ввод числа f");
            return;
        }

        Filter filter = new Filter(f);
        List<Integer> resultList = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + resultList);

        logger.log("Завершаем программу");
        scanner.close();
    }
}