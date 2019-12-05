package org.team68;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

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

    private String clicLogin() {
        $x("//button[@id='login']").click();
        return "ClicLogin OK";
    }

    private String storEpicGames() {
        open("https://www.epicgames.com/store/fr"); //Allez dans le store epicgames
        $x("//span/a[1]()='Gratuit maintenant'"); //Récup le 1er parent du span
//        $x("//a/div/div/span/text()='Gratuit maintenant']");
//        $x("//a[contains(@rel, 'Gratuit maintenant')]");
        return "Store EpicGames OK";
    }

    private String passWordEpicGames(String password) {
        $x("//input[@id='password']").clear();
        $x("//input[@id='password']").sendKeys(password);
        return "passWordEpicGames OK";
    }

    private String loginEpicGames(String login) {
        open("https://www.epicgames.com/id/login");
        $x("//input[@id='email']").clear();
        $x("//input[@id='email']").sendKeys(login);
        return "loginEpicGames OK";
    }

//    private String clicLogin() {
//        log.info(String.valueOf($x("//button[@id='login']").exists()));
//        return "ClicLogin OK";
//    }

//    private static String proposalTranslation(String source) {
//        PhantomJsDriverManager.phantomjs().setup();
//        Configuration.headless = true;
//        open("https://translate.google.com/?hl=fr#view=home&op=translate&sl=en&tl=fr");
//        $x("//textarea[@id='source']").clear();
//        $x("//textarea[@id='source']").sendKeys(source);
//        return $x("//span[@class='tlid-translation translation']").getText();
//    }
}