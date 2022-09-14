import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.table.RowPage;
import pages.table.TablePage;

public class TableTest extends BaseTest {

    @Test
    @DisplayName("4.0 Table")
    @Tag("basic")
    @Tag("pages/table")
    @Tag("pop")
    void shouldPrintPeaksOver4000HighInSwitzerland() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
        TablePage tablePage = new TablePage(driver);

        for (RowPage peakData : tablePage.getAllPeaks()) {
            if (peakData.getHeight() > 4000 && peakData.getState().contains("Switzerland")) {
                System.out.println("Rank: " + peakData.getRank() + ", " + "Peak: " + peakData.getPeak() + ", " +
                        "Mountain range: " + peakData.getMountainRange() + "\n");
            }

        }
    }
}