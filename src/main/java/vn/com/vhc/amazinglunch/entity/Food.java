package vn.com.vhc.amazinglunch.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer food_id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant_id;

    @ManyToOne
    @JoinColumn(name = "foodroup_id")
    private FoodGroup foodgroup_id;

    private String name;

    private String description;

    private String price;
}
