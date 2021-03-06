package tw.com.softleader.SpringJpaVersion5;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import tw.com.softleader.SpringJpaVersion5.policy.Insured;
import tw.com.softleader.SpringJpaVersion5.policy.InsuredRepository;
import tw.com.softleader.SpringJpaVersion5.policy.PolicyEntity;
import tw.com.softleader.SpringJpaVersion5.policy.PolicyRepository;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PolicyTest{

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    InsuredRepository insuredRepository;

    @BeforeAll
    void init(){
        List<PolicyEntity> policyEntityList = List.of(
                PolicyEntity.builder().policyNo("AAA").applicantLocalName("aaa").endstNo(0).build(),
                PolicyEntity.builder().policyNo("AAA").applicantLocalName("bbb").build(),
                PolicyEntity.builder().policyNo("AAA").applicantLocalName("aca").build(),
                PolicyEntity.builder().policyNo("BBB").applicantLocalName("aaacc").build(),
                PolicyEntity.builder().policyNo("CCC").applicantLocalName("ccc").build(),
                PolicyEntity.builder().policyNo("AAA").applicantLocalName("aaa").endstNo(1).build(),
                PolicyEntity.builder().policyNo("BBB").applicantLocalName("bbb").InsuredId(5L).build()
        );
        policyEntityList.stream().forEach(policy -> policyRepository.save(policy));
        insuredRepository.save(Insured.builder().id(5l).insuredLocalName("Rhys").build());
    }

    @Test
    void test1(){
        log.info(specMethod(PolicyEntity.builder()
                                        .policyNo("BBB")
                                        .build())
                                .stream()
                                .findFirst().orElse(null)
                            .toString());

        log.info(specMethod(PolicyEntity.builder()
                .policyNo("AAA")
                .applicantLocalName("c")
                .build())
                .stream()
                .findFirst().orElse(null)
                .toString());
    }

//    @Test
//    void joinTest(){
//        log.info(specMethod(PolicyEntity.builder()
//                                        .policyNo("BBB")
//                                        .InsuredId(5L)
//                                        .build())
//                                    .stream()
//                                    .findFirst().orElse(null)
//                                .toString());
//    }

    @Test
    void subQueryTest(){
        log.info(specMethodTwo(PolicyEntity.builder()
                                            .policyNo("AAA")
                                            .build())
                                        .stream()
                                        .findFirst().orElse(null)
                                    .toString());
    }

    private List<PolicyEntity> specMethod(PolicyEntity policy){
        Specification<PolicyEntity> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            //????????? policyNo ????????? equal
            if (StringUtils.hasText(policy.getPolicyNo())){
                Predicate policyPredicate = criteriaBuilder.equal(root.get("policyNo"), policy.getPolicyNo());
                predicateList.add(policyPredicate);
            }

            //????????? applicantLocalName ????????? like
            if (StringUtils.hasText(policy.getApplicantLocalName())){
                Predicate applicantLocalNamePredicate = criteriaBuilder.like(root.get("applicantLocalName"), '%'+policy.getApplicantLocalName()+'%');
                predicateList.add(applicantLocalNamePredicate);
            }

//            //????????? insuredId ?????? join (??????)
//            if (!StringUtils.isEmpty(policy.getInsuredId())){
//                Join<PolicyEntity, Insured> insuredJoin = root.join("InsuredId", JoinType.INNER);
//                Predicate insuredPredicate = criteriaBuilder.equal(insuredJoin.get("Insured_.id"), policy.getInsuredId());
//                predicateList.add(insuredPredicate);
//            }

            Predicate[] predicates = new Predicate[predicateList.size()];
            return criteriaBuilder.and(predicateList.toArray(predicates));
        };
        return policyRepository.findAll(specification);
    }


    private List<PolicyEntity> specMethodTwo(PolicyEntity policy){
        //????????????
        Specification<PolicyEntity> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            //????????? policyNo ????????? equal
            if (StringUtils.hasText(policy.getPolicyNo())){
                Predicate policyPredicate = criteriaBuilder.equal(root.get("policyNo"), policy.getPolicyNo());
                predicateList.add(policyPredicate);
            }
            Predicate[] predicates = new Predicate[predicateList.size()];
            return criteriaBuilder.and(predicateList.toArray(predicates));
        };
        //?????????
        Specification<PolicyEntity> newSpec = (root, criteriaQuery, criteriaBuilder) -> {
            Subquery<Long> subQuery = criteriaQuery.subquery(Long.class);
            Root<PolicyEntity> subQueryRoot = subQuery.from(PolicyEntity.class);
            //?????? endstNo ?????????
            subQuery.select(criteriaBuilder.max(subQueryRoot.get("endstNo")));
            subQuery.where(criteriaBuilder.equal(root.get("policyNo"), subQueryRoot.get("policyNo")));
            return criteriaBuilder.equal(root.get("endstNo"), subQuery);
        };
        return policyRepository.findAll(Specification.where(specification).and(newSpec));

    }
}
