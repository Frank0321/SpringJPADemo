package tw.com.softleader.SpringJpaVersion4;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;


@Service
//生成一個包含 final 變量的建構子
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;

    @PostConstruct
    public void init(){
        for (Long i = 0L; i < 10L; i++) {
            userRepository.save(UserEntity.builder().id(i).name("ABC"+ i).build());
        }
    }

    @PostConstruct
    public void initEmployee(){
        userRepository.save(EmployEntity.builder()
                .id(11L)
                .name("Employee")
                .build());

        userRepository.save(EmployEntity.builder()
                .employNo("A")
                .employEmail("email")
                .build());
    }



}
