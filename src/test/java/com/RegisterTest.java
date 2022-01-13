package com;

import com.Base;
import com.pages.LoginPage;
import com.pages.RegisterPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;


public class RegisterTest {
    @Test
    public void createNewUserTest(){
        RegisterPage registerPage =  open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.fillDataField();
        LoginPage loginPage = registerPage.pressRegisterButton();
        Assert.assertNotNull(loginPage.isVisible());
    }
    @Test
    public void createNewUserShortPasswordTest() {
        RegisterPage registerPage =  open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);

        Map<String, String> m = UserOperations.getRandomData();
        String name = m.get("name");
        String email = m.get("email");
        String password = "12345";
        registerPage.fillDataField(name, email, password);
        registerPage.pressRegisterButton();

        Assert.assertTrue(registerPage.isVisibleWrongPass());
    }
}
