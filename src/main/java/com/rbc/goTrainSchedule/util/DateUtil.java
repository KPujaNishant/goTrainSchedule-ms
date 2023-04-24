package com.rbc.goTrainSchedule.util;

import com.rbc.goTrainSchedule.exception.BadRequestException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    public static void validateDepartureTime(String time) {
        boolean isValid24 = isValid24hFomate(time);

        boolean isValid12 = isValid12hFomate(time);

        //  LocalTime date=StringToDate(time);
        //  System.out.println("Date  : "+date);
        if (!(isValid24 || isValid12))
            throw new BadRequestException("Please enter valid time format" +
                    "It should be in 12 hr or 24 hr format");

    }

    private static boolean isValid24hFomate(String time) {
        String regex = "([01]?[0-9]|2[0-3])[0-5][0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(time);

        // Return if the time
        // matched the ReGex
        return m.matches();
    }

    private static boolean isValid12hFomate(String time) {
        // Regex to check valid time in 12-hour format.
        String regexPattern
                = "(1[012]|[1-9]):"
                + "[0-5][0-9](\\s)"
                + "?(?i)(am|pm)";
        // Compile the ReGex
        Pattern compiledPattern
                = Pattern.compile(regexPattern);
        // Pattern class contains matcher() method to find matching between given time
        // and regular expression.
        Matcher m = compiledPattern.matcher(time);

        // Return if the time matched the ReGex
        return m.matches();
    }


}
