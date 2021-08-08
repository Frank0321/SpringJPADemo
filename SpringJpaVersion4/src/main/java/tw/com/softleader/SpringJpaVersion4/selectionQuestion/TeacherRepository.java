package tw.com.softleader.SpringJpaVersion4.selectionQuestion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
