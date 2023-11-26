package com.solvd.textreader.service;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@UtilityClass
public class CustomLogger {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void debug(String message) { LOGGER.log(Level.DEBUG, message); }
}