package kawahedukasi.model;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.IdentityAttribute;

import javax.persistence.*;

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

    @Column (name= "count")
    public String count;

    @Column (name= "price")
    public String price;

    @Column (name= "type")
    public String type;

    @Column (name= "description")
    public String description;

    @Column (name= "createdAt")
    public String createdAt;

    @Column (name= "updatedAt")
    public String updatedAt;

    public Item() {
    }
}
