package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class CollectionPage implements Page {
    public static final String URL = "https://www.epicgames.com/store/fr/collection/free-game-collection";
    public static final String CLOSE_COOKIES_BUTTON = "//button[@id='euCookieAccept']";
    public static final String FIRST_FREE_GAME = "(//a[contains(@href, '/store/fr/product')])[1]";
    public static final String SECOND_FREE_GAME = "(//a[contains(@href, '/store/fr/product')])[2]";
    public static final String THIRD_FREE_GAME = "(//a[contains(@href, '/store/fr/product')])[3]";
    public static final String FOURTH_FREE_GAME = "(//a[contains(@href, '/store/fr/product')])[4]";
    public static final String FIFTH_FREE_GAME = "(//a[contains(@href, '/store/fr/product')])[5]";
    public static final String SIXTH_FREE_GAME = "(//a[contains(@href, '/store/fr/product')])[6]";
//    private boolean FIRST_FREE_GAME_URL = ;

    public CollectionPage open() {
        Selenide.open(URL);
        return this;
    }

    public void acceptCookies() {
        if ($x(CLOSE_COOKIES_BUTTON).exists())
            $x(CLOSE_COOKIES_BUTTON).click();
    }

    public void getFirstFreeGame() throws InterruptedException {
        if ($x(FIRST_FREE_GAME).exists()) {
            String currentFreeGame = (FIRST_FREE_GAME);
            String currentFreeGameUrl = $x(FIRST_FREE_GAME).getAttribute("href");
            $x(currentFreeGame + "/div/div/div").click();
            Thread.sleep(5000);
            System.out.println(currentFreeGameUrl + "est gratuit en ce moment");
        } else {
            System.out.println("Vérification 1 pas de jeu");
        }
    }

    public void getSecondFreeGame() throws InterruptedException {
        if ($x(SECOND_FREE_GAME).exists()) {
            String currentFreeGame = (SECOND_FREE_GAME);
            String currentFreeGameUrl = $x(SECOND_FREE_GAME).getAttribute("href");
            $x(currentFreeGame + "/div/div/div").click();
            Thread.sleep(5000);
            System.out.println(currentFreeGameUrl + "est gratuit en ce moment");
        } else {
            System.out.println("Vérification 2 pas de jeu");
        }
    }

    public void getThirdFreeGame() throws InterruptedException {
        if ($x(THIRD_FREE_GAME).exists()) {
            String currentFreeGame = (THIRD_FREE_GAME);
            String currentFreeGameUrl = $x(THIRD_FREE_GAME).getAttribute("href");
            $x(currentFreeGame + "/div/div/div").click();
            Thread.sleep(5000);
            System.out.println(currentFreeGameUrl + "est gratuit en ce moment");
        } else {
            System.out.println("Vérification 3 pas de jeu");
        }
    }

    public void getFourthFreeGame() throws InterruptedException {
        if ($x(FOURTH_FREE_GAME).exists()) {
            String currentFreeGame = (FOURTH_FREE_GAME);
            String currentFreeGameUrl = $x(FOURTH_FREE_GAME).getAttribute("href");
            $x(currentFreeGame + "/div/div/div").click();
            Thread.sleep(5000);
            System.out.println(currentFreeGameUrl + "est gratuit en ce moment");
        } else {
            System.out.println("Vérification 4 pas de jeu");
        }
    }

    public void getFifthFreeGame() throws InterruptedException {
        if ($x(FIFTH_FREE_GAME).exists()) {
            String currentFreeGame = (FIFTH_FREE_GAME);
            String currentFreeGameUrl = $x(FIFTH_FREE_GAME).getAttribute("href");
            $x(currentFreeGame + "/div/div/div").click();
            Thread.sleep(5000);
            System.out.println(currentFreeGameUrl + "est gratuit en ce moment");
        } else {
            System.out.println("Vérification 5 pas de jeu");
        }
    }

    public void getSixthFreeGame() throws InterruptedException {
        if ($x(SIXTH_FREE_GAME).exists()) {
            String currentFreeGame = (SIXTH_FREE_GAME);
            String currentFreeGameUrl = $x(SIXTH_FREE_GAME).getAttribute("href");
            $x(currentFreeGame + "/div/div/div").click();
            Thread.sleep(5000);
            System.out.println(currentFreeGameUrl + "est gratuit en ce moment");
        } else {
            System.out.println("Vérification 6 pas de jeu");
        }
    }
}