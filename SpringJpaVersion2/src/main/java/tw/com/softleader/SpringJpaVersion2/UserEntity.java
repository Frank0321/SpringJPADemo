package tw.com.softleader.SpringJpaVersion2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UserEntity {
    @Id
    @GeneratedValue
    Long id;

    @NotBlank
    @Column(name = "abc")    //在DB 此欄位表示 abc 的欄位
    String name;
}
