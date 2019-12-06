package org.team68;

import org.team68.workflow.impl.GlobalWorkflow;

public class Launcher {

    public static void main(String[] args) throws InterruptedException {
        GlobalWorkflow grabNewGame = new GlobalWorkflow();
        grabNewGame.execute();
    }
}
