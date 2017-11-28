package model.entities.Classes;

/**
 * Created by shlomo on 05-Nov-17.
 */

public class Car {
    private int id; //vehicle number
    private int _branchNumber;
    private int _modelCode;
    private long _kilometers;


    public int get_branchNumber() {
        return _branchNumber;
    }
    public void set_branchNumber(int _branchNumber) {
        this._branchNumber = _branchNumber;
    }
    public int get_modelCode() {
        return _modelCode;
    }
    public void set_modelCode(int modelCode) {
        _modelCode = modelCode;
    }
    public long get_kilometers() {
        return _kilometers;
    }
    public void set_kilometers(long _kilometers) {
        this._kilometers = _kilometers;
    }
    public int get_vehicleNumber() {
        return id;
    }
    public void set_vehicleNumber(int _vehicleNumber) {
        this.id = _vehicleNumber;
    }

    @Override
    public String toString() {
        return ("Car number: " + id + " kilometers: " + _kilometers);
    }
}
