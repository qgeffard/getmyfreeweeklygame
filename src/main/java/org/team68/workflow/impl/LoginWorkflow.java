package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.LoginPage;
import org.team68.workflow.Workflow;

public class LoginWorkflow implements Workflow {
    LoginPage login = new LoginPage();
    private Logger log = LoggerFactory.getLogger(LoginWorkflow.class);

    @Override
    public boolean execute() throws InterruptedException {
        //Open login page
        login.open();

        //Enter LoginEmail
        login.email();

        //Enter Password
        login.password();

        //click in the button Login
        login.acceptlogin();

        //sleep for waiting
        Thread.sleep(4000);
        return true;
    }
}
