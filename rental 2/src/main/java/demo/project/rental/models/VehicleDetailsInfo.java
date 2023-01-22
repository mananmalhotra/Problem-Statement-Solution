package demo.project.rental.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
@Builder
@Accessors(fluent = true, chain = true)
public class VehicleDetailsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "vehicle_uuid", nullable = false, unique = true)
    private String vehicleUUID;

    @Column(name = "vehicle_number", nullable = false)
    private String vehicleNumber;

    @Column(name = "availability", nullable = false)
    private String availability;

    @Column(name = "at_station", nullable = false)
    private String atStation;

    @Column(name = "qr_code", nullable = false)
    private String qrCode;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
