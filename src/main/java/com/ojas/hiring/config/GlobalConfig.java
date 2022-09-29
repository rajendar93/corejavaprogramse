package com.ojas.hiring.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author RavindranathGV
 */
public class GlobalConfig {

    public static String generateRandToken(int limit) {
        ArrayList<String> numbers = new ArrayList<String>();
        ArrayList<String> characters = new ArrayList<String>();

        for (int i = 0; i < 9; i++) {
            numbers.add(Integer.toString(i + 1));
        }
        char ch;

        for (ch = 'a'; ch <= 'z'; ch++) {
            characters.add(Character.toString(ch));
        }
        for (ch = 'A'; ch <= 'Z'; ch++) {
            characters.add(Character.toString(ch));
        }
        
        characters.addAll(numbers);        
        Collections.shuffle(characters);

        String token = "";
        // limit should less tthan 61
        for (int j = 0; j < limit; j++) {
            token += characters.get(j);
        }
        return token;
    }

    public static String generateDateBasedRandToken() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss_");
        String formattedDate = myDateObj.format(myFormatObj)+generateRandToken(7);        
        return formattedDate;
    }    
}
