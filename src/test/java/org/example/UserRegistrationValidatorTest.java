package org.example;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationValidatorTest {
    UserRegistrationValidator validator = new UserRegistrationValidator();

    @Test
    public void givenFirstName_whenProper_shouldReturnTrue() {
        boolean result = validator.validateFirstName("Priyanka");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenFirstName_whenInitialLetterSmall_shouldReturnFalse() {
        boolean result = validator.validateFirstName("priyanka");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenLengthLessThanThree_shouldReturnFalse() {
        boolean result = validator.validateFirstName("Pr");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenInitialLetterSmallAndLengthIsLessThanThree_shouldReturnFalse() {
        boolean result = validator.validateFirstName("pr");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastName_whenProper_shouldReturnTrue() {
        boolean result = validator.validateLastName("Shinde");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenLastName_whenInitialLetterSmall_shouldReturnFalse() {
        boolean result = validator.validateLastName("shinde");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastName_whenLengthLessThanThree_shouldReturnFalse() {
        boolean result = validator.validateLastName("sh");
        Assert.assertEquals(false, result);
    }
}
