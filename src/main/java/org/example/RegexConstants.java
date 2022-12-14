package org.example;

public class RegexConstants {
    public static final String FIRST_NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}";
    public static final String LAST_NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}";
    public static final String MOBILE_NUMBER_PATTERN = "^(?!.*0{4})\\+?([1][\\s\\-])?[1-9]{1,3}\\s[0-9]{10}";
    public static final String PASSWORD_PATTERN = "(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9\\^!@#$%&*~]{8,}";
}
