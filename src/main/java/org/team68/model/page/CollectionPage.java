package org.team68.model.page;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class CollectionPage implements Page {
    public static final String URL = "https://www.epicgames.com/store/fr/collection/free-game-collection";
    public static final String CLOSE_COOKIES_BUTTON = "//button[@id='euCookieAccept']";
    public static final String FREE_GAMES = "//a[contains(@href, '/store/fr/product')]";
    private List<GamePage> gamePageList = new ArrayList<>();

    public CollectionPage open() throws InterruptedException {
        Selenide.open(URL);
        Thread.sleep(2000);

        Selenide.$$x(FREE_GAMES).forEach(elem -> {
            gamePageList.add(new GamePage(elem.getAttribute("href")));
        });

        return this;
    }

    public void acceptCookies() {
        if ($x(CLOSE_COOKIES_BUTTON).exists())
            $x(CLOSE_COOKIES_BUTTON).click();
    }

    public List<GamePage> getAllFreeGame() throws InterruptedException {
       return this.gamePageList;
    }

}