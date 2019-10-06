package app.data.db.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "products")
@Document(collection = "products")
public class ProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;

    @Column(name = "name", nullable = false, length = 30)
    @NotNull(message = "Name may not be null")
    @NotEmpty(message = "Name may not be empty")
    private String name;

    @Column(name = "description", nullable = false)
    @NotNull(message = "Name may not be null")
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "properties", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String, String> properties = new HashMap<>();

    public ProductEntity(Map<String, String> properties) {
        this.properties = properties;
    }

    public ProductEntity() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
