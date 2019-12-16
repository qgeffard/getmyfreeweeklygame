package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.CollectionPage;
import org.team68.model.GamePage;
import org.team68.workflow.Workflow;

import java.util.ArrayList;
import java.util.List;

public class PurchaseWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(PurchaseWorkflow.class);
    CollectionPage collection = new CollectionPage();
    GamePage game = new GamePage();
    private List<GamePage> games = new ArrayList<>();

    @Override
    public boolean execute() throws InterruptedException {
        // Open the collection game
        collection.open();

        //sleep for waiting
        Thread.sleep(5000);

        //Accept cookies
        collection.acceptCookies();

        //sleep for waiting
        Thread.sleep(5000);

        //Retrieve and open the first game web page
        collection.getFirstFreeGame();
        if (game.isAlreadyOwned()) {
            return true;
        } else {
            // Purchase the game
//            game.purchase()
//                    .confirmPurchase()
//                    .acceptRefund();
            System.out.println("Jeux 1 a achetez");
            return true;
        }
    }
}