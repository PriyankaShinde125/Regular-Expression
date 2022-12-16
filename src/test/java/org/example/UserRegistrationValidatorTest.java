package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegistrationValidatorTest {
    UserRegistrationValidator validator;

    public UserRegistrationValidatorTest() {
        this.validator = new UserRegistrationValidator();
    }

    @ParameterizedTest
    @MethodSource("validFirstNameProvider")
    public void givenFirstName_whenProper_shouldReturnTrue(String firstName) {
        boolean result = validator.validateFirstName.validate(firstName);
        assertEquals(true, result);
    }

    static Stream<String> validFirstNameProvider() {
        return Stream.of("Priyanka",
                "John");
    }

    @ParameterizedTest
    @MethodSource("invalidFirstNameProvider")
    public void givenFirstName_whenInvalid_shouldReturnFalse(String firstName) {
        boolean result = validator.validateFirstName.validate(firstName);
        assertEquals(false, result);
    }

    static Stream<String> invalidFirstNameProvider() {
        return Stream.of("Pr",
                "pr",
                "priyanka");
    }

    @ParameterizedTest
    @MethodSource("validLastNameProvider")
    public void givenLastName_whenProper_shouldReturnTrue(String lastName) {
        boolean result = validator.validateLastName.validate(lastName);
        assertEquals(true, result);
    }

    static Stream<String> validLastNameProvider() {
        return Stream.of("Shinde",
                "Uphade");
    }

    @ParameterizedTest
    @MethodSource("invalidLastNameProvider")
    public void givenLastName_whenInvalidLastName_shouldReturnFalse(String lastName) {
        boolean result = validator.validateLastName.validate(lastName);
        assertEquals(false, result);
    }

    static Stream<String> invalidLastNameProvider() {
        return Stream.of("shinde",
                "sh");
    }

    @ParameterizedTest
    @MethodSource("validMobileNoProvider")
    public void givenMobileNo_whenProper_shouldReturnTrue(String mobileNumber) {
        boolean result = validator.validateMobileNumber.validate(mobileNumber);
        assertEquals(true, result);
    }

    static Stream<String> validMobileNoProvider() {
        return Stream.of("+91 9518905320",
                "+243 4567653467"
        );
    }

    @ParameterizedTest
    @MethodSource("invalidMobileNumberProvider")
    public void givenMobileNo_whenInvalid_shouldReturnFalse(String mobileNumber) {
        boolean result = validator.validateMobileNumber.validate(mobileNumber);
        assertEquals(false, result);
    }

    static Stream<String> invalidMobileNumberProvider() {
        return Stream.of("+9195189",
                "9518905320",
                "1-9325849345",
                "21 2340000000",
                "+91 0000000345");
    }

    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("validPasswordProvider")
    public void givenPasswords_whenProperInput_shouldReturnTrue(String password) {
        boolean result = validator.validatePassword.validate(password);
        assertEquals(true, result);

    }

    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("invalidPasswordProvider")
    public void givenPasswords_whenNotProperInput_shouldReturnFalse(String password) {
        boolean result = validator.validatePassword.validate(password);
        assertEquals(false, result);

    }

    static Stream<String> validPasswordProvider() {
        return Stream.of("Priyanka$1",
                "Pri@12345",
                "#Wert2345"
        );
    }

    static Stream<String> invalidPasswordProvider() {
        return Stream.of("priyanka",
                "45",
                "#wer",
                "12345678",
                "Priyanka",
                "Pri$$1236",
                "Priyanka1",
                "12@45&443e",
                "@#Priya456#"
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with email id = {0}")
    @MethodSource("validEmailProvider")
    public void givenEmailIds_whenProperInput_shouldReturnTrue(String emailId) {
        boolean result = validator.validateEmailId.validate(emailId);
        assertEquals(true, result);

    }

    @ParameterizedTest(name = "#{index} - Run test with email id = {0}")
    @MethodSource("invalidEmailProvider")
    public void givenEmailIds_whenNotProperInput_shouldReturnTrue(String emailId) {
        boolean result = validator.validateEmailId.validate(emailId);
        assertEquals(false, result);

    }

    static Stream<String> validEmailProvider() {
        return Stream.of("abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        );
    }

    static Stream<String> invalidEmailProvider() {
        return Stream.of("abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123 @.com",
                "abc123 @.com.com",
                ".abc @abc.com",
                "abc() * @gmail.com",
                "abc @%*.com",
                "abc..2002 @gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        );
    }
}
