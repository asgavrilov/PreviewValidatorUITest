package ru.yandex.video.runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/java/ru/yandex/video/features/",
        glue = "ru/yandex/video/steps/",
        tags = "@smoketest"


)


public class PreviewTest {


    @BeforeClass
    static public void setup() {


        Configuration.timeout = 7000;
        Configuration.browser = "chrome";

        Configuration.startMaximized = true;
        Configuration.reportsFolder = "test-result/screenshots";


    }

    @After
    public void tearDown() {

    }

}

