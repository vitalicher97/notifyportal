package notifyportal.repository;

import notifyportal.model.DocsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocsRepository extends JpaRepository<DocsModel, Integer> {

    List<DocsModel> findAllByAgrID(int AgrID);

}
