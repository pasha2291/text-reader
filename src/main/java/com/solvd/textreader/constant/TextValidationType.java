package com.solvd.textreader.constant;

import lombok.Getter;

@Getter
public enum TextValidationType {
    TEXT_SOURCE_OPTIONS_VALIDATION("[1-2]"),
    TEXT_VALIDATION("(.|\\s)*[a-zа-я]{3,}(.|\\s)*"),
    TEXT_PROCESS_OPTIONS_VALIDATION("[1-3]"),
    WORD_VALIDATION("[a-zа-я]{3,}"),
    LETTER_VALIDATION("[a-zа-я]{1}");

    private final String REGEX;

    TextValidationType(String regex){
        this.REGEX = regex;
    }
}
