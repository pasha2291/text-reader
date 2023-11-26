package com.solvd.textreader.service;

import lombok.experimental.UtilityClass;

import java.util.List;

import static com.solvd.textreader.constant.TextValidationType.LETTER_VALIDATION;
import static com.solvd.textreader.constant.TextValidationType.WORD_VALIDATION;
import static com.solvd.textreader.context.DynamicContext.getTextProcessOption;
import static com.solvd.textreader.service.TextMatcher.countMatchesPattern;
import static com.solvd.textreader.service.TextMatcher.getListOfMatches;

@UtilityClass
public class TextProcessor {
    private static final String UNIQUE_WORDS_HEADER = "УНИКАЛЬНЫЕ СЛОВА\n";
    private static final String UNIQUE_WORDS_COUNT_RESULT = "Количество уникальных слов: %d\n";
    private static final String UNIQUE_WORDS_RESULT = "Уникальные слова: %s\n";
    private static final String COUNT_LETTERS_HEADER = "КОЛИЧЕСТВО БУКВ\n";
    private static final String COUNT_LETTERS_PROCESS_RESULT = "Результат:";
    private static final String COUNT_LETTERS_RESULT = "\nКоличество букв: %d";
    private static final String SEARCH_WORD_HEADER = "ПОИСК СЛОВА\n";
    private static final String SEARCH_WORD_BY_WORD = "Поиск по слову: %s\n";
    private static final String SEARCH_WORD_RESULT = "Найдено совпадений: %d\n";
    private static final String TEXT_BEFORE_PROCESSING_HEADER = "\nИсходный текст: %s\n";
    private static final String LINE_SEPARATOR = "_".repeat(50);
    private static final String WHITESPACE = " ";

    public static void processTextAndAssignToContext(String textToProcess) {
        String result;
        switch (getTextProcessOption().getTextProcessOptionType()) {
            case UNIQUE_WORDS_COUNT: { result = countUniqueWords(textToProcess); break;}
            case LETTERS_COUNT: { result = countLetters(textToProcess); break; }
            case WORD_SEARCH: { result = searchWord(textToProcess, getTextProcessOption().getWordToSearch()); break; }
            default: throw new IllegalArgumentException("Inappropriate text process option type");
        }
        getTextProcessOption().setTextAfterProcessing(result);
    }

    private static String countUniqueWords(String textToProcess) {
        long countMatches = countMatchesPattern(textToProcess, WORD_VALIDATION);
        List<String> uniquesWords;
        StringBuilder countUniqueWordsResult = new StringBuilder();
        countUniqueWordsResult.append(getHeader(UNIQUE_WORDS_HEADER, textToProcess));
        if (countMatches > 0) {
            uniquesWords = getListOfMatches(textToProcess, WORD_VALIDATION);
            uniquesWords.removeIf(currentWord -> countMatchesPattern(textToProcess, currentWord) > 1);
            countMatches = uniquesWords.size();
            countUniqueWordsResult.append(String.format(UNIQUE_WORDS_RESULT, uniquesWords));
        }
        return countUniqueWordsResult
                .append(String.format(UNIQUE_WORDS_COUNT_RESULT, countMatches))
                .toString();
    }

    private static String countLetters(String textToProcess) {
        long countMatches = countMatchesPattern(textToProcess, LETTER_VALIDATION);
        StringBuilder countLettersResult = new StringBuilder();
        countLettersResult.append(getHeader(COUNT_LETTERS_HEADER, textToProcess));
        if(countMatches > 0) {
            StringBuilder lettersString = new StringBuilder(COUNT_LETTERS_PROCESS_RESULT);
            List<String> letters = getListOfMatches(textToProcess, LETTER_VALIDATION);
            letters.forEach(letter -> lettersString.append(WHITESPACE).append(letter.toUpperCase()) );
            countLettersResult.append(lettersString);
        }
        return countLettersResult
                .append(String.format(COUNT_LETTERS_RESULT, countMatches))
                .toString();
    }

    private static String searchWord(String textToProcess, String wordToSearch) {
        long countMatches = countMatchesPattern(textToProcess, wordToSearch);
        return new StringBuilder()
                .append(getHeader(SEARCH_WORD_HEADER, textToProcess))
                .append(String.format(SEARCH_WORD_BY_WORD, wordToSearch))
                .append(String.format(SEARCH_WORD_RESULT, countMatches))
                .toString();
    }

    private static String getHeader(String functionName, String textToProcess) {
        return new StringBuilder()
                .append(functionName)
                .append(LINE_SEPARATOR)
                .append(String.format(TEXT_BEFORE_PROCESSING_HEADER, textToProcess))
                .toString();
    }
}
