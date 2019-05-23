package ru.yandex.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class VideoResultsPage {


    private static final By SERP_ITEM = By.cssSelector("div.thumb-image__shadow");
//    private static final By SERP_ITEM = By.cssSelector("div.serp-list div.serp-item_type_search");

    public void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Selenide.sleep(5000);
    }

    public List<WebElement> results(WebDriver driver) {
        //$("div.more button.button2").waitUntil(Condition.enabled, 10000);

        return driver.findElements(SERP_ITEM);
    }


    public void mouseElementOver(WebDriver driver, List<WebElement> dataBems) throws InterruptedException {


        for (int i = 0; i < dataBems.size(); i++) {

            try {


                Screenshot screenshotBefore = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, dataBems.get(i));
                ImageIO.write(screenshotBefore.getImage(), "png", new File("test-result/screenshots/before" + i + ".png"));

                Selenide.actions().moveToElement(dataBems.get(i)).build().perform();
                Selenide.sleep(2000);

                Screenshot screenshotAfter = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, dataBems.get(i));
                ImageIO.write(screenshotAfter.getImage(), "png", new File("test-result/screenshots/after" + i + ".png"));


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }


    public String isPreviewForItemExist(String screenshotBeforePath, String screenshotAfterPath) {

        BufferedImage screen = null;
        BufferedImage screen2 = null;

        try {
            screen = ImageIO.read(new File(screenshotBeforePath));
        } catch (IOException e) {
        }

        int w = screen.getWidth();
        int h = screen.getHeight();

        int[][] screenArray = new int[w][h];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                screenArray[i][j] = screen.getRGB(i, j);
            }
        }

        try {
            screen2 = ImageIO.read(new File(screenshotAfterPath));
        } catch (IOException e) {
        }

        int w2 = screen2.getWidth();
        int h2 = screen2.getHeight();

        int[][] screenArray2 = new int[w2][h2];

        for (int i = 0; i < w2; i++) {
            for (int j = 0; j < h2; j++) {
                screenArray2[i][j] = screen2.getRGB(i, j);
            }
        }


        if (Arrays.deepEquals(screenArray, screenArray2)) {
            System.out.println("Item has no preview");
            return "1";
        } else {
            System.out.println("Item has a preview");
            return "0";
        }

    }
}
