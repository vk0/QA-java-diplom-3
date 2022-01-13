package com;

import com.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @Test
    public void loginFromMainPageCabinetTest(){ //scroll
        // c главной стр через кабинет
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        LoginPage loginPage = mainPage.moveToLoginPageFromCabinet();
        Assert.assertNotNull(loginPage.isVisible());
    }

    @Test
    public void loginFromRegisterFormTest() { //scroll
        //вход через кнопку в форме регистрации,
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        LoginPage loginPage = registerPage.clickEnterLink();
        Assert.assertNotNull(loginPage.isVisible());
    }

    @Test
    public void getLoginAndAuthTest(){
        UserOperations userOperations = new UserOperations();
        Map<String, String> map =  userOperations.register();
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.fillLoginField(map.get("email"), map.get("password"));
        MainPage mainPage = loginPage.pressEnterButton();
        //System.out.println((map.get("email")+  map.get("password")));
        Assert.assertNotNull(mainPage.isVisibleConfirmOrder());

        //Разлогиниться
        AccountPage account = mainPage.moveToAccount();
        Assert.assertTrue(account.isVisible());

        loginPage = account.exit();
        Assert.assertNotNull(loginPage.isVisible());
        userOperations.delete();
    }

    @Test
    public void loginFromMainPageEnterAccountTest(){
        // c главной стр
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        LoginPage loginPage = mainPage.moveToLoginPageFromAccount();
        Assert.assertNotNull(loginPage.isVisible());
    }

    @Test
    public void loginFromForgotFormTest() {
        //вход через кнопку в форме восстановления пароля.
        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
        LoginPage loginPage = forgotPasswordPage.clickEnterLink();
        Assert.assertNotNull(loginPage.isVisible());
    }
}
