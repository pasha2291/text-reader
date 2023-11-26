package com.solvd.textreader.reader_writer;

import com.solvd.textreader.constant.TextValidationType;

public interface ReaderWriter {
    String read(TextValidationType validationType);
    void write(String stringToWrite);
}
