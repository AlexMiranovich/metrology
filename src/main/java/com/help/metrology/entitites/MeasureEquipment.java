package com.help.metrology.entitites;

import com.help.metrology.entitites.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MeasureEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private EquipmentType type;
    private Double price;
    private Double precision;
    private Boolean isCalibrated;

    @CreationTimestamp
    private Instant createdDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Vendor vendor;
}
