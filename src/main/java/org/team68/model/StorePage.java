package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;
import org.team68.workflow.impl.DiscordWorkflow;

public class StorePage implements Page {
    public static final String URL = "https://www.epicgames.com/store/fr";
    public static final String CLOSE_COOKIES_BUTTON = "//button[@id='euCookieAccept']";
    public static final String CURRENT_FREE_GAME = "//span[text()='Gratuit maintenant']";
    GamePage game = new GamePage();
    private DiscordWorkflow discord = new DiscordWorkflow();

    public StorePage open() {
        Selenide.open(URL);
        return this;
    }

    public boolean purchaseFirstFreeGame() throws InterruptedException {

        game.pegi();
        if (game.isAlreadyOwned()) {
            System.out.println("[1] Ce jeu est déjà dans votre bibliothèque");
            return true;
        } else {
            // Purchase the game
            discord.execute();
            game.purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("[1] ce jeu a été ajouter à votre bibliothèque");
            return true;
        }
    }

    public boolean purchaseSecondFreeGame() throws InterruptedException {

        game.pegi();
        if (game.isAlreadyOwned()) {
            System.out.println("[2] Ce jeu est déjà dans votre bibliothèque");
            return true;
        } else {
            // Purchase the game
            discord.execute();
            game.purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("[2] ce jeu a été ajouter à votre bibliothèque");
            return true;
        }
    }

    public boolean purchaseThirdFreeGame() throws InterruptedException {

        game.pegi();
        if (game.isAlreadyOwned()) {
            System.out.println("[3] Ce jeu est déjà dans votre bibliothèque");
            return true;
        } else {
            // Purchase the game
            discord.execute();
            game.purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("[3] ce jeu a été ajouter à votre bibliothèque");
            return true;
        }
    }

    public boolean purchaseFourthFreeGame() throws InterruptedException {

        game.pegi();
        if (game.isAlreadyOwned()) {
            System.out.println("[4] Ce jeu est déjà dans votre bibliothèque");
            return true;
        } else {
            // Purchase the game
            game.purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("[4] ce jeu a été ajouter à votre bibliothèque");
            return true;
        }
    }

    public boolean purchaseFifthFreeGame() throws InterruptedException {

        game.pegi();
        if (game.isAlreadyOwned()) {
            System.out.println("[5] Ce jeu est déjà dans votre bibliothèque");
            return true;
        } else {
            // Purchase the game
            game.purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("[5] ce jeu a été ajouter à votre bibliothèque");
            return true;
        }
    }

    public boolean purchaseSixthFreeGame() throws InterruptedException {

        game.pegi();
        if (game.isAlreadyOwned()) {
            System.out.println("[6] Ce jeu est déjà dans votre bibliothèque");
            return true;
        } else {
            // Purchase the game
            game.purchase()
                    .confirmPurchase()
                    .acceptRefund();
            System.out.println("[6] ce jeu a été ajouter à votre bibliothèque");
            return true;
        }
    }
}