package pl.edu.pjwstk.jaz.auction;

import pl.edu.pjwstk.jaz.category.CategoryEntity;
import pl.edu.pjwstk.jaz.category.CategoryRepository;
import pl.edu.pjwstk.jaz.photo.Photo;
import pl.edu.pjwstk.jaz.photo.PhotoEntity;
import pl.edu.pjwstk.jaz.user.User;
import pl.edu.pjwstk.jaz.user.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AuctionController {

    @Inject
    private AuctionRequest auctionRequest;

    @Inject
    private AuctionRepository auctionRepository;

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private UserService userService;

    @Inject
    private HttpServletRequest request;

    @Inject
    private Photo photo;

    public String add() {
        User user = userByUsername();


        AuctionEntity auction = new AuctionEntity(auctionRequest.getTitle(), auctionRequest.getDescription(), auctionRequest.getPrice(), user, categoryRepository.findByName(auctionRequest.getCategoryName()));
        auctionRepository.addAuction(auction);

        photo.upload(auction);


        return "index.xhtml?faces-redirect=true";
    }

    private User userByUsername() {
        var session = request.getSession(false);
        var usernameObj = session.getAttribute("username");
        return userService.findUserByUsername((String)usernameObj).get();
    }

    public List<String> getCategories(){
        List<String> list = new ArrayList();
        for(CategoryEntity be : categoryRepository.getAll()){
            list.add(be.getName());
        }
        return list;
    }
}




