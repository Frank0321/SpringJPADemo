package tw.com.softleader.SpringJPADemo.version2;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/empolyee")
@RequiredArgsConstructor
public class EmpolyController {
    /**
     * https://matthung0807.blogspot.com/2018/08/spring-autowired.html
     */
    final EmpolyService empolyService;

    @PostConstruct
    public void init(){
        for (int i = 1; i <= 1000; i++) {
            empolyService.save(EmpolyEntity
                    .builder().name("name" + i).build());
        }
    }
    @Operation(summary = "查詢全部資料，已分頁呈現")
    @GetMapping
    public Page<EmpolyEntity> findAll(Pageable pageable){
        return empolyService.findAll(pageable);
    }
    @Operation(summary = "查詢單一筆資料")
    @GetMapping("/{id}")
    public EmpolyEntity findOne (@PathVariable("id") Long id){
        return empolyService.findById(id);
    }
    @Operation(summary = "以物件的 name 進行查詢，並以分頁呈現結果")
    @GetMapping("/by")
    public Page<EmpolyEntity> getAllByCondition (EmpolyEntity empolyEntity, Pageable pageable){
        return empolyService.getAllByCondition(empolyEntity, pageable);
    }
    @Operation(summary = "修改資料")
    @PutMapping("/{id}")
    public EmpolyEntity modifyEmpoly (@PathVariable("id") Long id, @RequestBody EmpolyEntity empolyEntity){
        return empolyService.modifyEmpoly(id, empolyEntity);
    }
    @Operation(summary = "新增一筆資料")
    @PostMapping
    public long creatEmpoly (@RequestBody EmpolyEntity empolyEntity){
        return empolyService.creatEmpolyee(empolyEntity);
    }
    @Operation(summary = "刪除一筆資料")
    @DeleteMapping("/{id}")
    public void deleteEmpoly (@PathVariable("id") long id){
        empolyService.deleteEmpoly(id);
    }





}
