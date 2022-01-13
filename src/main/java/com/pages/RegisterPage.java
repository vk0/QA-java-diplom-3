package com.pages;


import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;


public class RegisterPage {
    // имя
    // email
    // пароль
    private By registerFields = By.xpath(".//input");

    // зарегистрироваться
    @FindBy(how = How.XPATH,using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    // зарегистрироваться
    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement wrongPass;

    // ссылка Войти
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement enterLink;


    public void fillDataField(String ...arg){
        String name;
        String email;
        String password;

        if(arg.length<3) {
            Map<String, String> m = UserOperations.getRandomData();
            name = m.get("name");
            email = m.get("email");
            password = m.get("password");
        } else {
            name = arg[0];
            email = arg[1];
            password = arg[2];
        }
        Selenide.$$(registerFields).get(0).setValue(name); // name
        Selenide.$$(registerFields).get(1).setValue(email); // email
        Selenide.$$(registerFields).get(2).setValue(password); // password
    }

    public LoginPage pressRegisterButton(){
        registerButton.click();
        return Selenide.page(LoginPage.class);
    }

    public boolean isVisibleWrongPass(){
        SelenideElement i = wrongPass.shouldBe(Condition.visible);
        return true;
    }

    public LoginPage clickEnterLink(){
        enterLink.click();
        return Selenide.page(LoginPage.class);
    }
}


