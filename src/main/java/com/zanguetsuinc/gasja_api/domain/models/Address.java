package com.zanguetsuinc.gasja_api.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.geo.Point;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String province;
    private String municipality;
    private String neighborhood;

    @Column(columnDefinition = "geography(Point, 4326)")
    private Point localization;

    @OneToOne(fetch = FetchType.LAZY)
    private Retailer retailer;

    @CreationTimestamp
    @Column(name = "create_at", updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
