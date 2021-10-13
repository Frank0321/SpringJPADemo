package tw.com.softleader.SpringJpaVersion5.policy;

import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * FileName : PolicyController
 * CreatTime : 2021/10/13
 * Author : Frank
 * Description :
 */
@RestController
@RequestMapping("/policy")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyRepository policyRepository;

    @PostConstruct
    void init(){
        PolicyEntity policy1 = PolicyEntity.builder().policyNo("AAA").endstNo(2).applicantIdNo("aaa").build();
        policyRepository.save(policy1);
        PolicyEntity policy2 = PolicyEntity.builder().policyNo("AAA").endstNo(1).applicantIdNo("bba").build();
        policyRepository.save(policy2);
        PolicyEntity policy3 = PolicyEntity.builder().policyNo("BBB").endstNo(2).applicantIdNo("bbb").build();
        policyRepository.save(policy3);
    }

    @GetMapping("/testAll")
    public List<PolicyEntity> findAll(){
        return policyRepository.findAll();
    }

    @GetMapping("/test")
    public List<PolicyEntity> query(@And({
            @Spec(path = "policyNo", spec = Equal.class),
            @Spec(path = "applicantIdNo", spec = Like.class)
    })Specification<PolicyEntity> specification){
        return policyRepository.findAll(specification);
    }
    //No primary or single public constructor found for interface org.springframework.data.jpa.domain.Specification - and no default constructor found either
    //待解決
}
