package pl.edu.pjwstk.jaz.photo;

import pl.edu.pjwstk.jaz.auction.AuctionController;
import pl.edu.pjwstk.jaz.auction.AuctionEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;



@Named
@RequestScoped
public class Photo {
    private List<Part> files;

    @Inject
    PhotoController photoController;

    public boolean upload(AuctionEntity auctionEntity){

        for(Part file : files) {
            try (InputStream input = file.getInputStream()) {
                String fileName = file.getSubmittedFileName();
                String data = "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")) +".";
                fileName = fileName.replace(".", data);

                Path path = new File("C:\\Users\\user\\IdeaProjects\\Project-jaz\\app\\src\\main\\webapp\\resources\\photos\\", fileName).toPath();
                Files.copy(input, path);
                photoController.add(fileName, auctionEntity);

            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public List<Part> getFiles() {
        return files;
    }

    public void setFiles(List<Part> files) {
        this.files = files;
    }
}
