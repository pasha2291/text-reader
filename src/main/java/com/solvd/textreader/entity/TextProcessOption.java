package com.solvd.textreader.entity;

import com.solvd.textreader.constant.TextProcessOptionType;
import com.solvd.textreader.constant.TextSourceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TextProcessOption {
    private TextSourceType textSourceType;
    private String textToProcess;
    private TextProcessOptionType textProcessOptionType;
    private String wordToSearch;
    private String textAfterProcessing;

    public void setTextSourceType(String sourceType) {
        int option = Integer.parseInt(sourceType);
        textSourceType = TextSourceType.values()[--option];
    }

    public void setTextProcessOptionType(String textProcessOption) {
        int option = Integer.parseInt(textProcessOption);
        textProcessOptionType = TextProcessOptionType.values()[--option];
    }
}
