package kawahedukasi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
public class Item extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name= "itemSequence", sequenceName = "item_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "itemSequence", strategy = GenerationType.SEQUENCE)
    @Column (name = "id",nullable = false)
    public Long id;

    @Column (name= "name")
    public String name;

    @Column (name = "email")
    public String email;

    @Column (name= "count")
    public int count;

    @Column (name= "price")
    public int price;

    @Column (name= "type")
    public String type;

    @Column (name= "description")
    public String description;

    @CreationTimestamp
    @Column (name= "createdAt")
    public LocalDateTime createdAt;

    @UpdateTimestamp
    @Column (name= "updatedAt")
    public LocalDateTime updatedAt;

    public Item() {
    }
}
