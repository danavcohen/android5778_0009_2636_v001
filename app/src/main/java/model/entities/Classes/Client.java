package model.entities.Classes;


import model.entities.Enums.Gender;

import java.util.Date;

/**
 * Created by shlomo on 05-Nov-17.
 */

public class Client {

    private long id;
    private Gender _Gender;
    private Date _birthDay;
    private String _firstName;
    private String _lastName;
    private String _phoneNumber;
    private String _eMailAddress;
    private String _creditNumber;
    private long _customerNumber;
    private int _password;

    public int get_password() {
        return _password;
    }
    public void set_password(int _password) {
        this._password = _password;
    }
    public Gender get_Gender() {
        return _Gender;
    }
    public void set_Gender(Gender _Gender) {
        this._Gender = _Gender;
    }
    public Date get_birthDay() {
        return _birthDay;
    }
    public void set_birthDay(Date _birthDay) {
        this._birthDay = _birthDay;
    }
    public String get_firstName() {
        return _firstName;
    }
    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }
    public String get_lastName() {
        return _lastName;
    }
    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }
    public long get_id() {
        return id;
    }
    public void set_id(long _id) {
        this.id = _id;
    }
    public String get_phoneNumber() {
        return _phoneNumber;
    }
    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }
    public String get_eMailAddress() {
        return _eMailAddress;
    }
    public void set_eMailAddress(String _eMailAddress) {
        this._eMailAddress = _eMailAddress;
    }
    public String get_creditNumber() {
        return _creditNumber;
    }
    public void set_creditNumber(String _creditNumber) {
        this._creditNumber = _creditNumber;
    }
    public long get_customerNumber() {
        return _customerNumber;
    }
    public void set_customerNumber() {
        _customerNumber = Counter.set_newCustomer();
    }
    public void set_customerNumber(long _customerNumber) {
        this._customerNumber = _customerNumber;
    }

    /*/
    THIS INNER CLASS IS FOR GIVE US CUSTOMER NUMBERS.
    */
    public static class Counter {
        private static long _counterForCustomerNum = 100;
        public static long get_counterForCustomerNum() {
            return _counterForCustomerNum;
        }
        public static long set_newCustomer()  {
            return (++_counterForCustomerNum);
        }
    }

    @Override
    public String toString() {
        return (_firstName + " " + _lastName + " " + _customerNumber);
    }

}
