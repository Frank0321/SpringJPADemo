package tw.com.softleader.SpringJpaVersion5;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 資料庫讀取的 model 需要轉成 dto 輸出到前端去
 * 我們在專案中時常會需要複製 Java Bean,
 * 也許是為了 Call Api 需要跟 DTO 互轉, 或是要轉成 VO 丟給某些頁面來使用
 *
 * ref : https://github.com/softleader/softleader-training-course/tree/master/2019/Q4/mapstruct
 */
//@org.mapstruct.Mapper
@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "id")
    @Mapping(target = "name")
    @Mapping(target = "empNo")
    MemberDto fromEntity (MemberEntity memberEntity);

}
