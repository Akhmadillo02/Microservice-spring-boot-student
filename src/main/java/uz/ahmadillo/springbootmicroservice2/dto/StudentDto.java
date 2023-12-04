package uz.ahmadillo.springbootmicroservice2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String name;

    private String gender;

    private Long age;
}
