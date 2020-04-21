package pl.edu.pjwstk.jaz.category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class CategoryRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void add(CategoryEntity categoryEntity){
        em.persist(categoryEntity);
    }

    public List<CategoryEntity> getAll(){
        TypedQuery<CategoryEntity> query = em.createQuery("select u from CategoryEntity u", CategoryEntity.class);

        return query.getResultList();
    }

    public CategoryEntity findByName(String name) {
        TypedQuery<CategoryEntity> query = em.createQuery("select u from CategoryEntity u where u.name = :name", CategoryEntity.class);
        query.setParameter("name", name);

        return query.getSingleResult();
    }
}