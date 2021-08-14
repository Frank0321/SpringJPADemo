package tw.com.softleader.SpringJpaVersion3.Policy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyService {

    final PolicyRepository policyRepository;

    public PolicyEntity findByEndstNo (int endstNo){
        return policyRepository.findByEndstNo(endstNo).orElse(null);
    }

    public Collection<PolicyEntity> findQuotationNoByQuotationNo (String quotationNo){
        return policyRepository.findQuotationNoByQuotationNo(quotationNo);
    }

    public Optional<PolicyEntity> findByPolicyNo(String policyNo){
        return policyRepository.findByPolicyNo(policyNo);
    }

    public void save(PolicyEntity policyEntity){
        policyRepository.save(policyEntity);
    }

    public Collection<PolicyEntity> findPolicyNoNotNull(){
        return policyRepository.findPolicyEntityByPolicyNoIsNotNull();
    }
}
