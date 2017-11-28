package model.entities.Classes;


import java.util.Date;

/**
 * Created by shlomo on 05-Nov-17.
 */

public class Order {

    private long id; // order number
    private long _customerNumber;
    private boolean _openOrder;
    private int _carNumber;
    private Date _rentalStart;
    private Date _rentalEnd;
    private long _kilometerStart;
    private long _kilometerEnd;
    private boolean _fuelFilled;
    private int _fuelFilledSum;
    private double _finalBillAmount;


    public long get_customerNumber() {
        return _customerNumber;
    }

    public void set_customerNumber(long _customerNumber) {
        this._customerNumber = _customerNumber;
    }

    public boolean is_openOrder() {
        return _openOrder;
    }

    public void set_openOrder(boolean _openOrder) {
        this._openOrder = _openOrder;
    }

    public int get_carNumber() {
        return _carNumber;
    }

    public void set_carNumber(int _carNumber) {
        this._carNumber = _carNumber;
    }

    public Date get_rentalStart() {
        return _rentalStart;
    }

    public void set_rentalStart(Date _rentalStart) {
        this._rentalStart = _rentalStart;
    }

    public Date get_rentalEnd() {
        return _rentalEnd;
    }

    public void set_rentalEnd(Date _rentalEnd) {
        this._rentalEnd = _rentalEnd;
    }

    public long get_kilometerStart() {
        return _kilometerStart;
    }

    public void set_kilometerStart(long _kilometerStart) {
        this._kilometerStart = _kilometerStart;
    }

    public long get_kilometerEnd() {
        return _kilometerEnd;
    }

    public void set_kilometerEnd(long _kilometerEnd) {
        this._kilometerEnd = _kilometerEnd;
    }

    public boolean is_fuelFilled() {
        return _fuelFilled;
    }

    public int get_fuelFilledSum() {
        return _fuelFilledSum;
    }

    public void set_fuelFilledSum(int _fuelFilledSum) {
        if(_fuelFilledSum > 0)
            _fuelFilled = true;
        else
            _fuelFilled = false;

        this._fuelFilledSum = _fuelFilledSum;
    }

    /*/

    TODO: get_finalBillAmount : calculate the amount to pay
    NEED TO BE COMPLETED. calculate the amount to pay is based to:
    1. the sum of total hours (complete day is calculated as 15 hours)
    2. the sum of Km's (1 NIS for each Km)
    3. the price for hour, based on the car model
    4. reduce from this the sum of fuel filled
    /*/
    public double get_finalBillAmount() {
        int sumInHours = (int)(
                (_rentalEnd.getTime() - _rentalStart.getTime())
                        / (1000 * 60 * 60 * 24));
        return 10000;
    }

    public long get_orderNumber() {
        return id;
    }
    public void set_orderNumber() { //for the first time created
        this.id = Counter.set_newOrder();
    }
    public void set_orderNumber(long _orderNumber) {//for copies, like in Tools class
        this.id = _orderNumber;
    }



    //THIS INER CLASS IS FOR GIVE US ORDER NUMBERS.
    public static class Counter {
        private static long _counterForOrderNum = 10000000;

        public static long get_counterForOrderNum() {
            return (_counterForOrderNum);
        }
        public static long set_newOrder() {
            return (++_counterForOrderNum);
        }
    }

    @Override
    public String toString() {
        return ("Order: " + id);
    }
}
