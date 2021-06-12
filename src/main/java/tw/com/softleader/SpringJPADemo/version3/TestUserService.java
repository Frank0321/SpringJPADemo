package tw.com.softleader.SpringJPADemo.version3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class TestUserService {

    final TestUserRepository repository;

    public Collection<TestUser> getAll(){
        return repository.findAll();
    }

    public Long creatUser(TestUser testUser){
        return repository.save(testUser);
    }
    public void deleteUser(Long id){
        repository.deleteById(id);
    }

    public TestUser modifyUser(long id, TestUser testUser) {
        TestUser dbTestUser = repository.findByid(id);
        dbTestUser.setName(testUser.getName());
        return dbTestUser;

    }

    public TestUser findOne(long id) {
        return repository.findByid(id);
    }
}
