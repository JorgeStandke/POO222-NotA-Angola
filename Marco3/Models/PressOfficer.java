package Marco3.Models;

public class PressOfficer extends Person{

    private String tel1;
    private String tel2;
    private String emailAccount;

    public String getEmailAccount() {
        return emailAccount;
    }
    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }
    public String getTel1() {
        return tel1;
    }
    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }
    public String getTel2() {
        return tel2;
    }
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }
}
