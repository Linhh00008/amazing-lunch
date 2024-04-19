package vn.com.vhc.amazinglunch.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItem_id;

    @ManyToOne
    @JoinColumn
    private Order order;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private int quantity;

}
