package ma.emsi.jpaapp.repositories;

import ma.emsi.jpaapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
   User findByUsername(String userName);

}
