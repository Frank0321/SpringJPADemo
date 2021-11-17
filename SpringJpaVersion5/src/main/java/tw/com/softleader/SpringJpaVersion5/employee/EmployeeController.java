package tw.com.softleader.SpringJpaVersion5.employee;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostConstruct
    void init(){
        EmployeeEntity employee = EmployeeEntity.builder().id(1L).name("Frank").empId("SL0002").build();
        log.info("employee is save, id : " + employee.getId());
        employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public EmployeeDto getOne(@PathVariable Long id){
        return employeeService.getOne(id);
    }



}
