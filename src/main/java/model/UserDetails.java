package model;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import utils.AccountUtils;

import static utils.AccountUtils.checkValidExpiryDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {


    private String userName;
    private int cvv;
    private String expiry;
    private int pin;
    private double balance;

    public boolean getValidCardDetails(long atmNo, int cvv, String expiry) {
        return (16 == AccountUtils.countDigit(atmNo) && cvv == this.cvv && StringUtils.equals(checkValidExpiryDate(expiry), this.expiry));
    }

}
