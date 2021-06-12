package tw.com.softleader.SpringJPADemo.version3;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestUser {

    /**
     * User id
     */
    @Schema(title = "id")
    Long id;

    /**
     * 名字
     */
    @Schema(title = "名字")
    String name;

    /**
     * 員工編號
     */
    @Schema(title = "員工編號")
    String empNo;

}
