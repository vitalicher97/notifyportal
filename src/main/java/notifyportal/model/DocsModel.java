package notifyportal.model;

import javax.persistence.*;

@Entity
@Table(name = "Docs")
public class DocsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DocID;
    private String DocName;
    private int agrID;
    private int PersID;
    private boolean NotifySent;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AgrID", referencedColumnName = "AgrID")
    private AgreementModel Agreement;*/

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersID", referencedColumnName = "PersID")
    private PersonsModel Persons;*/

    protected DocsModel() {
    }

    public DocsModel(String DocName, int AgrID, int PersID, boolean NotifySent) {
        this.DocName = DocName;
        this.agrID = AgrID;
        this.PersID = PersID;
        this.NotifySent = NotifySent;
    }

    public int getDocID() {
        return DocID;
    }

    public void setDocID(int docID) {
        DocID = docID;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }

    public int getAgrID() {
        return agrID;
    }

    public void setAgrID(int AgrID) {
        AgrID = AgrID;
    }

    public int getPersID() {
        return PersID;
    }

    public void setPersID(int PersID) {
        PersID = PersID;
    }

    public boolean isNotifySent() {
        return NotifySent;
    }

    public void setNotifySent(boolean notifySent) {
        NotifySent = notifySent;
    }

    /*public AgreementModel getAgreement() {
        return Agreement;
    }

    public void setAgreement(AgreementModel agreement) {
        Agreement = agreement;
    }

    public PersonsModel getPersons() {
        return Persons;
    }

    public void setPersons(PersonsModel persons) {
        Persons = persons;
    }*/
}
