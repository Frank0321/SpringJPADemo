package tw.com.softleader.SpringJpaVersion4;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "newABCtable")
//@Table(name = "new_AAA")  //不可以有 _
public class NewTableEntity {

    @Id
    @GeneratedValue
    Long newId;

    @Column(nullable = false, name = "ABC")
    String eefwsfsfgwsf;

    /**
     * TODO : 補充 OneToOne OneToMany 等
     */
}
