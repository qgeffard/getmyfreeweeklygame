package org.team68.workflow;

import org.team68.model.User;

import java.io.IOException;

public interface Workflow {
    boolean execute(User user) throws InterruptedException, IOException;
}