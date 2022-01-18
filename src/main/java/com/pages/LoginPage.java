package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    //https://stellarburgers.nomoreparties.site/login
    // маркер страницы
    @FindBy(how = How.XPATH,using = ".//p[text()='Забыли пароль?']")
    private SelenideElement fogotLink;

    // email
    // password
    private By loginFields = By.xpath(".//input");

    // кнопка Войти
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    public boolean isVisible(){
        try {
            SelenideElement i = fogotLink.shouldBe(Condition.visible);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void fillLoginField(String ...arg){
        String email = arg[0];
        String password = arg[1];
        Selenide.$$(loginFields).get(0).setValue(email); // email
        Selenide.$$(loginFields).get(1).setValue(password); // password
    }

    public MainPage pressEnterButton(){
        enterButton.click();
        return Selenide.page(MainPage.class);
    }
}
