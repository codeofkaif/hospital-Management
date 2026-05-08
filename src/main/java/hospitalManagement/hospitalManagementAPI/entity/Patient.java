package hospitalManagement.hospitalManagementAPI.entity;

import hospitalManagement.hospitalManagementAPI.entity.Type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthday", columnNames = {"name", "birthday"})
        },
        indexes = {
                @Index(name = "idx_patient_birthday", columnList = "birthday")

        }

)

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , length = 40)
    private String name;
    @Column(nullable = false , unique = true)
    private String email;
    @ToString.Exclude
    private LocalDate birthday;

    private String gender;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
    private BloodGroupType bloodGroup;


}
