package tw.com.softleader.SpringJpaVersion5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    @PostConstruct
    public void initData(){
        MemberEntity memberEntity = MemberEntity.builder()
                                    .id(1L)
                                    .name("Rhys")
                                    .empNo("132")
                                    .build();
        memberRepository.save(memberEntity);
    }

    /**
     * memberRepository.getOne(id)   可能會造成 null
     * Optional 此型別內建提醒 null 的產生
     * 	of(T value)  從一個物件取回 optional 的型別 (取得用的), 如果有 null 會有 Exception
     *  ofNullable(T value) 有 null 則不會有 Exception
     *
     *  ------
     *  orElse(T other)
     *  orElseThrow(Supplier<? extends X> exceptionSupplier)
     *  ------
     *  get()   //較少使用，要先確定回傳不會有 null，否則會 exception
     */
    public MemberDto getOne(Long id){
        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(id);
        MemberEntity memberEntity = memberEntityOptional.orElseThrow(()-> new RuntimeException("此 id 不存在"));
        MemberDto memberDto = MemberMapper.INSTANCE.fromEntity(memberEntity);
        return memberDto;
    }

}
