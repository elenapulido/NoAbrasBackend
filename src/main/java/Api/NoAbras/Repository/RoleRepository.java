package Api.NoAbras.Repository;

import java.util.Optional;

import Api.NoAbras.Model.Role;
import Api.NoAbras.Model.ERole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
