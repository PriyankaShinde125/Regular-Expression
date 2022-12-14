package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationValidator {
    boolean validateFirstName(String firstName) {
        Pattern pattern = Pattern.compile(RegexConstants.FIRST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    boolean validateLastName(String lastName) {
        Pattern pattern = Pattern.compile(RegexConstants.LAST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    boolean validateMobileNumber(String mobileNo) {
        Pattern pattern = Pattern.compile(RegexConstants.MOBILE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(mobileNo);
        return matcher.matches();
    }
}
