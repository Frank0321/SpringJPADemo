package tw.com.softleader.SpringJpaVersion1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
//用法：用於標註業務層元件(Service層)上
//作用：標註於業務層元件上表示定義一個bean，自動根據所標註的元件名稱例項化一個首字母為小寫的bean。
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
