package com.solvd.textreader.service;

import com.solvd.textreader.constant.TextValidationType;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@UtilityClass
public final class TextMatcher {
    public static boolean isTextMatches(String text, TextValidationType validationType) {
        return initMatcher(text, validationType.getREGEX()).matches();
    }

    public static long countMatchesPattern(String text, TextValidationType validationType) {
        return initMatcher(text, validationType.getREGEX()).results().count();
    }

    public static long countMatchesPattern(String text, String textPattern) {
        return initMatcher(text, textPattern).results().count();
    }

    public static List<String> getListOfMatches(String text, TextValidationType validationType) {
        return initMatcher(text, validationType.getREGEX()).results().map(match -> match.group(0)).collect(Collectors.toList());
    }

    private static Matcher initMatcher(String text, String textPattern) {
        Pattern pattern = Pattern.compile(textPattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        return pattern.matcher(text);
    }
}