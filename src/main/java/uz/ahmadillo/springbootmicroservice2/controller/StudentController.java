package uz.ahmadillo.springbootmicroservice2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ahmadillo.springbootmicroservice2.dto.StudentDto;
import uz.ahmadillo.springbootmicroservice2.entity.Student;
import uz.ahmadillo.springbootmicroservice2.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentservice;


    @GetMapping
    public String getInfo() {
        return studentservice.getInfo();
    }



    @GetMapping("/get/{id}")
    public Optional<Student> get(@PathVariable Long id) {
        return studentservice.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return studentservice.delete(id);
    }


    @GetMapping("/all")
    public List<Student> getAll() {
        return studentservice.getAll();
    }


    @PostMapping("/save")
    public Student save(@RequestBody StudentDto studentdto) {
        return studentservice.save(studentdto);
    }


    @PutMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentservice.update(student);
    }
}
