package notifyportal.repository;

import notifyportal.model.AgreementModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AgreementRepository extends JpaRepository<AgreementModel, Integer> {

    List<AgreementModel> findAllByExpDateBefore(Date checkDate);

}
