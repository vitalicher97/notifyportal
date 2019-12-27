package notifyportal.service;

import notifyportal.model.*;
import notifyportal.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private AgreementRepository agreementRepository;
    @Autowired
    private DocsRepository docsRepository;
    @Autowired
    private PersonsRepository personsRepository;

    @Override
    public List getAllAgreements() {
        List<AgreementModel> agrList = (List<AgreementModel>) agreementRepository.findAll();
        return agrList;
    }

    @Override
    public PersonsModel storePersons(String name, String email) {

        PersonsModel data = new PersonsModel(name, email);

        data = personsRepository.save(data);

        return data;

    }

    @Override
    public DocsModel storeDocs(String fileName, int AgrID, int PersID, boolean NotifySent) {

        DocsModel data = new DocsModel(fileName, AgrID, PersID, NotifySent);

        data = docsRepository.save(data);

        return data;

    }

    @Override
    public AgreementModel storeAgreement(String agrName, String compName, Date expDate) {

        AgreementModel data = new AgreementModel(agrName, compName, expDate);

        data = agreementRepository.save(data);

        return data;

    }

    @Override
    public String deleteAllDocsAndPersons() {

        docsRepository.deleteAll();
        personsRepository.deleteAll();

        return "All documents and persons were successfully deleted!";

    }

    @Override
    public String deleteAllAgreements() {

        agreementRepository.deleteAll();

        return "All agreements were successfully deleted!";

    }

}
