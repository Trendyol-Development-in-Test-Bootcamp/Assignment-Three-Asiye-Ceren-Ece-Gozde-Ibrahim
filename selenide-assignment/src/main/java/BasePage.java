import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage {
    BasePage(){

        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
        //Configuration.headless = true;
        Configuration.timeout=4000;

    }


    SelenideElement findByXpath(String xpath){ return $(By.xpath(xpath)); }

    SelenideElement findByCss(String css){ return $(By.cssSelector(css)); }

    ElementsCollection allByCss(String css){
        return $$(By.cssSelector(css));}

        ElementsCollection allByXpath(String xpath){
            return $$(By.xpath(xpath));}
}
