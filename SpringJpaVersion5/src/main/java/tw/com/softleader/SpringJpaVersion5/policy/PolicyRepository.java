package tw.com.softleader.SpringJpaVersion5.policy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Long>, JpaSpecificationExecutor<PolicyEntity> {

}
