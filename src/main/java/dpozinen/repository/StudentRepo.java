package dpozinen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dpozinen.model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

}