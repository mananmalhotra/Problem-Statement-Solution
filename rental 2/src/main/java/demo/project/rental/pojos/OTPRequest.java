package demo.project.rental.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OTPRequest implements Serializable {

    private static final long serialVersionUUID = 1L;

    @JsonProperty("otp_uuid")
    private String otpUUID;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("otp")
    private String otp;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
