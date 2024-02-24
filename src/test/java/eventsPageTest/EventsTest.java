package eventsPageTest;

import coursesPageTest.CoursesTest;
import data.sorted.EventTypeData;
import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CalendarEventsPage;

public class EventsTest {

    private Logger logger = (Logger) LogManager.getLogger(CoursesTest.class);

    private WebDriver driver;
    private CalendarEventsPage calendarEventsPage;

    @BeforeEach
    public void init() {
        this.driver = new DriverFactory().create();
        logger.info("Start driver");

        this.calendarEventsPage = new CalendarEventsPage(driver);
        calendarEventsPage.open("/events/near/");
    }

    @AfterEach
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Stop driver");
    }

    @Test
    public void validationDateEvents() {
        calendarEventsPage
                .checkVisibilityCardsEvent()
                .checkStartDateEvent();
    }

    @Test
    public void selectEventsOfType() {
        calendarEventsPage
                .selectSortedEventsType(EventTypeData.OPEN)
                .checkEventsType(EventTypeData.OPEN);
    }
}
