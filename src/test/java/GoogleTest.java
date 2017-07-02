import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Feature("Google")
@Story("Search")
public class GoogleTest {

    @BeforeClass
    public static void setUp(){
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = "chrome";
    }

    @Test
    @Step
    public void testGoogleSearch(){
        open("https://www.google.com.ua/");
        $(By.xpath(".//*[@id='hplogo']")).shouldHave(Condition.attribute("title"));
        $(By.xpath(".//*[@id='gs_htif0']")).setValue("movies");
        $$(By.xpath(".//*[@id='hdtb-msb-vis']/div/a")).shouldHaveSize(8);
    }
}
