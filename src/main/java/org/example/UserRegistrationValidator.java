package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationValidator {
    Validation<String> validateFirstName = (firstName) -> {
        Pattern pattern = Pattern.compile(RegexConstants.FIRST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    };

    Validation<String> validateLastName = (lastName) -> {
        Pattern pattern = Pattern.compile(RegexConstants.LAST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    };

    Validation<String> validateMobileNumber = (mobileNo) -> {
        Pattern pattern = Pattern.compile(RegexConstants.MOBILE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(mobileNo);
        return matcher.matches();
    };

    Validation<String> validatePassword = (password) -> {
        Pattern pattern = Pattern.compile(RegexConstants.PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    };

    Validation<String> validateEmailId = (emailId) -> {
        Pattern pattern = Pattern.compile(RegexConstants.EMAIL_ID_PATTERN);
        Matcher matcher = pattern.matcher(emailId);
        return matcher.matches();
    };
}
