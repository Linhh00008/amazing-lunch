package vn.com.vhc.amazinglunch.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "table_order_id")
    private TableOrder tableOrder;

}
