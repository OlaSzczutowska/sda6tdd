package com.sda.bank;

import cucumber.api.java.cs.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

    @Test
    public void shouldCreateAccountForGivenUser() {
        UserService mockUserService = Mockito.mock(UserService.class);
        AccountService mockAccountService = Mockito.mock(AccountService.class);

        Mockito.when(mockUserService.addUser(Mockito.any(User.class))).thenReturn(true);
        Mockito.when(mockUserService.getNumberOfUsers()).thenReturn(1);
        Mockito.when(mockUserService.isUserPresent(Mockito.any(Integer.class))).thenReturn(true);

        Mockito.when(mockAccountService.addAccount(Mockito.any(Account.class))).thenReturn(true);
        Mockito.when(mockAccountService.getNumberOfAccounts()).thenReturn(1);

        bank.setAccountService(mockAccountService);
        bank.setUserService(mockUserService);

        User user = new User("Szymon", "Nowak");
        Account account = new Account(0, 0);

        boolean userAddResult = bank.addUser(user);
        boolean accountAddResult = bank.createAccount(0, account);

        Assert.assertTrue("User is not present in bank list.", userAddResult);
        Assert.assertEquals("User is not present in bank list.", 1, bank.getNumberOfUsers());
        Assert.assertTrue("Account is not present in bank list.", accountAddResult);
        Assert.assertEquals("Account is not present in bank list.", 1, bank.getNumberOfAccounts());


    }

    @Test
    public void shouldNotCreateAccountForNotExistingUser() {
        //Given:
        Account account = new Account(10,0);
        UserService mockUserService = Mockito.mock(UserService.class);
        AccountService mockAccountService = Mockito.mock(AccountService.class);


        Mockito.when(mockUserService.isUserPresent(Mockito.any(Integer.class))).thenReturn(false);
        Mockito.when(mockAccountService.addAccount(Mockito.any(Account.class))).thenReturn(false);
        Mockito.when(mockAccountService.getNumberOfAccounts()).thenReturn(0);

        bank.setUserService(mockUserService);
        bank.setAccountService(mockAccountService);

        //When:
        boolean result = bank.createAccount(10,account);

        //Then:
        Assert.assertFalse("Account is created", result);
        Assert.assertEquals("Account is present", 0, bank.getNumberOfAccounts());
    }

}
