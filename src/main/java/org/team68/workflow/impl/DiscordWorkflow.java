package org.team68.workflow.impl;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.GamePage;
import org.team68.workflow.Workflow;

import java.io.IOException;
import java.util.List;

public class DiscordWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(DiscordWorkflow.class);


    public static final String WEBHOOK_URL = "https://discordapp.com/api/webhooks/652764044994019348/DIHuf_xa7W4zjLsfCJBP4EQoGGFSt4ccMlUMno5jRVDzTnyv9qFR99ETB3q8xmpMyz3i";
    public static final String WEBHOOK_HEADERS_KEY = "Content-Type";
    public static final String WEBHOOK_HEADERS_VALUE = "application/json";
    public static final String gameTitle = "Pacman";


    public void execute(List<GamePage> games) throws IOException {

        String gameTitle = games.stream().findFirst().get().getTitle();

        log.info("Titre du jeu : {}", gameTitle);

        CloseableHttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

        String userId = "**<@184411677469573121>**";
        StringEntity content = new StringEntity("{\"content\":\"" + userId + " i have grab **" + gameTitle + "** game for you :gift:\"}");

        HttpPost request = new HttpPost(WEBHOOK_URL);
        request.addHeader(WEBHOOK_HEADERS_KEY, WEBHOOK_HEADERS_VALUE);
        request.setEntity(content);
        httpClient.execute(request);
    }

    @Override
    public boolean execute() throws InterruptedException {
        return false;
    }
}