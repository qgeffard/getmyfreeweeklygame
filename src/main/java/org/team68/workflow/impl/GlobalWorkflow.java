package org.team68.workflow.impl;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.CollectionPage;
import org.team68.workflow.Workflow;

import java.io.IOException;
import java.util.Collection;


public class GlobalWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(GlobalWorkflow.class);

    private LoginWorkflow login = new LoginWorkflow();
    private PurchaseWorkflow purchase = new PurchaseWorkflow();
    private DiscordWorkflow discord = new DiscordWorkflow();
    private KeepassWorkflow keepass = new KeepassWorkflow();
    private CollectionPage collection = new CollectionPage();

    @Override
    public boolean execute() throws InterruptedException, IOException {

        //Hide Google Chrome
//        Configuration.headless = true;

        //login
        log.info("Starting login workflow");
        login.execute();
        log.info("End login workflow");

        //Purchase free game
        log.info("Starting purchase workflow");
        purchase.execute();
        log.info("End purchase workflow");

        //Discord notification
//        log.info("Starting discord workflow");
//        discord.execute();
//        log.info("End discord workflow");
        return false;
    }
}