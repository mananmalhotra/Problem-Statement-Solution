package demo.project.rental.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookReturnRequest implements Serializable {

    private static final long serialVersionUUID = 1L;

    @JsonProperty("at_station")
    @NotBlank(message = "At station can not be null")
    private String atStation;

    @JsonProperty("qr_code")
    @NotBlank(message = "QR Code can not be blank")
    private String qrCode;
}
