package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegistrationValidatorTest {
    UserRegistrationValidator validator;

    public UserRegistrationValidatorTest() {
        this.validator = new UserRegistrationValidator();
    }

    @ParameterizedTest(name = "#{index} - Run test with first name = {0} should return = {1}")
    @MethodSource("firstNameProvider")
    public void givenFirstName_whenVariousNames_shouldReturnExpectedResult(String firstName, boolean expectedResult) {
        boolean result = validator.validateFirstName.validate(firstName);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> firstNameProvider() {
        return Stream.of(Arguments.of("Priyanka", true),
                Arguments.of("John", true),
                Arguments.of("Pr", false),
                Arguments.of("pr", false),
                Arguments.of("priyanka", false));
    }

    @ParameterizedTest(name = "#{index} - Run test with last name = {0} should return = {1}")
    @MethodSource("lastNameProvider")
    public void givenLastName_whenVariousLastNames_shouldReturnExpectedResult(String lastName,boolean expectedResult) {
        boolean result = validator.validateLastName.validate(lastName);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> lastNameProvider() {
        return Stream.of(Arguments.of("Shinde",true),
                Arguments.of("Uphade",true),
                Arguments.of("shinde",false),
                Arguments.of("sh",false)
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with mobile number = {0} should return = {1}")
    @MethodSource("mobileNoProvider")
    public void givenMobileNo_whenVariousNumbers_shouldReturnExpectedResult(String mobileNumber,boolean expectedResult) {
        boolean result = validator.validateMobileNumber.validate(mobileNumber);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> mobileNoProvider() {
        return Stream.of(Arguments.of("+91 9518905320",true),
                Arguments.of("+243 4567653467",true),
                Arguments.of("9195189",false),
                Arguments.of("9518905320",false),
                Arguments.of("1-9325849345",false),
                Arguments.of("21 2340000000",false),
                Arguments.of("+91 0000000345",false)
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with password = {0} should return = {1}")
    @MethodSource("passwordProvider")
    public void givenPasswords_whenVariousPasswords_shouldReturnExpectedResult(String password, boolean expectedResult) {
        boolean result = validator.validatePassword.validate(password);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> passwordProvider() {
        return Stream.of(Arguments.of("priyanka", false),
                Arguments.of("45", false),
                Arguments.of("#wer", false),
                Arguments.of("12345678", false),
                Arguments.of("Priyanka", false),
                Arguments.of("Pri$$1236", false),
                Arguments.of("Priyanka1", false),
                Arguments.of("12@45&443e", false),
                Arguments.of("@#Priya456#", false),
                Arguments.of("Priyanka$1", true),
                Arguments.of("Pri@12345", true),
                Arguments.of("#Wert2345", true)
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with given email id = {0} should return result = {1}")
    @MethodSource("emailIdProvider")
    public void givenEmailIds_whenVariousEmails_shouldReturnExpectedResult(String emailId, boolean expectedResult) {
        boolean result = validator.validateEmailId.validate(emailId);
        assertEquals(expectedResult, result);

    }

    static Stream<Arguments> emailIdProvider() {
        return Stream.of(Arguments.of("abc@yahoo.com", true),
                Arguments.of("abc-100@yahoo.com", true),
                Arguments.of("abc.100@yahoo.com", true),
                Arguments.of("abc111@abc.com", true),
                Arguments.of("abc-100@abc.net", true),
                Arguments.of("abc.100@abc.com.au", true),
                Arguments.of("abc@1.com", true),
                Arguments.of("abc@gmail.com.com", true),
                Arguments.of("abc+100@gmail.com", true),
                Arguments.of("abc", false),
                Arguments.of("abc@.com.my", false),
                Arguments.of("abc123@gmail.a", false),
                Arguments.of("abc123 @.com", false),
                Arguments.of("abc123 @.com.com", false),
                Arguments.of(".abc @abc.com", false),
                Arguments.of("abc() * @gmail.com", false),
                Arguments.of("abc @%*.com", false),
                Arguments.of("abc..2002 @gmail.com", false),
                Arguments.of("abc.@gmail.com", false),
                Arguments.of("abc@abc@gmail.com", false),
                Arguments.of("abc@gmail.com.1a", false),
                Arguments.of("abc@gmail.com.aa.au", false)
        );
    }
}
