package org.example;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationValidatorTest {
    @Test
    public void givenFirstName_whenProper_shouldReturnTrue() {
        UserRegistrationValidator validator = new UserRegistrationValidator();
        boolean result = validator.validateFirstName("Priyanka");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenFirstName_whenInitialLetterSmall_shouldReturnFalse() {
        UserRegistrationValidator validator = new UserRegistrationValidator();
        boolean result = validator.validateFirstName("priyanka");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenLengthLessThanThree_shouldReturnFalse() {
        UserRegistrationValidator validator = new UserRegistrationValidator();
        boolean result = validator.validateFirstName("Pr");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenInitialLetterSmallAndLengthIsLessThanThree_shouldReturnFalse() {
        UserRegistrationValidator validator = new UserRegistrationValidator();
        boolean result = validator.validateFirstName("pr");
        Assert.assertEquals(false, result);
    }
}
