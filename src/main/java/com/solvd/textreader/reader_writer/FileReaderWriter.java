package com.solvd.textreader.reader_writer;

import com.solvd.textreader.constant.TextValidationType;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.stream.Collectors;

import static com.solvd.textreader.constant.FilePathFromResources.TEXT_FILE_TO_READ_PATH;
import static com.solvd.textreader.constant.FilePathFromResources.TEXT_FILE_TO_WRITE_PATH;
import static com.solvd.textreader.service.CustomLogger.debug;
import static com.solvd.textreader.service.TextMatcher.isTextMatches;

public class FileReaderWriter implements ReaderWriter{
    private static final ClassLoader CLASS_LOADER = ClassLoader.getSystemClassLoader();
    private static final String LINE_SEPARATOR = "\n";

    @SneakyThrows
    @Override
    public String read(TextValidationType validationType) {
        String fileFullPath = getFileFullPath(TEXT_FILE_TO_READ_PATH);
        debug("Read text from file [" + fileFullPath + "] and validate with regex: [" + validationType.getREGEX() + "]");
        BufferedReader reader = new BufferedReader(new FileReader(fileFullPath));
        String text = reader.lines().collect(Collectors.joining(LINE_SEPARATOR));
        if(!isTextMatches(text, validationType)) {
            throw new IllegalArgumentException("Inappropriate text in file: blank, empty, or special characters only");
        }
        reader.close();
        return text;
    }

    @SneakyThrows
    @Override
    public void write(String stringToWrite) {
        String fileFullPath = getFileFullPath(TEXT_FILE_TO_READ_PATH).replace(TEXT_FILE_TO_READ_PATH, TEXT_FILE_TO_WRITE_PATH);
        debug("Write text to file [" + fileFullPath + "]");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileFullPath));
        writer.write(stringToWrite);
        writer.close();
    }

    private String getFileFullPath(String path) {
        return CLASS_LOADER.getResource(path).getPath();
    }
}
