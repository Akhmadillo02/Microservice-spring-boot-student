package uz.ahmadillo.springbootmicroservice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ahmadillo.springbootmicroservice2.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}