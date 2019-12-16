package org.team68.workflow;

import java.io.IOException;

public interface Workflow {
    boolean execute() throws InterruptedException, IOException;
}