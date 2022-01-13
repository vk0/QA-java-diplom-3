package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AccountPage {
    // личный кабинет

    // кнопка Выйти
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    // кнопка Конструктор
    @FindBy(how = How.XPATH,using = ".//p[text()='Конструктор']")
    private SelenideElement constructorLink;

    // root links
    private By logoLinks = By.xpath(".//a[@href='/']");


    public LoginPage exit(){
        exitButton.click();
        return page(LoginPage.class);
    }
    public boolean isVisible(){
        SelenideElement i = exitButton.shouldBe(Condition.visible);
        return true;
    }

    public MainPage moveToConstructor(){
        constructorLink.click();
        return Selenide.page(MainPage.class);
    }

    public MainPage moveToConstructorByLogo(){
        Selenide.$$(logoLinks).get(1).click();
        return Selenide.page(MainPage.class);
    }

}
