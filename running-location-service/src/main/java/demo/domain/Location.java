package demo.domain;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vagrant on 5/30/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity // Java JPA entity class, this class would be mapped into database
@Table(name = "Location")

public class Location {
        enum GpsStatus{
            EXCELLENT, OK, UNRELIABLE, BAD, NOFIX, UNKNOWN
        }

        public enum RunnerMovementType{
            STOPPED, IN_MOTION;

            public boolean isMoving() {
                return this != STOPPED;
            }
        }
        @Id
        @GeneratedValue
        private Long id;

        private double latitude; //map to latitude column in table of database
        private double longitude;
        private String heading;
        private GpsStatus gpsSpeed;
        private double odometer;
        private double totalRunningTime;
        private double totalIdleTime;
        private double totalCalorieBurnt;
        private String address;
        private Date timetamp = new Date();
        private String gearProvider;
        private RunnerMovementType runnerMovementType = RunnerMovementType.STOPPED;
        private String servicedType;

        @Embedded
        @AttributeOverride(name = "bandMake", column = @Column(name = "unit_band_make"))
        private UnitInfo unitInfo;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "fmi", column = @Column(name = "medical_fmi")),
                @AttributeOverride(name = "bfr", column = @Column(name = "medical_bfr"))
        })
        private MedicalInfo medicalInfo;

        public Location(){
                this.unitInfo = null;
        }

        public Location(UnitInfo unitInfo) {
            this.unitInfo = unitInfo;
        }

        @JsonCreator
        private Location(@JsonProperty("runningId") String runningId){
            this.unitInfo = new UnitInfo(runningId);
        }

        public String getRunningId(){
            return this.unitInfo == null ? null :this.unitInfo.getRunningId();
        }
}
