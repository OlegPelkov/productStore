package app.data.web.services;

import app.data.db.entity.ProductId;
import app.data.db.repo.ProductIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class ProductIdServiceImpl implements ProductIdService {

    @Autowired
    private ProductIdRepository productIdRepository;

    @Override
    @Transactional
    public long getNext() {
        Optional<ProductId> productIdOpt = Optional.ofNullable(productIdRepository.findTopByOrderByIdDesc());
        ProductId productId = productIdOpt.orElse(new ProductId(-1L));
        productId = productId.inc();
        productIdRepository.save(productId.inc());
        return productId.getId();
    }
}
