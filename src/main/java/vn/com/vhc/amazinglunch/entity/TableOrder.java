package vn.com.vhc.amazinglunch.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tableOrder")
public class TableOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tableOrder_id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant_id;

    private String name;

    private Integer maxPerson;

    private Integer numberCurrentPerson;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime update_at;
}
