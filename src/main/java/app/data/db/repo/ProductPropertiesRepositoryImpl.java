package app.data.db.repo;

import app.data.db.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.MapJoin;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductPropertiesRepositoryImpl implements ProductPropertiesRepository<ProductEntity> {

    @PersistenceContext
    private EntityManager em;

    public List<ProductEntity> findProductsByParams(Map<String, String> params) throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteria = cb.createQuery(ProductEntity.class);
        Root<ProductEntity> entity = criteria.from(ProductEntity.class);
        MapJoin<ProductEntity, String, String> mapJoin = entity.joinMap("properties", JoinType.INNER);
        Path<String> pkey = mapJoin.key();
        List<Predicate> predicates = params.keySet().stream().map(s -> cb.equal(pkey, s)).collect(Collectors.toList());
        criteria.select(entity);
        criteria.where(cb.or(predicates.stream().toArray(Predicate[]::new)));
        criteria.distinct(true);
        return em.createQuery(criteria).getResultList();
    }
}
