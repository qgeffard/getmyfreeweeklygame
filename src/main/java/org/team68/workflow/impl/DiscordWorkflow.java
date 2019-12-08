package org.team68.workflow.impl;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.GamePage;
import org.team68.model.StorePage;
import org.team68.workflow.Workflow;

public class DiscordWorkflow implements Workflow {
    StorePage store = new StorePage();
    GamePage game = new GamePage();
    public static final String WEBHOOK_URL = "https://discordapp.com/api/webhooks/652764044994019348/DIHuf_xa7W4zjLsfCJBP4EQoGGFSt4ccMlUMno5jRVDzTnyv9qFR99ETB3q8xmpMyz3i";
    public static final String WEBHOOK_HEADERS_KEY = "Content-Type";
    public static final String WEBHOOK_HEADERS_VALUE = "application/json";
    private String WEBHOOK_USER_ID = "<@!226404349201481728>";
    private String WEBHOOK_NAME_FREE_GAME = "**PacMan**";
    private String WEBHOOK_CONTENT = "{\"content\":\"" + WEBHOOK_USER_ID + " i have grab " + WEBHOOK_NAME_FREE_GAME + " game for you :gift:\"}";

    private Logger log = LoggerFactory.getLogger(GlobalWorkflow.class);

    @Override
    public boolean execute() throws InterruptedException {

        log.info("Starting find name of the free game");
        game.getFreeGameName();
        log.info("End find free name of the free game");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
        try {
            HttpPost request = new HttpPost(WEBHOOK_URL);
            StringEntity content = new StringEntity(WEBHOOK_CONTENT);
            request.addHeader(WEBHOOK_HEADERS_KEY, WEBHOOK_HEADERS_VALUE);
            request.setEntity(content);
            httpClient.execute(request);

        } catch (Exception ex) {
            //handle exception here

        } finally {
            //Deprecated
            //httpClient.getConnectionManager().shutdown();
        }
//
        return true;
    }
}