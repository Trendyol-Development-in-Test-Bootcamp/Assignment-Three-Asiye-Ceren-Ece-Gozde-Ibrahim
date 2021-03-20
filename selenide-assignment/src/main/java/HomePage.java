import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends BasePage{

    SelenideElement searchBox=$(".search-box-container");
    String clickPopUp = ".fancybox-close";
    String searchArea = ".search-box";
    //String searchButton = ".search-icon";
    String baseUrl = "https://www.trendyol.com/";
    //String hoverElementSearchBox = ".suggestion>span";
    String hoverElementSearchBox = "//*[@class='suggestion']/span[1]";

    public void goToPage(){

        open(baseUrl);
    }

    public void closePopUp(){
        SelenideElement popUpButton = findByCss(clickPopUp);
        popUpButton.click();
    }
    public void findSearchBox(String word){
        SelenideElement searchElement = findByCss(searchArea);
        searchElement.setValue(word).pressEnter();

    }
    public void hoverSearchBox(String word){
        SelenideElement searchElement = findByCss(searchArea);
        searchElement.setValue(word).hover();

    }
    public String hoverSearchBox(){
        SelenideElement searchElement = allByCss(hoverElementSearchBox).first();
        return searchElement.getText();
    }

    public List<SelenideElement> hoverSearchBoxList(){
        //List<SelenideElement> searchElementList = allByCss(hoverElementSearchBox);
       List<SelenideElement> searchElementList = allByXpath(hoverElementSearchBox);
        return searchElementList;
    }
//    public void clickSearchButton(){
//
//        SelenideElement buttonElement =findByCss(searchButton);
//        buttonElement.click();
//    }


}
