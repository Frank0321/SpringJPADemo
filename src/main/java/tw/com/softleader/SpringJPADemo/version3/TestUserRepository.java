package tw.com.softleader.SpringJPADemo.version3;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

import static java.lang.String.format;

@Repository
public class TestUserRepository {

    Collection<TestUser> testUsers;

    @PostConstruct
    public void setup(){
        testUsers = new HashSet<>();
        testUsers.add(TestUser.builder().id(1L).name("Frank").build());
    }

    public long save (TestUser testUser){
        testUser.setId((long) testUsers.size()+1);
        testUsers.add(testUser);
        return testUser.getId();
    }

    public Collection<TestUser> findAll(){
        return testUsers;
    }

    public TestUser findByid(long id){
        for (TestUser u : testUsers) {
            if (u.getId()== id){
                return u;
            }
        }
        new IllegalAccessException(format("User.id [%s] not exists", id));
        return null;
    }

    public void deleteById(Long id){
        testUsers.removeIf(u -> u.getId() == id);
    }



}
