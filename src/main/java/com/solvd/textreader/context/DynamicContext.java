package com.solvd.textreader.context;

import com.solvd.textreader.entity.TextProcessOption;
import lombok.experimental.UtilityClass;

import static com.solvd.textreader.service.CustomLogger.debug;


@UtilityClass
public class DynamicContext {
    private static TextProcessOption textProcessOption = null;

    public static TextProcessOption getTextProcessOption() {
        initContext();
        debug("Return textProcessOption: " + textProcessOption.toString());
        return textProcessOption;
    }

    private void initContext() {
        if(textProcessOption == null) {
            debug("Context initialization");
            textProcessOption = new TextProcessOption();
        }
    }
}
