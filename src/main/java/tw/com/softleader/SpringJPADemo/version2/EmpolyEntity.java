package tw.com.softleader.SpringJPADemo.version2;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EmpolyEntity {
    @Id
    @GeneratedValue
    Long id;

    @NotBlank
    @Column(name = "abc")    //在DB 此欄位表示 abc 的欄位
    String name;
}
