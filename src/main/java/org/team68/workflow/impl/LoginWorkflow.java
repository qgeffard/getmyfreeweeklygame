package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.page.LoginPage;
import org.team68.model.User;
import org.team68.workflow.Workflow;

public class LoginWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(LoginWorkflow.class);
    LoginPage login = new LoginPage();


    @Override
    public boolean execute(User user) throws InterruptedException {
        //Open login page
        login.open();

        //Enter LoginEmail
        login.email(user.getLogin());

        //Enter Password
        login.password(user.getPassword());

        //click in the button Login
        login.acceptlogin();

        //sleep for waiting
        Thread.sleep(3000);
        return false;
    }
}