package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement dashBoard = $("[data-test-id='dashboard']");

    public DashboardPage() {
        dashBoard.shouldBe(Condition.visible);
    }
}
