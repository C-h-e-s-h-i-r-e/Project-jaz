package pl.edu.pjwstk.jaz.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.edu.pjwstk.jaz.user.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {
    @PersistenceContext
    private EntityManager em;

    public Optional<User> findUserByUsername(String username) {
//        var user = (User)em.createQuery("select distinct from User where username = :username", User.class)
////                .setParameter("username", username)
////                .getSingleResult();
        TypedQuery<User> query = em.createQuery("select u from User u where u.username = :username", User.class);
        query.setParameter("username", username);

        List<User> users = query.getResultList();

        if(users.isEmpty())
        {
//            throw new IllegalStateException("Required user does not exist.");
            return Optional.empty();
        }
        else
        {
            return Optional.of(users.get(0));
        }
    }

    @Transactional
    public void addUser(User user) {
        user.setPassword(encode(user.getPassword()));
        em.persist(user);
    }

    User reqireUser(String username) {
        return findUserByUsername(username).get();
    }


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String encode(String password){
       return passwordEncoder.encode(password);
    }

    public boolean match(String fPassword, String sPassword){
        return passwordEncoder.matches(fPassword,sPassword);
    }

}
