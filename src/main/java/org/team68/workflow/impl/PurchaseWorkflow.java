package org.team68.workflow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.team68.workflow.Workflow;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PurchaseWorkflow implements Workflow {
    private Logger log = LoggerFactory.getLogger(PurchaseWorkflow.class);

    @Override
    public boolean execute() {
        log.info(storeEpicGames());

        log.info(clickCookieAccept());

        log.info(clickPurchase());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            log.error("Unexpected error", exception);
            return false;
        }

        log.info(confirmPurchase());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            log.error("Unexpected error", exception);
            return false;
        }

        log.info(acceptRefund());

        return true;
    }

    private String storeEpicGames() {
        open("https://www.epicgames.com/store/fr"); //Allez dans le store epicgames
        //TODO : manage the fact where there are more than one epic gems offered this week
        String urlfreegame = $x("//span[text()='Gratuit maintenant']").parent().parent().parent().getAttribute("href");
        open(urlfreegame);
        return "Store EpicGames OK";
    }

    private String clickCookieAccept() {
        $x("//button[@id='euCookieAccept']").click();
        return "clickCookieAccept OK";
    }

    private String clickPurchase() {
        $x("//span[text()='Obtenir']").parent().click();
        return "clicPurchase OK";
    }

    private String confirmPurchase() {
        $x("//div[@class='confirm-container row']/div/button").click();
        return "confirmPurchase OK";
    }

    private String acceptRefund() {
        $x("//div[@class='overlay-btn-row']/button[2]").click();
        return "acceptRefund OK";
    }
}
