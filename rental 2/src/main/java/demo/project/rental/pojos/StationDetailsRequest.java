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
public class StationDetailsRequest implements Serializable {

    private static final long serialVersionUUID = 1L;

    @JsonProperty("station_uuid")
    private String stationUUID;

    @JsonProperty("location")
    @NotBlank(message = "Location can not be null")
    private String location;

    @JsonProperty("capacity")
    @NotBlank(message = "Capacity can not be null")
    private String capacity;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
