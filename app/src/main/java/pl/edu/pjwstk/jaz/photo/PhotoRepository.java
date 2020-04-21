package pl.edu.pjwstk.jaz.photo;

import pl.edu.pjwstk.jaz.auction.AuctionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class PhotoRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void add(PhotoEntity photoEntity) {
        em.persist(photoEntity);
    }
}
