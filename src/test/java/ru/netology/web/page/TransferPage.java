package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement titleText = $(byText("Пополнение карты"));
    private SelenideElement sum = $("[data-test-id=amount] [class='input__control']");
    private SelenideElement fromWhichCard = $("[data-test-id=from] [class='input__control']");
    private SelenideElement replenishButton = $("[data-test-id=action-transfer]");
    private SelenideElement cancelButton = $("[data-test-id='action-cancel'] [class='button__content']");

    // Перевод с карты на карту;
    public void transferFromCardToCard(int amount, DataHelper.CardInfo from) {
        sum.setValue(String.valueOf(amount));
        fromWhichCard.setValue(String.valueOf(from));
        replenishButton.click();
        new DashboardPage();
    }
    // Перевод суммы превышающий лимит на карте;
    public void getErrorLimit() {
        $(byText("Сумма превышает допустимый лимит!"));
    }
}