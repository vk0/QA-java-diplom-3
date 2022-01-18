package com.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    // ссылка Войти
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement enterLink;

    public LoginPage clickEnterLink(){
        enterLink.click();
        return Selenide.page(LoginPage.class);
    }
}
