package uz.ahmadillo.springbootmicroservice2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.ahmadillo.springbootmicroservice2.dto.TeacherDto;
import uz.ahmadillo.springbootmicroservice2.entity.Teacher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final RestTemplate restTemplate;


    @Value(value = "${server.host}")
    private String Url;

    public String getInfo() {
        String msg = restTemplate.getForObject(Url +"/info", String.class);
        return msg;
    }


    public Teacher save(TeacherDto teacherDto) {
        TeacherDto savedTeacherDto = restTemplate.postForObject(Url + "/save", teacherDto, TeacherDto.class);
        Teacher teacher = Teacher.builder()
                .age(savedTeacherDto.getAge())
                .gender(savedTeacherDto.getGender())
                .name(savedTeacherDto.getName())
                .build();
        return teacher;
    }






    public List<Teacher> getAll() {
        Teacher[] teachersArray = restTemplate.getForObject(Url + "/all", Teacher[].class);
        return teachersArray != null ? Arrays.asList(teachersArray) : Collections.emptyList();
    }



    public Optional<Teacher> getById(Long id) {
        Teacher template = restTemplate.getForObject(Url + "/get/{id}", Teacher.class, id);
        return Optional.ofNullable(template);
    }





    public String  delete(Long id) {
        restTemplate.exchange(Url + "/delete/{id}", HttpMethod.DELETE, null, String.class, id);
        return "delete ";
    }

    public Teacher update(Teacher teacher) {
     restTemplate.put(Url + "/update",Teacher.class);
     return teacher;

    }
}
