import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // implement readObject and writeObject properly


    StringBuilder newpj = new StringBuilder();
    StringBuilder newp = new StringBuilder();

    String encrypt(String password) {
        for (int i = 0; i < password.length(); i++) {

            int c1 = password.charAt(i) + 1;
            char c = (char) c1;
            newpj.append(c + "");

        }
        return newpj.toString();
    }

    String decrypt(String password) {
        for (int i = 0; i < password.length(); i++) {

            int c1 = password.charAt(i) - 1;
            char c = (char) c1;
            newp.append(c + "");

        }
        return newp.toString();
    }
    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
        String  o = (String) ois.readObject();
        this.password = decrypt(o);
    }

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();
//        this.password=encrypt(getPassword());
        oos.writeObject(encrypt(getPassword()));
    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}