package tw.com.softleader.SpringJpaVersion5.policy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuredRepository extends JpaRepository<Insured, Long> {
}
