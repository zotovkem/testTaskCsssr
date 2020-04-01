package com.csssr;

import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

/*
"Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом. Нужно преобразовать строку в такую структуру " +
        "данных, которая группирует слова по первой букве в слове. Затем вывести только группы, содержащие более одного " +
        "элемента. Группы должны быть отсортированы в алфавитном порядке. Слова внутри группы нужно сортировать по убыванию " +
        "количества символов; если количество символов равное, то сортировать в алфавитном порядке. Пример строки: " +
        "String s = «сапог сарай арбуз болт бокс биржа» Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]"
*/
public class Main {
    private static final String DELIMITER = " ";
    private static final String TEXT = "сапог сарай арбуз болт бок биржа";
    private static final String TEXT2 = "абв абг азк блд Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом. Нужно преобразовать строку в такую структуру данных, которая группирует слова по первой букве в слове. Затем вывести только группы, содержащие более одного элемента. " +
            "Группы должны быть отсортированы в алфавитном порядке. Слова внутри группы нужно сортировать по убыванию количества символов; если количество символов равное, то сортировать в алфавитном порядке.";

    public static void main(String[] args) {
        Stream.of(TEXT.toLowerCase().split(DELIMITER))
                .collect(groupingBy(str -> str.charAt(0),
                        toCollection(() -> new TreeSet<>(comparingInt(String::length).reversed().thenComparing(CharSequence::compare)))))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .sorted((e1, e2) -> Character.compare(e1.getKey(), e2.getKey()))
                .forEach(System.out::println);
    }
}
