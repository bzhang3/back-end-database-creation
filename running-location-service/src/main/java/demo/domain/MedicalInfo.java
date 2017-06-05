package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Created by vagrant on 5/30/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Data
public class MedicalInfo {

    private Long bfr;

    private Long fmi;

    public MedicalInfo(){

    }

    public MedicalInfo(Long bfr, Long fmi) {
        this.bfr = bfr;
        this.fmi = fmi;
    }
}
