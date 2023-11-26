package com.solvd.textreader.service;

import com.solvd.textreader.reader_writer.ConsoleReaderWriter;

import static com.solvd.textreader.constant.TextValidationType.TEXT_PROCESS_OPTIONS_VALIDATION;
import static com.solvd.textreader.constant.TextValidationType.TEXT_SOURCE_OPTIONS_VALIDATION;
import static com.solvd.textreader.constant.TextValidationType.TEXT_VALIDATION;
import static com.solvd.textreader.constant.TextValidationType.WORD_VALIDATION;
import static com.solvd.textreader.constant.TextProcessOptionType.WORD_SEARCH;
import static com.solvd.textreader.context.DynamicContext.getTextProcessOption;
import static com.solvd.textreader.reader_writer.ReaderWriterManager.getReaderWriter;
import static com.solvd.textreader.service.MessagePrinter.printExecuteProcessingMessage;
import static com.solvd.textreader.service.MessagePrinter.printInitialMessage;
import static com.solvd.textreader.service.MessagePrinter.printInputTextMessage;
import static com.solvd.textreader.service.MessagePrinter.printInputWordMessage;
import static com.solvd.textreader.service.MessagePrinter.printTextProcessOptionsMessage;
import static com.solvd.textreader.service.TextProcessor.processTextAndAssignToContext;

public class Runner {
    public static void main(String[] args) {
        ConsoleReaderWriter consoleReaderWriter = new ConsoleReaderWriter();
        printInitialMessage();
        String userInput = consoleReaderWriter.read(TEXT_SOURCE_OPTIONS_VALIDATION);
        getTextProcessOption().setTextSourceType(userInput);

        printInputTextMessage();
        String text = getReaderWriter().read(TEXT_VALIDATION);
        getTextProcessOption().setTextToProcess(text);

        printTextProcessOptionsMessage();
        String processingOption = consoleReaderWriter.read(TEXT_PROCESS_OPTIONS_VALIDATION);
        getTextProcessOption().setTextProcessOptionType(processingOption);

        if (getTextProcessOption().getTextProcessOptionType() == WORD_SEARCH) {
            printInputWordMessage();
            String wordToSearch = consoleReaderWriter.read(WORD_VALIDATION);
            getTextProcessOption().setWordToSearch(wordToSearch);
        }

        printExecuteProcessingMessage();
        processTextAndAssignToContext(getTextProcessOption().getTextToProcess());
        getReaderWriter().write(getTextProcessOption().getTextAfterProcessing());
    }
}
