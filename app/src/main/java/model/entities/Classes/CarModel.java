package model.entities.Classes;


import model.entities.Enums.CarCompany;
import model.entities.Enums.GearboxKind;
import model.entities.Enums.Color;

/**
 * Created by shlomo on 05-Nov-17.
 */

public class CarModel {
    private int id; //code of car model
    private CarCompany _carComp;
    private String _carModel;
    private int _carYear;
    private int _numberOfDoors;
    private int _engineVolume;
    private GearboxKind GEARBOX;
    private boolean _airConditioning;
    private Color _modelColor;
    private int _passengers;
    private int _maxWeight;
    private double _priceForOneHour;

    public boolean is_airConditioning() {
        return _airConditioning;
    }
    public void set_airConditioning(boolean _airConditioning) {
        this._airConditioning = _airConditioning;
    }
    public Color get_modelColor() {
        return _modelColor;
    }
    public void set_modelColor(Color _modelColor) {
        this._modelColor = _modelColor;
    }
    public int get_modelCode() {
        return id;
    }
    public void set_modelCode(int _modelCode) {
        this.id = _modelCode;
    }
    public String get_carModel() {
        return _carModel;
    }
    public void set_carModel(String _carModel) {
        this._carModel = _carModel;
    }
    public int get_carYear() {
        return _carYear;
    }
    public void set_carYear(int _carYear) {
        this._carYear = _carYear;
    }
    public int get_numberOfDoors() {
        return _numberOfDoors;
    }
    public void set_numberOfDoors(int _numberOfDoors) {
        this._numberOfDoors = _numberOfDoors;
    }
    public int get_engineVolume() {
        return _engineVolume;
    }
    public void set_engineVolume(int _engineVolume) {
        this._engineVolume = _engineVolume;
    }
    public GearboxKind getGEARBOX() {
        return GEARBOX;
    }
    public void set_GEARBOX(GearboxKind GEARBOX) {
        this.GEARBOX = GEARBOX;
    }
    public int get_passengers() {
        return _passengers;
    }
    public void set_passengers(int _passengers) {
        this._passengers = _passengers;
    }
    public int get_maxWeight() {
        return _maxWeight;
    }
    public void set_maxWeight(int _maxWeight) {
        this._maxWeight = _maxWeight;
    }
    public double get_priceForOneHour() {
        return _priceForOneHour;
    }
    public void set_priceForOneHour(double _priceForOneHour) {
        this._priceForOneHour = _priceForOneHour;
    }
    public CarCompany get_carComp() {
        return _carComp;
    }
    public void set_carComp(CarCompany _carComp) {
        this._carComp = _carComp;
    }

    @Override
    public String toString() {
        return (_carComp.toString() + " model: " + _carModel);
    }
}
