package org.team68.util;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.model.page.GamePage;
import org.team68.model.User;

import java.io.IOException;
import java.util.List;

public class DiscordUtil {
    private Logger log = LoggerFactory.getLogger(DiscordUtil.class);


    public static final String WEBHOOK_URL = "https://discordapp.com/api/webhooks/652764044994019348/DIHuf_xa7W4zjLsfCJBP4EQoGGFSt4ccMlUMno5jRVDzTnyv9qFR99ETB3q8xmpMyz3i";
    public static final String WEBHOOK_HEADERS_KEY = "Content-Type";
    public static final String WEBHOOK_HEADERS_VALUE = "application/json";


    public void sendNotification(User user, List<GamePage> games) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

        games.stream().filter(gamePage -> !gamePage.getAlreadyOwned()).forEach(gamePage -> {
            log.info("Titre du jeu : {}", gamePage.getTitle());
            try {
                StringEntity content = new StringEntity("{\"content\":\"" + user.getDiscordId() + " i have grab **" + gamePage.getTitle() + "** game for you :gift:\"}");

                HttpPost request = new HttpPost(WEBHOOK_URL);
                request.addHeader(WEBHOOK_HEADERS_KEY, WEBHOOK_HEADERS_VALUE);
                request.setEntity(content);
                httpClient.execute(request);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}