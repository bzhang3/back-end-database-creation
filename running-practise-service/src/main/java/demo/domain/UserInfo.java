package demo.domain;

/**
 * Created by vagrant on 6/4/17.
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Embeddable;

public class UserInfo {


    private String runnerId;
    private String userName;
    private String address;

    public userInfo(){
        this.runnerId = "";
    }

    public userInfo(String runnerId) {
        this.runnerId = runnerId;
    }

    public userInfo(String runnerId, String userName, String address) {
        this.runnerId = runnerId;
        this.userName = userName;
        this.address = address;
    }
}
