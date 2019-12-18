package org.team68.model.page;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage implements Page {
    public static final String URL = "https://www.epicgames.com/id/login";
    public static final String EMAIL_INPUT_BOX = "//input[@id='email']";
    public static final String PASSWORD_INPUT_BOX = "//input[@id='password']";
    public static final String LOGIN_BUTTON = "//button[@id='login']";

    public LoginPage open() {
        Selenide.open(URL);
        return this;
    }

    public LoginPage email(String login) {
        $x(EMAIL_INPUT_BOX).clear();
        $x(EMAIL_INPUT_BOX).sendKeys(login);
        return this;
    }

    public LoginPage password(String password) {
        $x(PASSWORD_INPUT_BOX).clear();
        $x(PASSWORD_INPUT_BOX).sendKeys(password);
        return this;
    }

    public LoginPage acceptlogin() {
        $x(LOGIN_BUTTON).click();
        return this;
    }
}