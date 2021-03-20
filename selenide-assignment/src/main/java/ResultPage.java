import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultPage extends BasePage{


    public void resultPageNotFound() {

        String texts ="Aradığın içeriğe şu an ulaşılamıyor.\n" +
                "Hemen ayrılma, aşağıdakilere göz atmak ister misin?";

        String actualText = $(".smalltypography").getText();
        System.out.println(actualText);
        assert actualText.equals(texts);
        assert true;
    }
    public void noResult(){

        String text="ghjkhkjhkj\" aramanız için sonuç bulunamadı.";

        String actualTextt= $(".no-rslt-text").getText();
        System.out.println(actualTextt);
        assert actualTextt.contains(text);
        assert true;

    }

    public String falseResult(){

        //String expectedText="/////////\" aramanız için sonuç bulunamadı.";

         return $(".no-rslt-text").getText();

    }


}
