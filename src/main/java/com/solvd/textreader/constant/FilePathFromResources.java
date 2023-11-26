package com.solvd.textreader.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class FilePathFromResources {
    private static final String TEXT_DATA_FOLDER = "text_data/%s";
    public static final String TEXT_FILE_TO_READ_PATH = String.format(TEXT_DATA_FOLDER, "text_to_read.txt");
    public static final String TEXT_FILE_TO_WRITE_PATH = String.format(TEXT_DATA_FOLDER, "text_to_write.txt");
}
