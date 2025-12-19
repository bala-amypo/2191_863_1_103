ackage com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Department;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Employee,Long>
{
    Optional<Employee>findByEmail(String email);
    boolean existsByEmail(String email);
    List<Employee> findAll();
}
