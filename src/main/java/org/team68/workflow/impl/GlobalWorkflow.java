package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.User;
import org.team68.util.DiscordUtil;
import org.team68.workflow.Workflow;

import java.io.IOException;


public class GlobalWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(GlobalWorkflow.class);

    private LoginWorkflow login = new LoginWorkflow();
    private PurchaseWorkflow purchase = new PurchaseWorkflow();
    private DiscordUtil discord = new DiscordUtil();

    @Override
    public boolean execute(User user) throws InterruptedException, IOException {

        //Hide Google Chrome
//        Configuration.headless = true;

        //login
        log.info("Starting login workflow");
        login.execute(user);
        log.info("End login workflow");

        //Purchase free game
        log.info("Starting purchase workflow");
        purchase.execute(user);
        log.info("End purchase workflow");

        //Discord notification
        log.info("Starting discord workflow");
        discord.sendNotification(user, purchase.getCollection().getAllFreeGame());
        log.info("End discord workflow");
        return false;
    }
}