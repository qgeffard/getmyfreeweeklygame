package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.workflow.Workflow;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(LoginWorkflow.class);

    @Override
    public boolean execute() {
        log.info(loginEpicGames("medequent@gmail.com"));
        log.info(passWordEpicGames("f48273g8iuoyerfwyg987234"));

        log.info(clicLogin());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            log.error("Unexpected error", exception);
            return false;
        }
        return true;
    }

    private String loginEpicGames(String login) {
        open("https://www.epicgames.com/id/login");
        $x("//input[@id='email']").clear();
        $x("//input[@id='email']").sendKeys(login);
        return "loginEpicGames OK";
    }

    private String passWordEpicGames(String password) {
        $x("//input[@id='password']").clear();
        $x("//input[@id='password']").sendKeys(password);
        return "password";
    }

    private String clicLogin() {
        $x("//button[@id='login']").click();
        return "ClicLogin OK";
    }
}
