package demo.project.rental.pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

    @JsonProperty("user_uuid")
    private String userUUID;

    @JsonProperty("vehicle_uuid")
    private String vehicleUUID;

    @JsonProperty("station_uuid")
    private String stationUUID;

    @JsonProperty("message")
    private String message;
}
