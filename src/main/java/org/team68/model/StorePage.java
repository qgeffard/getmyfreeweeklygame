package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class StorePage implements Page {
    public static final String EPICGAMES_STORE_FR_URL = "https://www.epicgames.com/store/fr";
    public static final String ACCEPT_COOKIES_BUTTON = "//button[@id='euCookieAccept']";
    public static final String CURRENT_FREE_GAME = "//span[text()='Gratuit maintenant']";

    public StorePage open() {
        Selenide.open(EPICGAMES_STORE_FR_URL);
        return this;
    }

    public GamePage getFreeWeeklyGame() {
        //TODO : manage the fact where there are more than one epic gems offered this week
        String urlfreegame = $x(CURRENT_FREE_GAME).parent().parent().parent().getAttribute("href");
        return new GamePage(urlfreegame);
    }

    public void acceptCookies() {
        if ($x(ACCEPT_COOKIES_BUTTON).exists())
            $x(ACCEPT_COOKIES_BUTTON).click();
    }
}
