package app.data.db.repo;

import app.data.db.entity.ProductEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.TransactionManager;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private TransactionManager tm;

    @Autowired
    private EntityManagerFactory emf;

    public List<ProductEntity> findProductsByParams(Map<String, String> params) throws Exception {
        try {
            tm.begin();
            Set<ProductEntity> resultList = new HashSet<>();
            EntityManager em = emf.createEntityManager();
            for (String key : params.keySet()) {
                Query query = em.createNativeQuery("{ 'properties." + key + "': '" + params.get(key) + "' }", ProductEntity.class);
                resultList.addAll(query.getResultList());
            }
            em.flush();
            em.close();
            tm.commit();
            return new ArrayList<>(resultList);
        } catch (Exception e) {
            tm.rollback();
            throw new Exception(e);
        }
    }

    @Override
    public ProductEntity findById(ObjectId id) throws Exception {
        try {
            tm.begin();
            EntityManager em = emf.createEntityManager();
            ProductEntity productEntity = em.find(ProductEntity.class, id);
            em.flush();
            em.close();
            tm.commit();
            return productEntity;
        } catch (Exception e) {
            tm.rollback();
            throw new Exception(e);
        }
    }

    @Override
    public List<ProductEntity> findByNameContaining(String name) throws Exception {
        try {
            tm.begin();
            List<ProductEntity> list = new ArrayList<>();
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT p FROM ProductEntity p WHERE name LIKE :name", ProductEntity.class);
            q.setParameter("name", "%" + name + "%");
            list = (List<ProductEntity>) q.getResultList();
            em.flush();
            em.close();
            tm.commit();
            return list;
        } catch (Exception e) {
            tm.rollback();
            throw new Exception(e);
        }
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) throws Exception {
        try {
            tm.begin();
            EntityManager em = emf.createEntityManager();
            em.persist(productEntity);
            em.flush();
            em.close();
            tm.commit();
            return productEntity;
        } catch (Exception e) {
            tm.rollback();
            throw new Exception(e);
        }
    }
}
