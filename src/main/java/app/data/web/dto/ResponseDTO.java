package app.data.web.dto;

import java.util.List;

public class ResponseDTO {

    private List<ProductDTO> productsDTO;

    public ResponseDTO(List<ProductDTO> productsDTO) {
        this.productsDTO = productsDTO;
    }

    public List<ProductDTO> getProductsDTO() {
        return productsDTO;
    }

    public void setProductsDTO(List<ProductDTO> productsDTO) {
        this.productsDTO = productsDTO;
    }
}
