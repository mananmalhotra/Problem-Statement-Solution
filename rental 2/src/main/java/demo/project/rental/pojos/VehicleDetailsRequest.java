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
public class VehicleDetailsRequest implements Serializable {

    private static final long serialVersionUUID = 1L;

    @JsonProperty("vehicle_uuid")
    private String vehicleUUID;

    @JsonProperty("vehicle_number")
    @NotBlank(message = "Vehicle number can not be null")
    private String vehicleNumber;

    @JsonProperty("availability")
    @NotBlank(message = "Availability can not be null")
    private String availability;

    @JsonProperty("at_station")
    @NotBlank(message = "At station can not be null")
    private String atStation;

    @JsonProperty("qr_code")
    @NotBlank(message = "QR Code can not be blank")
    private String qrCode;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
