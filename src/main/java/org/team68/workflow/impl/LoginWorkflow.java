package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.LoginPage;
import org.team68.workflow.Workflow;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(LoginWorkflow.class);

    @Override
    public boolean execute() {
        log.info(loginEpicGames(LoginPage.USER_EMAIL));
        log.info(passWordEpicGames(LoginPage.USER_PASSWORD));

        log.info(clickLogin());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            log.error("Unexpected error", exception);
            return false;
        }
        return true;
    }

    private String loginEpicGames(String login) {
        open(LoginPage.EPICGAMES_LOGIN_URL);
        $x(LoginPage.EMAIL_INPUT_BOX).clear();
        $x(LoginPage.EMAIL_INPUT_BOX).sendKeys(login);
        return "loginEpicGames OK";
    }

    private String passWordEpicGames(String password) {
        $x(LoginPage.PASSWORD_INPUT_BOX).clear();
        $x(LoginPage.PASSWORD_INPUT_BOX).sendKeys(password);
        return "password";
    }

    private String clickLogin() {
        $x(LoginPage.LOGIN_NOW_BUTTON).click();
        return "ClickLogin OK";
    }
}
