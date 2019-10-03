package app.data.web.services;

import app.data.db.entity.ProductEntity;
import app.data.db.repo.ProductRepository;
import app.data.web.dto.ProductDTO;
import app.data.web.dto.RequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProductServiceImpl implements ProductService {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void createProduct(ProductDTO productDTO) throws Exception {
        productRepository.save(modelMapper.map(productDTO, ProductEntity.class));
    }

    @Override
    @Transactional
    public List<ProductDTO> findProducts(RequestDTO requestDTO) throws Exception {
        if(requestDTO.isFindById()){
            List<ProductEntity> productEntities = Stream.of(productRepository.findById(requestDTO.getProductDTO().getId())).collect(Collectors.toList());
            return productEntities.stream().map(e -> modelMapper.map(e, ProductDTO.class)).collect(Collectors.toList());
        } if(requestDTO.isFindOnlyByName()) {
            List<ProductEntity> productEntities = productRepository.findByNameContaining(requestDTO.getProductDTO().getName());
            return productEntities.stream().map(e -> modelMapper.map(e, ProductDTO.class)).collect(Collectors.toList());
        }
        List<ProductEntity> productEntities = productRepository.findProductsByParams(requestDTO.getProductDTO().getProperties());
        return productEntities.stream().map(e -> modelMapper.map(e, ProductDTO.class)).collect(Collectors.toList());
    }

}
