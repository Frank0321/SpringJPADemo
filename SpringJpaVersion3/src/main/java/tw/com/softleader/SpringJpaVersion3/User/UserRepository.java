package tw.com.softleader.SpringJpaVersion3.User;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

import static java.lang.String.format;

@Repository
public class UserRepository {

    Collection<User> users;

    @PostConstruct
    public void setup(){
        users = new HashSet<>();
        users.add(User.builder().id(1L).name("Frank").build());
    }

    public Long save (User user){
        user.setId((long) users.size()+1);
        users.add(user);
        return user.getId();
    }

    public Collection<User> findAll(){
        return users;
    }

    public User findByid(long id){
        for (User u : users) {
            if (u.getId()== id){
                return u;
            }
        }
        new IllegalAccessException(format("User.id [%s] not exists", id));
        return null;
    }

    public void deleteById(Long id){
        users.removeIf(u -> u.getId() == id);
    }



}
