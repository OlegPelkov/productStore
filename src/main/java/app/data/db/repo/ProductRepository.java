package app.data.db.repo;

import app.data.db.entity.ProductEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface ProductRepository {

    ProductEntity findById(ObjectId id) throws Exception;

    List<ProductEntity> findByNameContaining(String nameStartsWith) throws Exception;

    ProductEntity save(ProductEntity productEntity) throws Exception;

    List<ProductEntity> findProductsByParams(Map<String, String> params) throws Exception;

}
