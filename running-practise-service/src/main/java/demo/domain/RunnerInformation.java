package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by vagrant on 6/4/17.
 */
public class RunnerInformation {
    enum HeartLevelStatue{
        HIGH, LOW, NORMAL;
    }

    @Id
    @GeneratedValue
    private Long runningId;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private double heartRate;
    private Date timestamp = new Date();

    @Embedded
    @AttributeOverride(name = "username", column = @Column(name = "user_name"))
    private UserInfo userInfo;

    public RunnerInformation(){
        Random rand = new Random();
        this.heartRate = rand.nextInt(200)+60;
    }


    public RunnerInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @JsonCreator
    private RunnerInformation(@JsonProperty("runningId") String runningId){
        this.userInfo = new UserInfo(runningId);
    }

    public String getRunningId(){
        return this.userInfo == null ? null :this.userInfo.getRunningId();
    }

}
