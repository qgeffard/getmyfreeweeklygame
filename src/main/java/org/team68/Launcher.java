package org.team68;

import org.team68.workflow.impl.GlobalWorkflow;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws InterruptedException, IOException {
        GlobalWorkflow grabNewGame = new GlobalWorkflow();
        grabNewGame.execute();
    }
}
