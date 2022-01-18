package com;

import com.pages.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

import static com.Base.*;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @Test
    public void loginFromMainPageCabinetTest(){ //scroll
        // c главной стр через кабинет
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        LoginPage loginPage = mainPage.moveToLoginPageFromCabinet();
        Assert.assertNotNull(loginPage.isVisible());
    }

    @Test
    public void loginFromRegisterFormTest() { //scroll
        //вход через кнопку в форме регистрации,
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        LoginPage loginPage = registerPage.clickEnterLink();
        Assert.assertNotNull(loginPage.isVisible());
    }

    @Test
    public void getLoginAndAuthTest(){
        UserOperations userOperations = new UserOperations();
        Map<String, String> map =  userOperations.register();
        LoginPage loginPage = open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.fillLoginField(map.get("email"), map.get("password"));
        MainPage mainPage = loginPage.pressEnterButton();
        Assert.assertTrue(mainPage.isVisibleConfirmOrder());
        //Разлогиниться
        AccountPage account = mainPage.moveToAccount();
        Assert.assertTrue(account.isVisible());
        loginPage = account.exit();
        Assert.assertTrue(loginPage.isVisible());
        userOperations.delete();
    }

    @Test
    public void loginFromMainPageEnterAccountTest(){
        // c главной стр
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        LoginPage loginPage = mainPage.moveToLoginPageFromAccount();
        Assert.assertNotNull(loginPage.isVisible());
    }

    @Test
    public void loginFromForgotFormTest() {
        //вход через кнопку в форме восстановления пароля.
        ForgotPasswordPage forgotPasswordPage = open(FORGOT_PAGE_URL, ForgotPasswordPage.class);
        LoginPage loginPage = forgotPasswordPage.clickEnterLink();
        Assert.assertNotNull(loginPage.isVisible());
    }
}
