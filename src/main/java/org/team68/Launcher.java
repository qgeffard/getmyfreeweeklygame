package org.team68;

import org.team68.util.KeepassUtil;
import org.team68.workflow.impl.GlobalWorkflow;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException, InterruptedException {
        GlobalWorkflow grabNewGames = new GlobalWorkflow();

        new KeepassUtil().getDatabaseAsUser().forEach(user -> {
            try {
                grabNewGames.execute(user);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        });
    }
}