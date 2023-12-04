package uz.ahmadillo.springbootmicroservice2.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ahmadillo.springbootmicroservice2.dto.TeacherDto;
import uz.ahmadillo.springbootmicroservice2.entity.Teacher;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class TeacherRecourse {


    private final TeacherOF teacherOF;

    @GetMapping("/info-client")
    public String getInfo() {
        return teacherOF.getInfo();
    }

    @GetMapping("/get/{id}")
    public Teacher get(@PathVariable Long id) {
        return teacherOF.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        teacherOF.delete(id);
        return ResponseEntity.ok("Teacher deleted successfully");
    }


    @PostMapping("/save")
    public Teacher save(@RequestBody TeacherDto teacherDto) {
        return teacherOF.save(teacherDto);
    }



    @PutMapping("/update")
    public Teacher update(@RequestBody Teacher teacher) {
        return teacherOF.update(teacher);
    }

}
