package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.CollectionPage;
import org.team68.model.GamePage;
import org.team68.model.StorePage;
import org.team68.workflow.Workflow;

import java.util.ArrayList;
import java.util.List;

public class PurchaseWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(PurchaseWorkflow.class);
    CollectionPage collection = new CollectionPage();
    StorePage store = new StorePage();
    private List<GamePage> games = new ArrayList<>();

    @Override
    public boolean execute() throws InterruptedException {
        // Open the collection game
        collection.open();

        //sleep for waiting
        Thread.sleep(5000);

        //Accept cookies
        collection.acceptCookies();

        //Open  and purchase the first
        Thread.sleep(4000);
        collection.getFirstFreeGame();
        store.purchaseFirstFreeGame();

        //Open  and purchase the Second
        collection.open();
        Thread.sleep(4000);
        collection.getSecondFreeGame();
        store.purchaseSecondFreeGame();

        //Open  and purchase the Third
        collection.open();
        Thread.sleep(4000);
        collection.getThirdFreeGame();
        store.purchaseThirdFreeGame();

        //Open  and purchase the Fourth
        collection.open();
        Thread.sleep(4000);
        collection.getFourthFreeGame();
        store.purchaseFourthFreeGame();

        //Open  and purchase the Fifth
        collection.open();
        Thread.sleep(4000);
        collection.getFifthFreeGame();
        store.purchaseFifthFreeGame();

        //Open  and purchase the Sixth
        collection.open();
        Thread.sleep(4000);
        collection.getSixthFreeGame();
        store.purchaseSixthFreeGame();
        return false;
    }
}