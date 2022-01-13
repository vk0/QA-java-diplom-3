package com;

import com.pages.LoginPage;
import com.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    @Test
    public void constructorTabsClickTest(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        Assert.assertTrue(mainPage.isVisibleTabs());
    }
}
