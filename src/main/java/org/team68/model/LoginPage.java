package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage implements Page {
    public static final String URL = "https://www.epicgames.com/id/login";
    public static final String EMAIL_INPUT_BOX = "//input[@id='email']";
    public static final String PASSWORD_INPUT_BOX = "//input[@id='password']";
    public static final String LOGIN_BUTTON = "//button[@id='login']";
    public static final String USER_EMAIL = "medequent@gmail.com";
    public static final String USER_PASSWORD = "f48273g8iuoyerfwyg987234";

    public LoginPage open() {
        Selenide.open(URL);
        return this;
    }

    public LoginPage email() {
        $x(EMAIL_INPUT_BOX).clear();
        $x(EMAIL_INPUT_BOX).sendKeys(USER_EMAIL);
        return this;
    }

    public LoginPage password() {
        $x(PASSWORD_INPUT_BOX).clear();
        $x(PASSWORD_INPUT_BOX).sendKeys(USER_PASSWORD);
        return this;
    }

    public LoginPage acceptlogin() {
        $x(LOGIN_BUTTON).click();
        return this;
    }
}