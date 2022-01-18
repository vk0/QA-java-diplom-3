package com;

import com.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

import static com.Base.MAIN_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    @Test
    public void constructorTabsClickTest(){
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        Assert.assertTrue(mainPage.isVisibleTabs());
    }
}
