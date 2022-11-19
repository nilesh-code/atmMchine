package utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.UserDetails;
public class AccountUtils {

    private static final Map<Long,UserDetails> accountDetailsMap;

    static {
        Map<Long,UserDetails> data=loadUserDetails();
        accountDetailsMap=Collections.unmodifiableMap(data);
    }

        public static UserDetails getUserDetailsData(Long key) {
           return accountDetailsMap.get(key);
        }

        public static Map<Long,UserDetails> loadUserDetails(){
            Map<Long,UserDetails> userDataMap =new HashMap<>();
            userDataMap.put(1111222233334444L,new UserDetails("Nilesh Pattewar",123,"12/23",1222,2340.0));
            userDataMap.put(5555222233334444L,new UserDetails("John Cena",523,"12/29",4444,8900.0));
            userDataMap.put(6666222233334444L,new UserDetails("Roman",323,"12/27",5555,5000.0));
            return userDataMap;
        }

    public static long countDigit(long no) {
        int count = 0;

        while (no != 0) {
            no = no / 10;
            count++;
        }
        return count;
    }

    public static String  checkValidExpiryDate(String expiry) {
        if(expiry.matches("^(1[012])\\/[0-9]{2}")){
            return expiry;
        }
        return "";
    }


}
