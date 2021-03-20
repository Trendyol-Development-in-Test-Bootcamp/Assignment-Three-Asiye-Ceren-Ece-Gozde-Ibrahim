import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import extensions.RetryAnalyzer;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Listeners({ ScreenShooter.class })
public class UITests {

    HomePage homePage = new HomePage();
    ResultPage resultPage = new ResultPage();

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void resultNotFound() throws InterruptedException {


        homePage.goToPage();
        Thread.sleep(1000);
        homePage.closePopUp();
        homePage.findSearchBox("ghjkhkjhkj");
        Thread.sleep(3000);
        resultPage.noResult();
        //homePage.clickSearchButton();
        //$(".no-rslt-text").shouldHave(Condition.text("\"ghjkhkjhkj\" aramanız için sonuç bulunamadı."));
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void searchAndFindResults() throws InterruptedException {


        homePage.goToPage();
        homePage.closePopUp();
        homePage.findSearchBox("&&&&&&&&&&");
        Thread.sleep(3000);
        //homePage.clickSearchButton();
        resultPage.resultPageNotFound();


        //$(".smalltypography").shouldHave(Condition.text("Aradığın içeriğe şu an ulaşılamıyor.\n" + "Hemen ayrılma, aşağıdakilere göz atmak ister misin?"));

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void searchEmpty() throws InterruptedException {

        String text = "/////";

        homePage.goToPage();
        homePage.closePopUp();

        homePage.findSearchBox(text);
        //homePage.clickSearchButton();
        resultPage.falseResult();

        Thread.sleep(3000);
        assert (resultPage.falseResult().equals('"' + text + '"' + " aramanız için sonuç bulunamadı."));


    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkHoverElement() throws InterruptedException {


        homePage.goToPage();
        homePage.closePopUp();

        homePage.hoverSearchBox("ara");
        Thread.sleep(5000);
        System.out.println(homePage.hoverSearchBox());
        assert (homePage.hoverSearchBox().contains("Ara"));

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkHoverList() throws InterruptedException {
        boolean contains = true;
        String notContainRelatedResultText = "";  // ilgili sonuçlarda aranan kelimeyi içermeyen sonuç
        String searchedText = "Elbi"; //Success test
        //String searchedText = "Ara"; //Failed test
        homePage.goToPage();
        homePage.closePopUp();
        homePage.hoverSearchBox(searchedText);
        Thread.sleep(1000);
        System.out.println("İlgili sonuc sayisi: " + homePage.hoverSearchBoxList().size());
        for (SelenideElement s : homePage.hoverSearchBoxList()) {
            if (!(s.getText().contains(searchedText))) {
                contains = false;
                notContainRelatedResultText = s.getText();
                break;
            }
        }
        assertTrue(contains, '"' + notContainRelatedResultText + '"' + " ürünü aranan " +'"'+ searchedText+ '"' + " kelimesini içermiyor.");
    }

}