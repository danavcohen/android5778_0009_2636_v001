package model.entities.Classes;

/**
 * Created by temp on 11/23/2017.
 */

public class Administrator {
    private String _username;
    private String _password;
    public static int _key = 1234;


    public String get_username() {
        return _username;
    }
    public void set_username(String _username) {
        this._username = _username;
    }
    public String get_password() {
        return _password;
    }
    public void set_password(String _password) {
        this._password = _password;
    }

    public static int get_key() {
        return _key;
    }


    @Override
    public String toString(){

        String string = "Administrator : " + _username;
        return string;
    }
}