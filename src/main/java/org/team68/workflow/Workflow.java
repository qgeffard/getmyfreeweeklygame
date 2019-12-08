package org.team68.workflow;

import org.team68.model.GamePage;

import java.io.IOException;
import java.util.List;

public interface Workflow {
    boolean execute() throws InterruptedException, IOException;
}
