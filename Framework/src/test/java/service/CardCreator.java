package service;

import model.CreditCard;
import model.User;

public class CardCreator {
    public static final String TESTDATA_CARD_NAME = "testdata.card.name";
    public static final String TESTDATA_CARD_NUMBER = "testdata.card.number";
    public static final String TESTDATA_CARD_EXPIRATION_MONTH = "testdata.card.expirationMonth";
    public static final String TESTDATA_CARD_EXPIRATION_YEAR = "testdata.card.expirationYear";

    public static CreditCard withCredentialsFromProperty(){
        return new CreditCard(TestDataReader.getTestData(TESTDATA_CARD_NAME),
                TestDataReader.getTestData(TESTDATA_CARD_NUMBER),
                TestDataReader.getTestData(TESTDATA_CARD_EXPIRATION_MONTH),
                TestDataReader.getTestData(TESTDATA_CARD_EXPIRATION_YEAR));
    }
}
