package demo.project.rental.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailsRequest implements Serializable {

    private static final long serialVersionUUID = 1L;

    @JsonProperty("user_uuid")
    private String userUUID;

    @JsonProperty("name")
    @NotBlank(message = "Name can not be null")
    private String name;

    @JsonProperty("email")
    @NotBlank(message = "Email can not be null")
    private String email;

    @JsonProperty("phone")
    @NotBlank(message = "Phone can not be null")
    private String phone;

    @JsonProperty("role")
    private String role;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
