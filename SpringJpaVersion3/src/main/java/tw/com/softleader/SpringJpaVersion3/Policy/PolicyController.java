package tw.com.softleader.SpringJpaVersion3.Policy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/version3/policy")
public class PolicyController {

    final PolicyService policyService;

    @PostConstruct
    void init(){
        for (int i = 1; i <= 10; i++) {
            policyService.save(PolicyEntity.builder()
                    .id(new Long(i))
                    .quotationNo("報價單_0"+ i)
                    .policyNo("保單號_0"+ i)
                    .endstNo(0)
                    .seq(1)
                    .build());
        }
    }

    @GetMapping("/policyNo")
    public PolicyEntity findByPolicyNo (
            @RequestParam (value = "policyNo", required = false, defaultValue = "保單號_01") String policyNo){
        return policyService.findByPolicyNo(policyNo).orElse(null);
    }

    @GetMapping("/NotNull")
    public Collection<PolicyEntity> findPolicyNoNotNull (){
        return policyService.findPolicyNoNotNull();
    }

    @GetMapping("/quotataionNo")
    public Collection<PolicyEntity> findQuotationNo (@RequestParam(value = "quotationNo") String quotationNo){
        return policyService.findQuotationNoByQuotationNo(quotationNo);
    }
}
