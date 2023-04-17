package Api.NoAbras.Repository;

import Api.NoAbras.Model.CUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<CUser, Long> {
}
