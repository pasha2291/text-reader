package com.solvd.textreader.reader_writer;

import lombok.experimental.UtilityClass;

import static com.solvd.textreader.context.DynamicContext.getTextProcessOption;

@UtilityClass
public class ReaderWriterManager {
    public static ReaderWriter getReaderWriter() {
        switch (getTextProcessOption().getTextSourceType()) {
            case CONSOLE: return new ConsoleReaderWriter();
            case FILE: return new FileReaderWriter();
            default: throw new IllegalArgumentException("Inappropriate text source type");
        }
    }
}
