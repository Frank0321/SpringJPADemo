package tw.com.softleader.SpringJpaVersion1;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

import static java.lang.String.format;

@Repository
//用法：使用者標註資料訪問層元件（Dao層）
//作用：實現Dao訪問；將類識別為Bean，同時它將所標註的類中丟擲的資料訪問異常封裝為 Spring 的資料訪問異常型別。
public class UserRepository {

    Collection<User> users;

    @PostConstruct
    public void setup(){
        users = new HashSet<>();
        users.add(User.builder().id(1L).name("Frank").build());
    }

    public long save (User user){
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
