package app.data.web.services;

import app.data.db.entity.ProductEntity;
import app.data.web.dto.ProductDTO;
import app.data.web.dto.RequestDTO;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductEntity createProduct(ProductDTO p) throws Exception;

    List<ProductDTO> findProducts(RequestDTO requestDTO) throws Exception;

    ProductDTO findProductById(ObjectId id) throws Exception;

}
