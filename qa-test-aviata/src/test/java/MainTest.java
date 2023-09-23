import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class MainTest {
    static Page page = Playwright.create()
            .chromium()
            .launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setDevtools(true)
                    .setSlowMo(1000))
            .newContext()
            .newPage();
    @BeforeEach
    public void test() throws InterruptedException {
        page.navigate("https://aviata.kz");
        Thread.sleep(5000);
    }

//    @BeforeEach
    public void beforeTest() {

    }
    @Test
    public void anywhere() {
        int n = 3;
        page.click("//button[contains(text(),'Куда угодно')]");
        page.click("//span[contains(text(),'Любой месяц')]");
        page.click("//*[@id='search-route-0']/div[4]/div[1]/div[3]/div[2]/button[" + n + "]/div");
        page.click("//span[text()='Обратно']");
        page.click("//button[text()=' Найти ']");

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screens/" + LocalDate.now() + ".png")).setFullPage(true));
    }
}