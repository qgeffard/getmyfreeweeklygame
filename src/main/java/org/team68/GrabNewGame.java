package org.team68;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
        log.info(storEpicGames());
        Thread.sleep(4000);
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
        return "passWordEpicGames OK";
    }

    private String clicLogin() {
        $x("//button[@id='login']").click();
        return "ClicLogin OK";
    }

    private String storEpicGames() {
        forward("https://www.epicgames.com/store/fr"); //Allez dans le store epicgames
//        SelenideElement element1 = $x("//span/a[1]()='Gratuit maintenant'"); //Récup le 1er parent du span
        String urlfreegame = $x("//span[text()='Gratuit maintenant']").parent().parent().parent().getAttribute("href");
        open(urlfreegame);
        return "Store EpicGames OK";
    }
}