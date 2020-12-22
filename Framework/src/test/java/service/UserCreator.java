package service;

import model.*;
import org.testng.annotations.Test;

public class UserCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TETSDATA_USER_FIRSTNAME = "testdata.user.firstName";
    public static final String TESTDATA_USER_LASTNAME = "testdata.user.lastName";
    public static final String TESTDATA_USER_ZIPCODE = "testdata.user.zipCode";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TETSDATA_USER_FIRSTNAME),
                TestDataReader.getTestData(TESTDATA_USER_LASTNAME),
                TestDataReader.getTestData(TESTDATA_USER_ZIPCODE));
    }
}
