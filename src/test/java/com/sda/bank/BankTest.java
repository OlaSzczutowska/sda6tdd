package com.sda.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

    private Bank bank;

    @Before
    public void init() {
        this.bank = new Bank("test");
    }

    @Test
    public void shouldAddNewUser() {
        //Given:

        User user = new User("Szymon", "Nowak");

        //When:
        boolean result = bank.addUser(user);

        //Then:
        Assert.assertTrue("Method returned false", result);
        Assert.assertEquals("User is not present in bank list", 1, bank.getNumberOfUsers());

    }

    @Test
    public void shouldNotAddNullUser() {
        User user = null;

        boolean result = bank.addUser(user);

        Assert.assertFalse("Method returned true", result);
        Assert.assertEquals("User is present in bank list.", 0, bank.getNumberOfUsers());
    }

}
