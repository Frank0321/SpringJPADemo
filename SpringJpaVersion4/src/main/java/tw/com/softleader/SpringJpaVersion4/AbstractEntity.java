package tw.com.softleader.SpringJpaVersion4;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Version;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Base class for entity implementations.
 */

@MappedSuperclass
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEntity <U extends Serializable> implements Serializable {
    /**
     * id
     */
    @NotNull
    @Id
    protected Long id;

    /**
     * 建立時間
     */
    protected LocalDateTime createdDate;

    /**
     * 建立人員
     */
    protected U createBy;

    /**
     * 最後修改時間
     */
    protected LocalDateTime lastModifiedDate;

    /**
     * 最後修改人員
     */
    protected  U lastModifiedBy;

    /**
     * 是否刪除
     */
    protected LocalDateTime deleted;

    /**
     * 資料儲存版本
     */
    @Version
    Long version;

    /**
     * 特殊欄位，使用時須先與各方約定
     */
//    private Map<String, String> extras = Maps.newHashMap();

}
