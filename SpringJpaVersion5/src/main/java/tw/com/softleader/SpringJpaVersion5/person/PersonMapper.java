package tw.com.softleader.SpringJpaVersion5.person;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person fromDTO (PersonDTO personDTO);

    PersonDTO toDTO (Person person);

    //好像只能從 VO 轉換成 物件，不能從物件轉換成 VO
//    PersonVO toVO (Person person);

    Person fromVO(PersonVO personVO);
}
