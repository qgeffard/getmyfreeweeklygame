package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class GamePage implements Page {
    private static Logger log = LoggerFactory.getLogger(GamePage.class);

    public static final String INNER_TEXT = "innerText";
    public static final String CONFIRM_PURCHASE_BUTTON = "//div[@class='confirm-container row']/div/button";
    public static final String ACCEPT_REFUND_BUTTON = "//div[@class='overlay-btn-row']/button[2]";
    public static final String TITLE = "//title";
    public static final String OBTAIN_SPAN = "//span[text()='Obtenir']";
    public static final String OWNED_SPAN = "//span[text()='Possédé']";

    private String url;
    private String title;

    public GamePage(String url) {
        this.url = url;
    }

    public boolean isAlreadyOwned() {
        return $x(OWNED_SPAN).parent().exists();
    }

    @Override
    public GamePage open() {
        Selenide.open(url);
        this.title = $x(TITLE).getAttribute(INNER_TEXT);
        return this;
    }

    public String getTitle() {
        return title;
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
