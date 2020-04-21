package pl.edu.pjwstk.jaz.auction;

import pl.edu.pjwstk.jaz.photo.PhotoEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Named
@ApplicationScoped
public class AuctionRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addAuction(AuctionEntity auctionEntity) {
        em.persist(auctionEntity);
    }

    public List<AuctionEntity> getAll(){
        TypedQuery<AuctionEntity> query = em.createQuery("select u from AuctionEntity u", AuctionEntity.class);

        return query.getResultList();
    }

    public List<PhotoEntity> getPhotos(Long id){
            TypedQuery<PhotoEntity> query = em.createQuery("select p from PhotoEntity p where p.auction.id=:id", PhotoEntity.class);
            query.setParameter("id",id);

            List<PhotoEntity> imgs = query.getResultList();
            for (PhotoEntity e:imgs){
                e.setLink("C:\\Users\\user\\IdeaProjects\\Project-jaz\\app\\src\\main\\webapp\\resources\\photos\\" + e.getLink());
            }

        return imgs;
    }
    public AuctionEntity get(Long id){
        return em.find(AuctionEntity.class, id);
    }
}
