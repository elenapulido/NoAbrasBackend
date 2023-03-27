package Api.NoAbras.Repository;

import Api.NoAbras.Model.CModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<CModel, Long> {

}

