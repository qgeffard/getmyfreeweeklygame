package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;

public class StorePage implements Page {
    public static final String URL = "https://www.epicgames.com/store/fr";
    public static final String CLOSE_COOKIES_BUTTON = "//button[@id='euCookieAccept']";
    public static final String CURRENT_FREE_GAME = "//span[text()='Gratuit maintenant']";
    GamePage game = new GamePage();

    public StorePage open() {
        Selenide.open(URL);
        return this;
    }

    public boolean purchaseFirstFreeGame() throws InterruptedException {

        if (game.isAlreadyOwned()) {
            return true;
        } else {
            // Purchase the game
            game.pegi()
                    .purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("Jeux 1 a achetez");
            return true;
        }
    }

    public boolean purchaseSecondFreeGame() throws InterruptedException {

        if (game.isAlreadyOwned()) {
            return true;
        } else {
            // Purchase the game
            game.pegi()
                    .purchase();
//                    .confirmPurchase()
//                    .acceptRefund();
            System.out.println("Jeux 2 a achetez");
            return true;
        }
    }

    public boolean purchaseThirdFreeGame() throws InterruptedException {

        if (game.isAlreadyOwned()) {
            return true;
        } else {
            // Purchase the game
            game.pegi()
                    .purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("Jeux 3 a achetez");
            return true;
        }
    }

    public boolean purchaseFourthFreeGame() throws InterruptedException {

        if (game.isAlreadyOwned()) {
            return true;
        } else {
            // Purchase the game
            game.pegi()
                    .purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("Jeux 4 a achetez");
            return true;
        }
    }

    public boolean purchaseFifthFreeGame() throws InterruptedException {

        if (game.isAlreadyOwned()) {
            return true;
        } else {
            // Purchase the game
            game.pegi()
                    .purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("Jeux 5 a achetez");
            return true;
        }
    }

    public boolean purchaseSixthFreeGame() throws InterruptedException {

        if (game.isAlreadyOwned()) {
            return true;
        } else {
            // Purchase the game
            game.pegi()
                    .purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("Jeux 6 a achetez");
            return true;
        }
    }
}