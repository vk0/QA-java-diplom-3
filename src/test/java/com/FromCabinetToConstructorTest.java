package com;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

import static com.Base.LOGIN_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;

public class FromCabinetToConstructorTest {
    @Test
    public void moveFromCabinetToConstructorTest(){
        UserOperations userOperations = new UserOperations();
        Map<String, String> map =  userOperations.register();
        LoginPage loginPage = open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.fillLoginField(map.get("email"), map.get("password"));
        MainPage mainPage = loginPage.pressEnterButton();
        AccountPage account = mainPage.moveToAccount();
        mainPage = account.moveToConstructor();
        Assert.assertTrue(mainPage.isVisibleConfirmOrder());
        userOperations.delete();
    }

    @Test
    public void moveFromCabinetToConstructorByLogoTest(){
        UserOperations userOperations = new UserOperations();
        Map<String, String> map =  userOperations.register();
        LoginPage loginPage = open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.fillLoginField(map.get("email"), map.get("password"));
        MainPage mainPage = loginPage.pressEnterButton();
        AccountPage account = mainPage.moveToAccount();
        mainPage = account.moveToConstructorByLogo();
        Assert.assertTrue(mainPage.isVisibleConfirmOrder());
        userOperations.delete();
    }
}
