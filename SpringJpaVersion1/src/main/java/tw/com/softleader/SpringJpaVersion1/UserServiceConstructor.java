package tw.com.softleader.SpringJpaVersion1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

public class UserServiceConstructor {

    //Constructor 注入
    final UserRepository userRepository;

    @Autowired
    public UserServiceConstructor(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Collection<User> getAll(){
        return userRepository.findAll();
    }

}
