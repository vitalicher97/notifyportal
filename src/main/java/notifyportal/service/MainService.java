package notifyportal.service;

import notifyportal.model.*;

import java.sql.Date;
import java.util.List;

public interface MainService {

    List<AgreementModel> getAllAgreements();

    PersonsModel storePersons(String name, String email);

    DocsModel storeDocs(String fileName, int AgrID, int PersID, boolean NotifySent);

    AgreementModel storeAgreement(String agrName, String compName, Date expDate);

    String deleteAllDocsAndPersons();

    String deleteAllAgreements();

}
