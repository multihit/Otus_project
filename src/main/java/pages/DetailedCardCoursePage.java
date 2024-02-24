package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailedCardCoursePage extends AbsBasePage {

    public DetailedCardCoursePage(WebDriver driver, String coursesPath) {
        super(driver, String.format("/lessons/%s", coursesPath));
    }

    @FindBy(xpath = "//h1[contains(text(), '')]")
    private WebElement titleCardCourse;

    @FindBy(xpath = "//div/following-sibling::p[contains(text(), 'месяц')]")
    private WebElement durationCourse;

    @FindBy(xpath = "//h1/following-sibling::div[contains(text(), '')]/p")
    private WebElement descriptionCardCourseLocator;


    public void checkTitleCourse(String expectedTitleCourse) {
        String result = titleCardCourse.getText();
        Assertions.assertEquals(expectedTitleCourse, result);
    }


    private DetailedCardCoursePage checkDescriptionCourseIsNotEmpty() {
        String descriptionCardCourse = descriptionCardCourseLocator.getText();
        Assertions.assertFalse(descriptionCardCourse.isEmpty());
        return this;
    }

    private DetailedCardCoursePage checkDurationCourseIsNotEmpty() {
        Assertions.assertFalse(durationCourse.getText().isEmpty());
        return this;
    }

    private DetailedCardCoursePage checkFormatCourse(String format) {
        String formatCourse = driver.findElement(By.xpath(String.format("//p[contains(text(), '%s')]", format))).getText();
        Assertions.assertEquals(formatCourse.isEmpty(), "Description courses empty");
        return this;
    }

    public DetailedCardCoursePage checkDetailsCardCourse(String format) {
        this.checkDescriptionCourseIsNotEmpty()
                .checkDurationCourseIsNotEmpty()
                .checkFormatCourse(format);

        return this;
    }

}
