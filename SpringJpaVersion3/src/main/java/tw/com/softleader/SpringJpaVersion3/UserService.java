package tw.com.softleader.SpringJpaVersion3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository repository;

    public Collection<User> getAll(){
        return repository.findAll();
    }

    public Long creatUser(User user){
        return repository.save(user);
    }
    public void deleteUser(Long id){
        repository.deleteById(id);
    }

    public User modifyUser(long id, User user) {
        User dbUser = repository.findByid(id);
        dbUser.setName(user.getName());
        return dbUser;

    }

    public User findOne(long id) {
        return repository.findByid(id);
    }
}
