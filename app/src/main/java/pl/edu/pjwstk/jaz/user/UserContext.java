package pl.edu.pjwstk.jaz.user;

import pl.edu.pjwstk.jaz.auth.ProfileRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class UserContext {
    @Inject
    private HttpServletRequest request;

    @Inject
    private UserService userService;

    @Inject
    private ProfileRepository profileRepository;

    public String getUsername() {
        var session = request.getSession(false);
        var usernameObj = session.getAttribute("username");
        if (usernameObj == null) {
            throw new IllegalStateException("No session/User not logged in.");
        }

        return (String) usernameObj;
    }

    public String getFullName() {
        var username = getUsername();

        var user = userService.reqireUser(username);

        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}
