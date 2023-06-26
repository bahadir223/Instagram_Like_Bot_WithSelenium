package Instagram;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class C01_Instagram_Like_Bot extends TestBase {

    @Test
    public void bolLike() {
        // kullanici girisi yaptik
        driver.get(" https://instagram.com ");
        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys("kendinize ait bir hesap giriniz", Keys.TAB, "Şifreniz", Keys.TAB, Keys.TAB, Keys.ENTER);

        // giris bilgilerin kaydedilsin mi sorusuna simdi degili tikla
        driver.findElement(By.cssSelector("[class='_ac8f']")).click();
        bekle(2);
        //sonraki şimdi değil i tıkla
        driver.findElement(By.cssSelector("[class='_a9-- _a9_1']")).click();
        bekle(2);

        //1- logo gorunene kadar beklet
        WebElement logo = driver.findElement(By.cssSelector("[aria-label='Instagram']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(logo));

        //2 - ana sayfada instagram logosunun gorunurlugunu test et
        Assert.assertTrue(logo.isDisplayed());

        //arama butonuna tıkla
        WebElement aramaButonu = driver.findElement(By.xpath("(//*[@class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft'])[2]"));

        aramaButonu.click();

        //arama metin kutucuguna aradıgımız kisiye gir
        driver.findElement(By.cssSelector("[aria-label='Arama Girdisi']")).sendKeys("ramozy53");

        bekle(2);
        //hedef kişinin locate'ine tikla.
        driver.findElement(By.xpath("(//div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1uhb9sk x1plvlek xryxfnj x1iyjqo2 x2lwn1j xeuugli xdt5ytf xqjyukv x1cy8zhl x1oa3qoh x1nhvcw1'])[1]")).click();

        //resimleri liste at

        List<WebElement> resimlerimiz = driver.findElements(By.cssSelector("[class='_aagw']"));
        for (int i = 0; i <=resimlerimiz.size() ; i++) {
            resimlerimiz = driver.findElements(By.cssSelector("[class='_aagw']"));
            resimlerimiz.get(i).click();
            bekle(2);
            //kalp e tıkla.
            driver.findElement(By.xpath("(//*[@class='_abl-'])[5]")).click();
            bekle(2);
            //carpidan kapat ve 2. fotoğrafa tıkla
            driver.findElement(By.cssSelector("[class='x160vmok x10l6tqk x1eu8d0j x1vjfegm']")).click();
            bekle(2);
        }

    }
}
