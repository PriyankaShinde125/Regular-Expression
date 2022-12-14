package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UserRegistrationValidatorTest {
    UserRegistrationValidator validator;

    public UserRegistrationValidatorTest() {
        this.validator = new UserRegistrationValidator();
    }

    @Test
    public void givenFirstName_whenProper_shouldReturnTrue() {
        boolean result = validator.validateFirstName("Priyanka");
        assertEquals(true, result);
    }

    @Test
    public void givenFirstName_whenInitialLetterSmall_shouldReturnFalse() {
        boolean result = validator.validateFirstName("priyanka");
        assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenLengthLessThanThree_shouldReturnFalse() {
        boolean result = validator.validateFirstName("Pr");
        assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenInitialLetterSmallAndLengthIsLessThanThree_shouldReturnFalse() {
        boolean result = validator.validateFirstName("pr");
        assertEquals(false, result);
    }

    @Test
    public void givenLastName_whenProper_shouldReturnTrue() {
        boolean result = validator.validateLastName("Shinde");
        assertEquals(true, result);
    }

    @Test
    public void givenLastName_whenInitialLetterSmall_shouldReturnFalse() {
        boolean result = validator.validateLastName("shinde");
        assertEquals(false, result);
    }

    @Test
    public void givenLastName_whenLengthLessThanThree_shouldReturnFalse() {
        boolean result = validator.validateLastName("sh");
        assertEquals(false, result);
    }

    @Test
    public void givenMobileNo_whenProper_shouldReturnTrue() {
        boolean result = validator.validateMobileNumber("+91 9518905320");
        assertEquals(true, result);
    }

    @Test
    public void givenMobileNo_whenWithoutCountryCode_shouldReturnFalse() {
        boolean result = validator.validateMobileNumber("9518905320");
        assertEquals(false, result);
    }

    @Test
    public void givenMobileNo_whenLessThanTenDigit_shouldReturnFalse() {
        boolean result = validator.validateMobileNumber("+91 951890530");
        assertEquals(false, result);
    }

    @Test
    public void givenMobileNo_whenWithoutSpaceAfterCountryCode_shouldReturnFalse() {
        boolean result = validator.validateMobileNumber("+919518905320");
        assertEquals(false, result);
    }

    @Test
    public void givenMobileNo_whenWithConsecutiveZeros_shouldReturnFalse() {
        boolean result = validator.validateMobileNumber("+91 0000905320");
        assertEquals(false, result);
    }

    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("validPasswordProvider")
    public void givenPasswords_whenProperInput_shouldReturnTrue(String password) {
        boolean result = validator.validatePassword(password);
        assertEquals(true, result);

    }

    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("invalidPasswordProvider")
    public void givenPasswords_whenNotProperInput_shouldReturnFalse(String password) {
        boolean result = validator.validatePassword(password);
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
                "12@45&443e"
        );
    }
}
