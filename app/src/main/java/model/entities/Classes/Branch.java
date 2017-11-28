package model.entities.Classes;

import model.entities.Enums.City;
import model.entities.Enums.WeekDay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static  model.entities.Classes.Branch.Counter.set_newBranch;



/**
 * Created by shlomo on 05-Nov-17.
 */

public class Branch {

    private int id; //branch number
    private int _numOfParking;
    private String _phoneNumber;
    private ArrayList<OpeningHours> _openingHours = new ArrayList<>();
    private Address _branchAddress;

    public void set_branchAddress(Address _branchAddress) {
        this._branchAddress = _branchAddress;
    };
    public Address get_branchAddress() {
        return _branchAddress;
    }
    public void set_openingHours(ArrayList<OpeningHours> _openingHours) {
        this._openingHours = _openingHours;
    }
    public void set_branchAddress(City city, String street, int streetNumber) {
        Address address = new Address();
        address.set_city(city);
        address.set_street(street);
        address.set_streetNumber(streetNumber);
        set_branchAddress(address);
    }
    public int get_numOfParking() {
        return _numOfParking;
    }
    public void set_numOfParking(int _numOfParking) {
        this._numOfParking = _numOfParking;
    }
    public int get_branchNum() {
        return id;
    }
    public void set_branchNum() {this.id = set_newBranch();}
    public void set_branchNum(int _branchNum) {
        this.id = _branchNum;
    }
    public String get_phoneNumber() {
        return _phoneNumber;
    }
    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }
    public ArrayList<OpeningHours> get_openingHours() {
        return _openingHours;
    }
    public void add_openingHours(OpeningHours openingHours) {
        _openingHours.add(openingHours);
    }


    public static class Address{
        private City _city;
        private String _street;
        private int _streetNumber;

        public City get_city() {
            return _city;
        }
        public void set_city(City _city) {
            this._city = _city;
        }
        public String get_street() {
            return _street;
        }
        public void set_street(String _street) {
            this._street = _street;
        }
        public int get_streetNumber() {
            return _streetNumber;
        }
        public void set_streetNumber(int _streetNumber) {
            this._streetNumber = _streetNumber;
        }
    }
    public static class OpeningHours {
        private WeekDay _day;
        private Date _hourOpen;
        private Date _hourClose;

        public WeekDay get_day() {
            return _day;
        }

        public void set_day(WeekDay _day) {
            this._day = _day;
        }
        public Date get_hourOpen() {return _hourOpen;}
        public void set_hourOpen(Date _hourOpen) {this._hourOpen = _hourOpen;}
        public Date get_hourClose() {return _hourClose;}
        public void set_hourClose(Date _hourClose) {this._hourClose = _hourClose;}

        public String toString() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            String toReturn = "Open on " + _day.toString() + " " +  simpleDateFormat.format(_hourOpen) + " - " + simpleDateFormat.format(_hourClose) + "\n";
            return (toReturn);
        }
    }
    public static class Counter {
        private static int _counterForBranchNum = 100;
        public static int get_counterForBranchNum() {
            return _counterForBranchNum;
        }
        public static int set_newBranch()  {
            return (++_counterForBranchNum);
        }
    }

    @Override
    public String toString() {
        return ("Branch number: " + id + " in " + _branchAddress._city.toString().substring(0,1).toUpperCase() + _branchAddress._city.toString().substring(1).toLowerCase());
    }
}
