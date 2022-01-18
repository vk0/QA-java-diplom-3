package com;

import com.pages.LoginPage;
import com.pages.RegisterPage;
import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

import static com.Base.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;


public class RegisterTest {
    String INVALID_PASSWORD = "xxxxx";
    @Test
    public void createNewUserTest(){
        RegisterPage registerPage =  open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.fillDataField();
        LoginPage loginPage = registerPage.pressRegisterButton();
        Assert.assertNotNull(loginPage.isVisible());
    }
    @Test
    public void createNewUserShortPasswordTest() {
        RegisterPage registerPage =  open(REGISTER_PAGE_URL, RegisterPage.class);
        Map<String, String> m = UserOperations.getRandomData();
        String name = m.get("name");
        String email = m.get("email");
        String password = INVALID_PASSWORD;
        registerPage.fillDataField(name, email, password);
        registerPage.pressRegisterButton();
        Assert.assertTrue(registerPage.isVisibleWrongPass());
    }
}
