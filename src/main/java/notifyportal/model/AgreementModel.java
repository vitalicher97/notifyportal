package notifyportal.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Agreement")
public class AgreementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AgrID;
    private String AgrName;
    private String CompName;
    private Date expDate;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "Agreement")
    private List<DocsModel> docsModel;*/

    protected AgreementModel() {
    }

    public AgreementModel(String AgrName, String CompName, Date ExpDate) {
        this.AgrName = AgrName;
        this.CompName = CompName;
        this.expDate = ExpDate;
    }


    public int getAgrID() {
        return AgrID;
    }

    public void setAgrID(int agrID) {
        AgrID = agrID;
    }

    public String getAgrName() {
        return AgrName;
    }

    public void setAgrName(String agrName) {
        AgrName = agrName;
    }

    public String getCompName() {
        return CompName;
    }

    public void setCompName(String compName) {
        CompName = compName;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    /*public List<DocsModel> getDocsModel() {
        return docsModel;
    }

    public void setDocsModel(List<DocsModel> docsModel) {
        this.docsModel = docsModel;
    }*/

    /*@Override
    public String toString() {
        return this.getAgrName();
    }*/
}
