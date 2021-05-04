package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class DateTimeFormatConfig {

    public static final String DATA_SIMPLES = "dd/MM/yyyy";
    public static final String DATA_HORA = "dd/MM/yyyy HH:mm:ss";

    @Bean
    public Formatter<LocalDate> localDateFormatter() {

        return new Formatter<LocalDate>() {
            @Override
            public LocalDate parse(String s, Locale locale) throws ParseException {
                return LocalDate.parse(s, DateTimeFormatter.ofPattern(DATA_SIMPLES));
            }

            @Override
            public String print(LocalDate localDate, Locale locale) {
                return DateTimeFormatter.ofPattern(DATA_SIMPLES).format(localDate);
            }
        };
    }

    @Bean
    public Formatter<LocalDateTime> localDateTimeFormatter() {

        return new Formatter<LocalDateTime>() {
            @Override
            public LocalDateTime parse(String s, Locale locale) throws ParseException {
                return LocalDateTime.parse(s, DateTimeFormatter.ofPattern(DATA_HORA));
            }

            @Override
            public String print(LocalDateTime localDate, Locale locale) {
                return DateTimeFormatter.ofPattern(DATA_HORA).format(localDate);
            }
        };
    }

}
