package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationValidator {

    boolean validateFirstName(String firstName) {
        Pattern pattern = Pattern.compile(RegexConstants.FIRST_NAME_PATTERN);
        Matcher matcher= pattern.matcher(firstName);
        return matcher.matches();
    }
}
