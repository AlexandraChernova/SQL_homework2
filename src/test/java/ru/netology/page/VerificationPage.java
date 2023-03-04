package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.mysql.cj.x.protobuf.MysqlxExpect;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class VerificationPage {
    @FindBy(css = "[data-test-id=code] input.input__control")
    private SelenideElement codeField;
    @FindBy(css = "[data-test-id=action-verify]")
    private SelenideElement verifyButton;
    @FindBy(css = "[data-test-id=error-notification]")
    private SelenideElement errorNotification;

    public void verifyVerificationPageVisibility() { codeField.shouldBe(Condition.visible); }

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(Condition.visible);
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashboardPage();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }

}
