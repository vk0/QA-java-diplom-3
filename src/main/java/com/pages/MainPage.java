package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    // войти в аккаунт
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginLink;

    // войти в аккаунт
    @FindBy(how = How.XPATH,using = ".//p[text()='Личный Кабинет']")
    private SelenideElement cabinetLink;

    // кнопка в авторизованном режиме
    @FindBy(how = How.XPATH,using = ".//button[text()='Оформить заказ']")
    private SelenideElement confirmOrderButton;

    // Булки
    @FindBy(how = How.XPATH,using = ".//span[text()='Булки']")
    private SelenideElement bulkiSpan;

    // Булки маркер
    @FindBy(how = How.XPATH,using = ".//h2[text()='Булки']")
    private SelenideElement bulkiMarker;

    // Соусы
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement sousSpan;

    // Соусы маркер
    @FindBy(how = How.XPATH,using = ".//h2[text()='Соусы']")
    private SelenideElement sousMarker;

    // Начинки
    @FindBy(how = How.XPATH,using = ".//span[text()='Начинки']")
    private SelenideElement nacinSpan;

    // Начинки маркер
    @FindBy(how = How.XPATH,using = ".//h2[text()='Начинки']")
    private SelenideElement nacinMarker;

    public LoginPage moveToLoginPageFromAccount(){
        loginLink.click();
        return Selenide.page(LoginPage.class);
    }

    public LoginPage moveToLoginPageFromCabinet(){
        cabinetLink.click();
        return Selenide.page(LoginPage.class);
    }

    public boolean isVisibleConfirmOrder(){
        try {
            confirmOrderButton.shouldBe(Condition.visible);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public AccountPage moveToAccount(){
        cabinetLink.click();
        return Selenide.page(AccountPage.class);
    }

    public boolean isVisibleTabs(){
        nacinSpan.click();
        nacinMarker.shouldBe(Condition.visible);
        bulkiSpan.click();
        bulkiMarker.shouldBe(Condition.visible);
        sousSpan.click();
        sousMarker.shouldBe(Condition.visible);
        return true;
    }
}
