package pages.table;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {

    public TablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> allPeaks;


    public List<RowPage> getAllPeaks() {
        List<RowPage> allPeaks = new ArrayList<>();
        for (WebElement peak : this.allPeaks) {
            allPeaks.add(new RowPage(peak));
        }
        return allPeaks;
    }
}