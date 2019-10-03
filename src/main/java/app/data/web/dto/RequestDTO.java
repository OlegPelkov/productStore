package app.data.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestDTO {

    private boolean findById;
    private boolean findOnlyByName;

    @NotNull(message = "Name may not be null")
    private ProductDTO productDTO;

    public boolean isFindById() {
        return findById;
    }

    public void setFindById(boolean findById) {
        this.findById = findById;
    }

    public boolean isFindOnlyByName() {
        return findOnlyByName;
    }

    public void setFindOnlyByName(boolean findOnlyByName) {
        this.findOnlyByName = findOnlyByName;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
