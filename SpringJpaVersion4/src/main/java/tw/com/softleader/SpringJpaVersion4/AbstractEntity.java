package tw.com.softleader.SpringJpaVersion4;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.Version;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Base class for entity implementations.
 */

@MappedSuperclass
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
    @GeneratedValue(generator = "pooled")
    @GenericGenerator(name = "pooled", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
            @Parameter(name = "table_name", value = "sequence_pooled"),
            @Parameter(name = "value_column_name", value = "sequence_next_hi_value"),
            @Parameter(name = "prefer_entity_table_as_segment_value", value = "true"),
            @Parameter(name = "optimizer", value = "pooled-lo"),
            @Parameter(name = "initial_value", value = "100001"),
            @Parameter(name = "increment_size", value = "100") })
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
