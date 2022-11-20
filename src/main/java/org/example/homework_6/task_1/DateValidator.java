package org.example.homework_6.task_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public interface DateValidator {
    boolean isValid(String dateStr);
}
