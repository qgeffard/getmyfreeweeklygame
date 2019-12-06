package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.GamePage;
import org.team68.model.StorePage;
import org.team68.workflow.Workflow;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PurchaseWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(PurchaseWorkflow.class);

    StorePage store = new StorePage();

    @Override
    public boolean execute() {
        // Open the store
        store.open();

        //Accept cookies
        store.acceptCookies();

        //Retrieve and open the game web page
        GamePage game = store.getFreeWeeklyGame();
        game.open();

        //If the game is already owned by the user, we can stop here the workflow
        if(game.isAlreadyOwned())
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





}
