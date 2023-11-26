package com.solvd.textreader.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Message {
    public static final String SAY_HELLO = "Добрый день! Вас приветствует текстовый редактор!\n";
    public static final String READ_OPTION = "Откуда хотите прочитать текст для обработки: \n 1. Консоль. \n 2. Файл.\n";
    public static final String INPUT_VARIANT = "Введите один из номеров вариантов, который Вам подходит >>>";
    public static final String INPUT_ERROR = "Некорректный ввод, пожалуйста введите требуемый текст!";
    public static final String READ_FROM_FILE = "Отлично! Читаю из файла...";
    public static final String READ_FROM_CONSOLE = "Отлично! Читаю из консоли... Введите текст >>>";
    public static final String TEXT_PROCESS_OPTIONS = "Как хотите обработать полученный текст:\n";
    public static final String PROCESS_OPTIONS = "1. Посчитать уникальные слова.\n2. Посчитать количество букв.\n3. Поиск слова.\n";
    public static final String WORD_INPUT = "Введите слово для поиска(слово должно быть длиннее двух букв) >>>";
    public static final String TEXT_PROCESSING = "Отлично! Выполняю обработку текста!";
}
