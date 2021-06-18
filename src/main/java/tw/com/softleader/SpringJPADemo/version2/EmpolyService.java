package tw.com.softleader.SpringJPADemo.version2;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.springframework.util.StringUtils.hasText;


@Service
//生成一個包含 final 變量的建構子
@RequiredArgsConstructor
public class EmpolyService {

    final EmpolyRepository empolyRepository;

//    public EmpolyService(EmpolyRepository empolyRepository){
//        this.empolyRepository = empolyRepository;
//    }

    public EmpolyEntity findById(Long id) {
        // 使用 getById 需要再處理 Exception 的問題
        return empolyRepository.findById(id).orElse(null);
    }

    public void save(EmpolyEntity empolyEntity){
        empolyRepository.save(empolyEntity);
    }

    public Page<EmpolyEntity> findAll(Pageable pageable){
        return empolyRepository.findAll(pageable);
    }

    /**
     * 傳入物件，並取出裡面的 name 值進行搜尋，將所以搜尋的解果用 Page 組合起來回傳
     * root 用來定義跟哪個欄位比對
     * query : top level query 通常用不到，先忽略
     * criteriaBuilder 用來定義 where 的比對條件，如 eq、lt、gt 之類的
     * @param empolyEntity
     * @param pageable
     * @return
     */
    public Page<EmpolyEntity> getAllByCondition(EmpolyEntity empolyEntity, Pageable pageable){
        final Specification<EmpolyEntity> spec =
                (root, query, criteriaBuilder) ->{
                    List<Predicate> predicates = new ArrayList<>();
                    if (hasText(empolyEntity.getName())){
                        predicates.add(criteriaBuilder.equal(root.get("name"), empolyEntity.getName()));
                    }
                    return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
                };
        return empolyRepository.findAll(spec, pageable);
    }

    /**
     * 需要熟悉 lambda 的寫法
     * @param id
     * @param empolyEntity
     * @return
     */
    public EmpolyEntity modifyEmpoly(Long id, EmpolyEntity empolyEntity) {
        return empolyRepository
                .findById(id)
                .map(
                        e -> {
                            e.setName(empolyEntity.getName());
                            return e;
                        })
                .map(empolyRepository::save)
                .orElseThrow(() ->new IllegalArgumentException(format("Empoly.id [%s] not exits", id)));
    }

    public long creatEmpolyee(EmpolyEntity empolyEntity) {
        return empolyRepository.save(empolyEntity).getId();
    }

    public void deleteEmpoly(long id) {
        empolyRepository.deleteById(id);
    }
}
