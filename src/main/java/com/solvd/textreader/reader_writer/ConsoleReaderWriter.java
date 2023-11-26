package com.solvd.textreader.reader_writer;

import com.solvd.textreader.constant.TextValidationType;

import java.util.Scanner;

import static com.solvd.textreader.constant.Message.INPUT_ERROR;
import static com.solvd.textreader.service.TextMatcher.isTextMatches;

public class ConsoleReaderWriter implements ReaderWriter{
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String read(TextValidationType validationType) {
        String input = scanner.nextLine();
        while (!isTextMatches(input, validationType)) {
            write(INPUT_ERROR);
            input = scanner.nextLine();
        }
        return input;
    }

    @Override
    public void write(String stringToWrite) {
        System.out.println(stringToWrite);
    }
}
