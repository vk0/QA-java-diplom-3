package com;
import com.codeborne.selenide.SelenideElement;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class Base {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String FORGOT_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    public static void scrollToElement(SelenideElement element){
        element.scrollTo();
    }

}
