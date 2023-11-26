package com.solvd.textreader.service;

import lombok.experimental.UtilityClass;

import static com.solvd.textreader.constant.Message.INPUT_VARIANT;
import static com.solvd.textreader.constant.Message.PROCESS_OPTIONS;
import static com.solvd.textreader.constant.Message.READ_FROM_CONSOLE;
import static com.solvd.textreader.constant.Message.READ_FROM_FILE;
import static com.solvd.textreader.constant.Message.READ_OPTION;
import static com.solvd.textreader.constant.Message.SAY_HELLO;
import static com.solvd.textreader.constant.Message.TEXT_PROCESSING;
import static com.solvd.textreader.constant.Message.TEXT_PROCESS_OPTIONS;
import static com.solvd.textreader.constant.Message.WORD_INPUT;
import static com.solvd.textreader.context.DynamicContext.getTextProcessOption;

@UtilityClass
public class MessagePrinter {
    public static void printInitialMessage() {
        System.out.println(SAY_HELLO);
        System.out.println(READ_OPTION);
        System.out.println(INPUT_VARIANT);
    }

    public static void printInputTextMessage() {
        switch (getTextProcessOption().getTextSourceType()) {
            case CONSOLE: { System.out.println(READ_FROM_CONSOLE); break;}
            case FILE: { System.out.println(READ_FROM_FILE); break;}
            default: throw new IllegalArgumentException("Inappropriate text source type");
        }
    }

    public static void printTextProcessOptionsMessage() {
        System.out.println(TEXT_PROCESS_OPTIONS);
        System.out.println(PROCESS_OPTIONS);
        System.out.println(INPUT_VARIANT);
    }

    public static void printInputWordMessage() {
        System.out.println(WORD_INPUT);
        System.out.println();
    }

    public static void printExecuteProcessingMessage() {
        System.out.println(TEXT_PROCESSING);
        System.out.println();
    }
}
