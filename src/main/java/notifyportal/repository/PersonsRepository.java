package notifyportal.repository;

import notifyportal.model.PersonsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<PersonsModel, Integer> {

}
