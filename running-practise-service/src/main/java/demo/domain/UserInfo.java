package demo.domain;

/**
 * Created by vagrant on 6/4/17.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Data
public class UserInfo {

    private String username;
    private String address;

    public UserInfo(){
        this.username = "";
    }

    public UserInfo(String runnerId, String username, String address) {
        this.username = username;
        this.address = address;
    }
}
