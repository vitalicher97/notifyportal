package notifyportal.model;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
public class PersonsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PersID;
    private String Name;
    private String Email;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "Persons")
    private List<DocsModel> docsModel;*/

    protected PersonsModel() {
    }

    public PersonsModel(String Name, String Email) {

        this.Name = Name;
        this.Email = Email;

    }

    public int getPersID() {
        return PersID;
    }

    public void setPersID(int persID) {
        PersID = persID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    /*public List<DocsModel> getDocsModel() {
        return docsModel;
    }

    public void setDocsModel(List<DocsModel> docsModel) {
        this.docsModel = docsModel;
    }*/

}
