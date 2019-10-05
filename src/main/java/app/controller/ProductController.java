package app.controller;

import app.data.web.dto.RequestDTO;
import app.data.web.dto.ResponseDTO;
import app.data.web.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/createProduct", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createProduct(@Valid @RequestBody RequestDTO requestDTO) {
        try {
            productService.createProduct(requestDTO.getProductDTO());
        } catch (Exception e) {
            LOG.error("{}",e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/findProduct", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findProduct(@RequestBody RequestDTO requestDTO) {
        try {
            return ResponseEntity.ok(new ResponseDTO(productService.findProducts(requestDTO)));
        } catch (Exception e) {
            LOG.error("{}",e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/findProductById", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findProductById(@RequestBody RequestDTO requestDTO) {
        try {
            return ResponseEntity.ok(new ResponseDTO(productService.findProducts(requestDTO)));
        } catch (Exception e) {
            LOG.error("{}",e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}