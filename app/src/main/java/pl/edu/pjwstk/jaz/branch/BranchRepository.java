package pl.edu.pjwstk.jaz.branch;

import pl.edu.pjwstk.jaz.user.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class BranchRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void add(BranchEntity branchEntity){
        em.merge(branchEntity);
    }

    public List<BranchEntity> getAll(){
        TypedQuery<BranchEntity> query = em.createQuery("select u from BranchEntity u", BranchEntity.class);

         return query.getResultList();
    }

    public BranchEntity findByName(String name){
        TypedQuery<BranchEntity> query = em.createQuery("select u from BranchEntity u where u.name = :name", BranchEntity.class);
        query.setParameter("name", name);

        return query.getSingleResult();
    }

    public BranchEntity get(Long id){
        return em.find(BranchEntity.class, id);
    }

    @Transactional
    public void remove(Long id){
        BranchEntity branchEntity = get(id);
        em.remove(branchEntity);
    }
}
