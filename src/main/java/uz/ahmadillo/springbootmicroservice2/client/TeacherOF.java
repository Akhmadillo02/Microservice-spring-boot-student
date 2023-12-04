package uz.ahmadillo.springbootmicroservice2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import uz.ahmadillo.springbootmicroservice2.dto.TeacherDto;
import uz.ahmadillo.springbootmicroservice2.entity.Teacher;

@FeignClient(value = "myStudent", url = "${server.host}")
public interface TeacherOF {


    @GetMapping("/info")
    String getInfo();


    @PostMapping("/save")
    Teacher save(@RequestBody TeacherDto teacherDto);


    @PutMapping("/update")
    Teacher update(@RequestBody Teacher teacher);


    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable Long id);


    @GetMapping("/get/{id}")
    Teacher findById(@PathVariable Long id);

}
