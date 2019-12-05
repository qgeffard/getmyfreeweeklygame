package org.team68;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class GrabNewGame {
    private Logger log = LoggerFactory.getLogger(GrabNewGame.class);

    public void execute() throws InterruptedException {
        log.info("Hello Mede & Quentin, I will grab your free weekly game for you");
        log.info(loginEpicGames("medequent@gmail.com"));
        log.info(passWordEpicGames("f48273g8iuoyerfwyg987234"));
        log.info(clicLogin());
        log.info(storeEpicGames());
        Thread.sleep(10000);
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

    private String clicLogin() throws InterruptedException {
        $x("//button[@id='login']").click();
        Thread.sleep(4000);
        return "ClicLogin OK";
    }

    private String storeEpicGames() {
        open("https://www.epicgames.com/store/fr"); //Allez dans le store epicgames
//        SelenideElement element1 = $x("//span/a[1]()='Gratuit maintenant'"); //Récup le 1er parent du span
        String urlfreegame = $x("//span[text()='Gratuit maintenant']").parent().parent().parent().getAttribute("href");
        open(urlfreegame);
        return "Store EpicGames OK";
    }
}