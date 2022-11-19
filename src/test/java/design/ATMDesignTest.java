package design;

import model.UserDetails;
import org.junit.Assert;
import org.junit.Test;
import utils.AccountUtils;


public class ATMDesignTest {


    @Test
    public void checkValidAtmDetails() {
    UserDetails userDetails= AccountUtils.getUserDetailsData(1111222233334444L);
    Assert.assertTrue(userDetails.getValidCardDetails(1111222233334444L,123,"12/23"));
    }

    @Test
    public void checkValidCardDetails(){
    long validAtmNo=1111222233334444L;
    int validPin=1222;
    String validExpiry="12/23";
    UserDetails userDetails= AccountUtils.getUserDetailsData(validAtmNo);

    Assert.assertEquals(validPin,userDetails.getPin());
    Assert.assertEquals(validExpiry,userDetails.getExpiry());

    }

}


