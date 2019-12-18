package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.page.CollectionPage;
import org.team68.model.page.GamePage;
import org.team68.model.User;
import org.team68.workflow.Workflow;

import java.util.ArrayList;
import java.util.List;

public class PurchaseWorkflow implements Workflow {
    private CollectionPage collection = new CollectionPage();
    private Logger log = LoggerFactory.getLogger(PurchaseWorkflow.class);
    private List<GamePage> games = new ArrayList<>();

    @Override
    public boolean execute(User user) throws InterruptedException {
        // Open the collection game
        collection.open();

        //sleep for waiting
        Thread.sleep(5000);

        //Accept cookies
        collection.acceptCookies();

        //Open  and purchase the first
        Thread.sleep(4000);

        collection.getAllFreeGame().forEach(freeGame -> {
            try {
                freeGame.pegi().purchase().confirmPurchase().acceptRefund();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return true;
    }

    public CollectionPage getCollection() {
        return collection;
    }
}