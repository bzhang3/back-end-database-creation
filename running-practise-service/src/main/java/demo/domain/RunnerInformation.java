package demo.domain;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;

import javax.persistence.Embedded;
import java.util.Date;

/**
 * Created by vagrant on 6/4/17.
 */
public class RunnerInformation {

    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private double heartRate;
    private Date timestamp = new Date();

    @Embedded
    private UserInfo userInfo;

    public RunnerInformation(){
        this.heartRate = 0;
    }

    public RunnerInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}
