package tw.com.softleader.SpringJpaVersion4.selectionQuestion;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
@Slf4j
public class TeacherController {

    final TeacherRepository teacherRepository;

    @GetMapping("/save")
    public void saveDate(){
        TeacherEntity teacherEntity = TeacherEntity.builder()
                .id(1L)
                .name("Rhys")
                .teacherId("teacher1")
                .students(List.of(StudentEntity.builder()
                        .id(23L)
                        .name("Jojo")
                        .studentId("student")
                        .build()))
                .build();
        log.info(teacherEntity.toString());
        teacherRepository.save(teacherEntity);
    }
}
