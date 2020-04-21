package pl.edu.pjwstk.jaz.auth;

import pl.edu.pjwstk.jaz.user.User;
import pl.edu.pjwstk.jaz.user.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProfileService {
    @Inject
    private ProfileRepository profileRepository;

    @Inject
    private UserService userService;

    @Inject
    private HttpServletRequest request;

    private final DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");

    public boolean logIn(String username, String password) {
        if (isUsernameAndPasswordCorrect(username, password)) {
            var session = request.getSession(true);
            session.setAttribute("username", username);

            return true;
        }
        return false;
    }

    private boolean isUsernameAndPasswordCorrect(String username, String password) {
        var userOptional = userService.findUserByUsername(username);
        if (userOptional.isEmpty()) {
            return false;
        }
        var user = userOptional.get();
        return user.getUsername().equals(username) && userService.match(password,user.getPassword());

    }

    public boolean doesUserExist(String username) {
        //noinspection SimplifyOptionalCallChains // just for learning
        return !userService.findUserByUsername(username).isEmpty();
    }

    public void addUser(String firstName, String lastName, String username, String password, String email, String birthday) {
        var user = new User(firstName, lastName, username, password, email, parseDate(birthday), false);
        userService.addUser(user);
    }

    private LocalDate parseDate(String dateAsText) {

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateAsText,formater);

//        try {
//
//            var parsedDate = dateFormat.parse(dateAsText);
//
//            return parsedDate.toInstant()
//                    .atZone(ZoneId.systemDefault())
//                    .toLocalDate();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        }

//    public void addTest() {
//        var user = new User("Admin", "Admin","admin", "admin",
//                "admin@admin.pl", LocalDate.now());
//        userService.addUser(user);
//    }
//
//    @PostConstruct
//    public void doesAdminExist(String username) {
//        username = "Admin";
//        if(userService.findUserByUsername(username).isEmpty()){
//            addTest();
//        }
//    }



    public void logout() {
        var session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
