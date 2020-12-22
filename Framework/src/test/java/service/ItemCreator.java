package service;

import model.CreditCard;
import model.Item;

public class ItemCreator {
    public static final String TESTDATA_ITEM_URL = "testdata.item.url";
    public static final String TESTDATA_ITEM_WIDTH = "testdata.item.width";
    public static final String TESTDATA_ITEM_SIZE = "testdata.item.size";

    public static Item withCredentialsFromProperty(){
        return new Item(TestDataReader.getTestData(TESTDATA_ITEM_URL),
                TestDataReader.getTestData(TESTDATA_ITEM_WIDTH),
                TestDataReader.getTestData(TESTDATA_ITEM_SIZE));
    }
}
