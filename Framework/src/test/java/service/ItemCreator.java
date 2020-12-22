package service;

import model.CreditCard;
import model.Item;

public class ItemCreator {
    public static final String TESTDATA_ITEM_URL = "testdata.item.%s.url";
    public static final String TESTDATA_ITEM_WIDTH = "testdata.item.%s.width";
    public static final String TESTDATA_ITEM_SIZE = "testdata.item.%s.size";

    public static Item withCredentialsFromProperty(String itemNumber){
        String itemUrl = String.format(TESTDATA_ITEM_URL, itemNumber);
        String itemWidth = String.format(TESTDATA_ITEM_WIDTH, itemNumber);
        String itemSize = String.format(TESTDATA_ITEM_SIZE, itemNumber);
        return new Item(TestDataReader.getTestData(itemUrl),
                TestDataReader.getTestData(itemWidth),
                TestDataReader.getTestData(itemSize));
    }
}
