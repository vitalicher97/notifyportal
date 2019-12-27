package notifyportal.service;

import notifyportal.model.AgreementModel;
import notifyportal.model.DocsModel;
import notifyportal.model.PersonsModel;
import notifyportal.repository.AgreementRepository;
import notifyportal.repository.DocsRepository;
import notifyportal.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LicenceExpireServiceImpl implements LicenceExpireService {

    @Autowired
    MainService mainService;

    @Autowired
    AgreementRepository agreementRepository;

    @Autowired
    DocsRepository docsRepository;

    @Autowired
    PersonsRepository personsRepository;

    @Autowired
    EmailService emailService;

    @Override
    public void calculateWhoseLicenceExpire(boolean sendAnyway) {


        LocalDate checkDate = LocalDate.now().plusWeeks(2);
        List<AgreementModel> expiredAgrList = agreementRepository.findAllByExpDateBefore(Date.valueOf(checkDate));

        List<DocsModel> expDocsList = null;
        Optional<PersonsModel> persWithExp = null;
        String emailText;
        if (!expiredAgrList.isEmpty()) {
            for (AgreementModel expiredAgr : expiredAgrList) {
                expDocsList = docsRepository.findAllByAgrID(expiredAgr.getAgrID());

                for (DocsModel expDoc : expDocsList) {
                    persWithExp = personsRepository.findById(expDoc.getPersID());
                    if (expDoc.isNotifySent() != true || sendAnyway) {
                        emailText = "Dear " + persWithExp.get().getName() + "! Your licence '" +
                                expiredAgr.getAgrName() + "' used in '" + expDoc.getDocName() + "' document expire " +
                                expiredAgr.getExpDate() + ".";
                        emailService.sendSimpleMessage(persWithExp.get().getEmail().toString(),
                                "Licence expire soon", emailText);
                        expDoc.setNotifySent(true);
                        docsRepository.save(expDoc);
                    }
                }
            }
        }

    }

}
