package tw.com.softleader.SpringJpaVersion5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/{id}")
    public MemberDto getOne(@PathVariable Long id){
        MemberDto memberDto = memberService.getOne(id);
        return memberDto;
    }
}
