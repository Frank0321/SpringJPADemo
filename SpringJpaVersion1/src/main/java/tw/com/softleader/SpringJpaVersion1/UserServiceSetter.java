package tw.com.softleader.SpringJpaVersion1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

public class UserServiceSetter {

    //sest方法注入
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Collection<User> getAll(){
        return userRepository.findAll();
    }
}
