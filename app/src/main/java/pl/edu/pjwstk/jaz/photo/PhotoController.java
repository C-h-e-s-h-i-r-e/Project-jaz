package pl.edu.pjwstk.jaz.photo;

import pl.edu.pjwstk.jaz.auction.AuctionEntity;
import pl.edu.pjwstk.jaz.branch.BranchEntity;
import pl.edu.pjwstk.jaz.branch.BranchRepository;
import pl.edu.pjwstk.jaz.category.CategoryEntity;
import pl.edu.pjwstk.jaz.category.CategoryRepository;
import pl.edu.pjwstk.jaz.category.CategoryRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class PhotoController {

    @Inject
    PhotoRepository photoRepository;


    public String add(String link, AuctionEntity auctionEntity){
        PhotoEntity photoEntity = new PhotoEntity(link, auctionEntity);
        photoRepository.add(photoEntity);
        return "index.xhtml?faces-redirect=true";
    }

}
