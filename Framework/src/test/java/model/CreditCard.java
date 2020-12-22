package model;

import java.util.Objects;

public class CreditCard {
    private String nameOnCard;
    private String cardNumber;
    private String expirationDateMonth;
    private String expirationDateYear;

    public String getCardNumber() { return cardNumber; }

    public String getExpirationDateMonth() { return expirationDateMonth; }

    public String getExpirationDateYear() { return expirationDateYear; }

    public String getNameOnCard() { return nameOnCard; }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public void setExpirationDateMonth(String expirationDateMonth) { this.expirationDateMonth = expirationDateMonth; }

    public void setExpirationDateYear(String expirationDateYear) { this.expirationDateYear = expirationDateYear; }

    public void setNameOnCard(String nameOnCard) { this.nameOnCard = nameOnCard; }

    public CreditCard(String nameOnCard, String cardNumber, String expirationDateMonth, String expirationDateYear) {
        this.cardNumber = cardNumber;
        this.expirationDateYear = expirationDateYear;
        this.nameOnCard = nameOnCard;
        this.expirationDateMonth = expirationDateMonth;
    }

    @Override
    public String toString() {
        return "Default Payment Method" + "\n" +
                nameOnCard + "\n" +
                "Visa" + "\n" +
                "************" + cardNumber.substring(12) + "\n" +
                "Expiration " + expirationDateMonth + "/" + expirationDateYear.substring(2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard card = (CreditCard) o;
        return Objects.equals(getCardNumber(), card.getCardNumber()) &&
                Objects.equals(getNameOnCard(), card.getNameOnCard()) &&
                Objects.equals(getExpirationDateMonth(), card.getExpirationDateMonth()) &&
                Objects.equals(getExpirationDateYear(), card.getExpirationDateYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardNumber(), getNameOnCard(), getExpirationDateMonth(), getExpirationDateYear());
    }
}
