package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.GamePage;
import org.team68.model.StorePage;
import org.team68.workflow.Workflow;

import java.util.ArrayList;
import java.util.List;

public class PurchaseWorkflow implements Workflow {
    StorePage store = new StorePage();
    private Logger log = LoggerFactory.getLogger(PurchaseWorkflow.class);

    private List<GamePage> games = new ArrayList<>();

    @Override
    public boolean execute() {
        // Open the store
        store.open();

        //Accept cookies
        store.acceptCookies();

        //Retrieve and open the game web page
        GamePage game = store.getFreeWeeklyGame();
        this.games.add(game);
        game.open();

        //If the game is already owned by the user, we can stop here the workflow
        if (game.isAlreadyOwned())
            return true;

        // Purchase the game
        try {
            game.purchase()
                    .confirmPurchase()
                    .acceptRefund();
        } catch (InterruptedException exception) {
            log.error("Unexpected error", exception);
            return false;
        }
        return true;
    }

    public List<GamePage> getGames() {
        return games;
    }
}
