package tw.com.softleader.SpringJpaVersion3.Policy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Long> {

    //利用 endstNo 找尋 PolicyEntity 物件s
    Collection<PolicyEntity> findPolicyEntityByEndstNo (int endstNo);

    //利用報價單找尋 PolicyEntity
    Collection<PolicyEntity> findQuotationNoByQuotationNo (String quotationNo);

    //利用保單號找尋 PolicyEntity
    Optional<PolicyEntity> findByPolicyNo (String policyNo);

    //刪除此保單號的資料
    void deleteByPolicyNo (String policyNo);

    Collection<PolicyEntity> findPolicyEntityByPolicyNoIsNotNull ();


}
