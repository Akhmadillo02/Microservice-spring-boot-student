package uz.ahmadillo.springbootmicroservice2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ahmadillo.springbootmicroservice2.dto.StudentDto;
import uz.ahmadillo.springbootmicroservice2.entity.Student;
import uz.ahmadillo.springbootmicroservice2.repository.StudentRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentrepository;

    public String getInfo() {
        return "connect to service";
    }


    public Student save(StudentDto studentDto) {
        Student student = Student.builder()
                .age(studentDto.getAge())
                .gender(studentDto.getGender())
                .name(studentDto.getName())
                .build();
        return studentrepository.save(student);
    }

    public List<Student> getAll() {
        return studentrepository.findAll();
    }

    public Optional<Student> getById(Long id) {
        Optional<Student> studentOptional = studentrepository.findById(id);
        if (studentOptional.isPresent()) {
            return studentOptional;
        } else {
            throw new NoSuchElementException("Student with id " + id + " not found");
        }
    }



    public String  delete(Long id) {
         studentrepository.deleteById(id);
         return "delete " + id;
    }

    public Student update(Student student) {
        return studentrepository.save(student);
    }
}
