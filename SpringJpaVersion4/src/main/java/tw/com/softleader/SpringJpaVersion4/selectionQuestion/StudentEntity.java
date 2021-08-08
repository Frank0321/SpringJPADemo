package tw.com.softleader.SpringJpaVersion4.selectionQuestion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @Id
    Long id;

    String name;

    String studentId;
}
