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
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "abc")    //在DB 此欄位表示 abc 的欄位
    private String name;

    //nullable : 是否允許為null
    //length : 長度
    @Column(nullable = false, length = 32)
    private String mail;

    //columnDefinition : 設定型態
    @Column(columnDefinition = "char(11) NOT NULL")
    private String phone;

    //precision : 精度，有效位數幾位
    //scale : 精度，小數位數的總位數
    @Column(precision = 5, scale = 2)
    private BigDecimal salary;
}
