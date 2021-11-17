package tw.com.softleader.SpringJpaVersion5.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper mapper;

  public void save(EmployeeEntity employee) {
    employeeRepository.save(employee);
  }

  public EmployeeDto getOne(Long id) {
    EmployeeEntity entity = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("此 id 不存在"));
    log.info("id is get from entity");
    EmployeeDto employeeDto = mapper.fromEntity(entity);
    return employeeDto;
  }
}
