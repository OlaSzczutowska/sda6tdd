package com.sda.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static int idCounter;
    private String name;
    private UserService userService;
    private AccountService accountService;

    public Bank(String name) {
        this.name = name;
        this.userService = new UserService();
        this.accountService = new AccountService();

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public boolean createAccount(int userId, Account account){
        boolean result = false;
        if(userService.isUserPresent(userId)){
            result = accountService.addAccount(account);
        }
        return result;
    }

    public Account getAccount(int accountId){
        return accountService.getAccount(accountId);
    }
    public boolean changeAmount(Account account, int amount){
        boolean result = false;
        if(accountService.isAccountPresent(account.getId())){
            account.setAmount(account.getAmount() + amount);
            result = true;
        }
        return result;
    }

    public int getNumberOfUsers(){
        return userService.getNumberOfUsers();
    }

    public int getNumberOfAccounts(){
        return accountService.getNumberOfAccounts();
    }

    public boolean addUser(User user) {
        boolean result = false;
        return userService.addUser(user);
    }


    public String getName() {
        return name;
    }

    public UserService getUserService() {
        return userService;
    }

    public AccountService getAccountService() {
        return accountService;
    }
}
