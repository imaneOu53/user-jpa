package ma.emsi.jpaapp.repositories;

import ma.emsi.jpaapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String roleName);

}
