package tw.com.softleader.SpringJpaVersion1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

public class UserServiceAutowired {

    // 變量 (file) 注入
    @Autowired
    UserRepository userRepository;

    public Collection<User> getAll(){
        return userRepository.findAll();
    }

}
