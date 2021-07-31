package tw.com.softleader.SpringJpaVersion4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tw.com.softleader.SpringJpaVersion4.Extends.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> , JpaSpecificationExecutor<UserEntity> {


}
