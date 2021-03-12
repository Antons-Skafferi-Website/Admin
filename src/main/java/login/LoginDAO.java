package login;

/**
 *
 * @author Felix
 */
public interface LoginDAO {
    public boolean validate(String user, String password);
    
}