package tw.com.softleader.SpringJpaVersion4.selectionQuestion;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
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
    final StudentRepository studentRepository;

    @Transactional
    @GetMapping("/saveTeacher")
    public String saveData1(){
        TeacherEntity teacherEntity = TeacherEntity.builder()
                .id(1L)
                .name("Rhys")
                .teacherId("teacher1")
                .students(List.of(StudentEntity.builder()
                        .id(2L)
                        .name("matt")
                        .studentId("student1")
                        .build()))
                .build();
        log.info(teacherEntity.toString());

        teacherRepository.save(teacherEntity);

        return teacherEntity.toString();
    }

    @GetMapping("/saveStudent")
    public String saveData2(){
        StudentEntity studentEntity = StudentEntity.builder()
                .id(2L)
                .name("matt")
                .studentId("studentId")
                .build();
        studentRepository.save(studentEntity);
        return studentEntity.toString();
    }

}
