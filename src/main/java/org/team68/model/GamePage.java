package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class GamePage implements Page {
    public static final String CONFIRM_PURCHASE_BUTTON = "//div[@class='confirm-container row']/div/button";
    public static final String ACCEPT_REFUND_BUTTON = "//div[@class='overlay-btn-row']/button[2]";
    public static final String NAME_FREE_GAME = "//title";
    private static final String OBTAIN_SPAN = "//span[text()='Obtenir']";
    private static final String OWNED_SPAN = "//span[text()='Possédé']";
    private static Logger log = LoggerFactory.getLogger(GamePage.class);
    private String url;

    public GamePage(String url) {
        this.url = url;
    }

    public GamePage() {

    }

    public boolean isAlreadyOwned() {
        return $x(OWNED_SPAN).parent().exists();
    }

    @Override
    public GamePage open() {
        Selenide.open(url);
        return this;
    }

    public GamePage getFreeGameName() {
        String gametitle = $x(NAME_FREE_GAME).toString();
        log.info(gametitle);
        return this;
    }

    public GamePage purchase() throws InterruptedException {
        $x(OBTAIN_SPAN).parent().click();
        Thread.sleep(5000);
        return this;
    }

    public GamePage confirmPurchase() throws InterruptedException {
        $x(CONFIRM_PURCHASE_BUTTON).click();
        Thread.sleep(5000);
        return this;
    }

    public GamePage acceptRefund() {
        $x(ACCEPT_REFUND_BUTTON).click();
        return this;
    }
}
