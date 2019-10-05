package app.data.db.repo;

import app.data.db.entity.ProductId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductIdRepository extends MongoRepository<ProductId, Long> {
    ProductId findTopByOrderByIdDesc();
}