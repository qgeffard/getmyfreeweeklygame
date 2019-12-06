package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.workflow.Workflow;

public class GlobalWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(GlobalWorkflow.class);

    private Workflow login = new LoginWorkflow();
    private Workflow purchase = new PurchaseWorkflow();

    @Override
    public boolean execute() throws InterruptedException {
        //login
        log.info("Starting login workflow");
        login.execute();
        log.info("End login workflow");

        //Purchase free game
        log.info("Starting purchase workflow");
        purchase.execute();
        log.info("End purchase workflow");

        return true;
    }
}