package pl.edu.pjwstk.jaz.auction;

import pl.edu.pjwstk.jaz.branch.BranchEntity;
import pl.edu.pjwstk.jaz.branch.BranchRepository;
import pl.edu.pjwstk.jaz.branch.BranchRequest;
import pl.edu.pjwstk.jaz.photo.PhotoEntity;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("auction")
public class AuctionServlet extends HttpServlet {

    @Inject
    AuctionRepository auctionRepository;

    @Inject
    AuctionRequest auctionRequest;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String operation = req.getParameter("operation");
        Long id = Long.valueOf(req.getParameter("id"));


        if(operation.equals("view")){
            AuctionEntity auctionEntity = auctionRepository.get(id);
            String auctionTitle = auctionEntity.getTitle();
            String auctionDescription = auctionEntity.getDescription();
            Float auctionPrice = auctionEntity.getPrice();

            List<String> auctionPhotos = new ArrayList<>();
            for (PhotoEntity photoEntity: auctionEntity.getPhotos()) {
                auctionPhotos.add(photoEntity.getLink());
            }

            //Long auctionId = auctionEntity.getId();
            auctionRequest.setTitle(auctionTitle);
            auctionRequest.setDescription(auctionDescription);
            auctionRequest.setPrice(auctionPrice);
            auctionRequest.setPhotosUrls(auctionPhotos);

            req.getRequestDispatcher("auction_single.xhtml").forward(req, resp);

        } else if(operation.equals("delete")){

        }
    }
}