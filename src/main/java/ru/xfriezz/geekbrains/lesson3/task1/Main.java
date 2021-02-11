package ru.xfriezz.geekbrains.lesson3.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> str = Arrays.asList(
                "Молоко", "Сок", "Морс", "Помидор", "Огурец",
                "Картофель", "Апельсин", "Яблоко", "Банан", "Собака",
                "Кот", "Огурец", "Собака", "Апельсин", "Сок",
                "Сок", "Молоко", "Чай", "Кофе");

        Set<String> unique = new HashSet<String>(str);

        System.out.println("Уникальные слова" + "\n" + unique.toString());
        System.out.println("Частота встречаемости слов");
        unique.stream().map(key -> key + ": " + Collections.frequency(str, key)).forEachOrdered(System.out::println);

    }
}
