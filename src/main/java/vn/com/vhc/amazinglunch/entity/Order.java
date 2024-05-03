package vn.com.vhc.amazinglunch.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food_id;

    @ManyToOne
    @JoinColumn(name = "tableOrder_id")
    private TableOrder tableOrder_id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime update_at;
}
