package model.datasource;


import android.content.ContentValues;

import model.backend.CarsClientsConst;
import model.entities.Classes.Administrator;
import model.entities.Classes.Branch;
import model.entities.Classes.Car;
import model.entities.Classes.CarModel;
import model.entities.Classes.Client;
import model.entities.Classes.Order;
import model.entities.Enums.CarCompany;
import model.entities.Enums.City;
import model.entities.Enums.Color;
import model.entities.Enums.GearboxKind;
import model.entities.Enums.Gender;
import model.entities.Enums.WeekDay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by temp on 11/10/2017.
 */

public class Tools {


    //CONTENT VALUES TO CLASSES
    public static Branch contentValuesToBranch(ContentValues contentValues) throws Exception {
        Branch branch = new Branch();
        branch.set_numOfParking(contentValues.getAsInteger(CarsClientsConst.BranchConst.PARKINGNUMBER));
        branch.set_branchNum(contentValues.getAsInteger(CarsClientsConst.BranchConst.BNUMBER));
        branch.set_phoneNumber(contentValues.getAsString(CarsClientsConst.BranchConst.PHONE));

        int size = contentValues.getAsInteger(CarsClientsConst.BranchConst.OPEN_HOUR_SIZE);
        Branch.OpeningHours openingHours;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        for (int index = 0; index < size; index++) {
                        openingHours = new Branch.OpeningHours();
        openingHours.set_day(WeekDay.valueOf(contentValues.getAsString(CarsClientsConst.BranchConst.OPEN_DAY_WEEK + index)));
        openingHours.set_hourOpen(dateFormat.parse(contentValues.getAsString(CarsClientsConst.BranchConst.OPEN_HOUR_OPEN + index)));
        openingHours.set_hourClose(dateFormat.parse(contentValues.getAsString(CarsClientsConst.BranchConst.OPEN_HOUR_CLOSE + index)));
        branch.add_openingHours(openingHours);
    }
        branch.set_branchAddress(
                City.valueOf(contentValues.getAsString(CarsClientsConst.BranchConst.ADDRESS_CITY)),
            contentValues.getAsString(CarsClientsConst.BranchConst.ADDRESS_STREET_NAME),
            contentValues.getAsInteger(CarsClientsConst.BranchConst.ADDRESS_STREET_NUMBER));

        return branch;
    }
    public static Car contentValuesToCar(ContentValues contentValues) {

        Car car = new Car();
        car.set_branchNumber(contentValues.getAsInteger(CarsClientsConst.CarConst.BRANCH_NUMBER));
        car.set_modelCode(contentValues.getAsInteger(CarsClientsConst.CarConst.CAR_MODEL));
        car.set_kilometers(contentValues.getAsLong(CarsClientsConst.CarConst.KILOMETERS));
        car.set_vehicleNumber(contentValues.getAsInteger(CarsClientsConst.CarConst.VEHICLE_NUMBER));
        return car;
    }
    public static CarModel contentValuesToCarModel(ContentValues contentValues) {

        CarModel carModel = new CarModel();
        carModel.set_modelCode(contentValues.getAsInteger(CarsClientsConst.CarModelConst.MODEL_CODE));
        carModel.set_carModel(contentValues.getAsString(CarsClientsConst.CarModelConst.CAR_MODEL));
        carModel.set_carYear(contentValues.getAsInteger(CarsClientsConst.CarModelConst.CAR_YEAR));
        carModel.set_numberOfDoors(contentValues.getAsInteger(CarsClientsConst.CarModelConst.NUMBER_DOORS));
        carModel.set_engineVolume(contentValues.getAsInteger(CarsClientsConst.CarModelConst.ENGINE_VOLUME));
        carModel.set_carComp(CarCompany.valueOf(contentValues.getAsString(CarsClientsConst.CarModelConst.CAR_COMPANY)));
        carModel.set_GEARBOX(GearboxKind.valueOf(contentValues.getAsString(CarsClientsConst.CarModelConst.GEARBOX)));
        carModel.set_modelColor(Color.valueOf(contentValues.getAsString(CarsClientsConst.CarModelConst.MODEL_COLOR)));
        carModel.set_passengers(contentValues.getAsInteger(CarsClientsConst.CarModelConst.NUMBER_SEATS));
        carModel.set_maxWeight(contentValues.getAsInteger(CarsClientsConst.CarModelConst.MAX_WEIGHT));
        carModel.set_priceForOneHour(contentValues.getAsDouble(CarsClientsConst.CarModelConst.PRICE));
        carModel.set_airConditioning(contentValues.getAsBoolean(CarsClientsConst.CarModelConst.AIR_CONDITIONING));
        return carModel;
    }
    public static Client contentValuesToClient(ContentValues contentValues) throws Exception {

        Client client = new Client();
        client.set_Gender(Gender.valueOf(contentValues.getAsString(CarsClientsConst.ClientConst.GENDER)));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        client.set_birthDay(dateFormat.parse(contentValues.getAsString(CarsClientsConst.ClientConst.BIRTHDAY)));
        client.set_firstName(contentValues.getAsString(CarsClientsConst.ClientConst.FIRSTNAME));
        client.set_lastName(contentValues.getAsString(CarsClientsConst.ClientConst.LASTNAME));
        client.set_password(contentValues.getAsInteger(CarsClientsConst.ClientConst.PASSWORD));
        client.set_id(contentValues.getAsLong(CarsClientsConst.ClientConst.ID));
        client.set_phoneNumber(contentValues.getAsString(CarsClientsConst.ClientConst.PHONE));
        client.set_eMailAddress(contentValues.getAsString(CarsClientsConst.ClientConst.EMAIL));
        client.set_creditNumber(contentValues.getAsString(CarsClientsConst.ClientConst.CREDIT_NUMBER));
        client.set_customerNumber(contentValues.getAsLong(CarsClientsConst.ClientConst.CUSTOMER_NUMBER));
        return client;
    }
    public static Order contentValuesToOrder(ContentValues contentValues) throws Exception {

        Order order = new Order();
        order.set_customerNumber(contentValues.getAsInteger(CarsClientsConst.OrderConst.CASTOMER_NUMBER));
        order.set_openOrder(contentValues.getAsBoolean(CarsClientsConst.OrderConst.OPEN_ORDER));
        order.set_carNumber(contentValues.getAsInteger(CarsClientsConst.OrderConst.CAR_NUMBER));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        order.set_rentalStart(dateFormat.parse(contentValues.getAsString(CarsClientsConst.OrderConst.RENTAL_START)));
        order.set_rentalEnd(dateFormat.parse(contentValues.getAsString(CarsClientsConst.OrderConst.RENTAL_END)));
        order.set_kilometerStart(contentValues.getAsInteger(CarsClientsConst.OrderConst.KILOMETER_START));
        order.set_kilometerEnd(contentValues.getAsInteger(CarsClientsConst.OrderConst.KILOMETER_END));
        order.set_fuelFilledSum(contentValues.getAsInteger(CarsClientsConst.OrderConst.FUEL_FILLED_SUM));
        order.set_orderNumber(contentValues.getAsLong(CarsClientsConst.OrderConst.ORDER_NUMBER));
        return order;
    }
    public static Administrator contentValuesToAdmin(ContentValues contentValues) throws Exception {
        Administrator administrator= new Administrator();
        administrator.set_username(contentValues.getAsString(CarsClientsConst.AdministratorConst.USER_NAME));
        administrator.set_password(contentValues.getAsString(CarsClientsConst.AdministratorConst.PASSWORD));

         return administrator;
    }

    //CONTENT VALUES TO LISTS
    public static List<Car> contentValuesToCarList(ContentValues contentValues) {
        List<Car> carArrayList = new ArrayList<>();

        Car car;
        for (int i = 0; i < contentValues.getAsInteger(CarsClientsConst.CarConst.LIST_SIZE);i++) {
            car = new Car();
            car.set_branchNumber(contentValues.getAsInteger(CarsClientsConst.CarConst.BRANCH_NUMBER + i));
            car.set_modelCode(contentValues.getAsInteger(CarsClientsConst.CarConst.CAR_MODEL + i));
            car.set_kilometers(contentValues.getAsLong(CarsClientsConst.CarConst.KILOMETERS + i));
            car.set_vehicleNumber(contentValues.getAsInteger(CarsClientsConst.CarConst.VEHICLE_NUMBER + i));
            carArrayList.add(car);
        }
        return carArrayList;
    }
    public static List<Branch> contentValuesToBranchList(ContentValues contentValues) throws Exception {
        List<Branch> branchArrayList = new ArrayList<>();
        Branch branch;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        for (int i = 0; i < contentValues.getAsInteger(CarsClientsConst.BranchConst.LIST_SIZE); i++) {
            branch = new Branch();
            branch.set_numOfParking(contentValues.getAsInteger(CarsClientsConst.BranchConst.PARKINGNUMBER +i));
            branch.set_branchNum(contentValues.getAsInteger(CarsClientsConst.BranchConst.BNUMBER +i));
            branch.set_phoneNumber(contentValues.getAsString(CarsClientsConst.BranchConst.PHONE +i));

            int size = contentValues.getAsInteger(CarsClientsConst.BranchConst.OPEN_HOUR_SIZE +i);
            Branch.OpeningHours openingHours;
            for (int index = 0; index < size; index++) {
                openingHours = new Branch.OpeningHours();
                openingHours.set_day(WeekDay.valueOf(contentValues.getAsString(CarsClientsConst.BranchConst.OPEN_DAY_WEEK + index + "_" + i)));
                openingHours.set_hourOpen(dateFormat.parse(contentValues.getAsString(CarsClientsConst.BranchConst.OPEN_HOUR_OPEN + index + "_" + i)));
                openingHours.set_hourClose(dateFormat.parse(contentValues.getAsString(CarsClientsConst.BranchConst.OPEN_HOUR_CLOSE + index + "_" + i)));
                branch.add_openingHours(openingHours);
            }
            branch.set_branchAddress(
                    City.valueOf(contentValues.getAsString(CarsClientsConst.BranchConst.ADDRESS_CITY +i)),
                    contentValues.getAsString(CarsClientsConst.BranchConst.ADDRESS_STREET_NAME +i),
                    contentValues.getAsInteger(CarsClientsConst.BranchConst.ADDRESS_STREET_NUMBER +i));

            branchArrayList.add(branch);
        }
        return branchArrayList;
    }
    public static List<CarModel> contentValuesToCarModelList(ContentValues contentValues) {
        List<CarModel> carModelArrayList = new ArrayList<>();

        for (int i = 0; i < contentValues.getAsInteger(CarsClientsConst.CarModelConst.LIST_SIZE); i++) {
            CarModel carModel = new CarModel();
            carModel.set_modelCode(contentValues.getAsInteger(CarsClientsConst.CarModelConst.MODEL_CODE + i));
            carModel.set_carModel(contentValues.getAsString(CarsClientsConst.CarModelConst.CAR_MODEL + i));
            carModel.set_carYear(contentValues.getAsInteger(CarsClientsConst.CarModelConst.CAR_YEAR + i));
            carModel.set_numberOfDoors(contentValues.getAsInteger(CarsClientsConst.CarModelConst.NUMBER_DOORS + i));
            carModel.set_engineVolume(contentValues.getAsInteger(CarsClientsConst.CarModelConst.ENGINE_VOLUME + i));
            carModel.set_airConditioning(contentValues.getAsBoolean(CarsClientsConst.CarModelConst.AIR_CONDITIONING + i));
            carModel.set_carComp(CarCompany.valueOf(contentValues.getAsString(CarsClientsConst.CarModelConst.CAR_COMPANY +i)));
            carModel.set_GEARBOX(GearboxKind.valueOf(contentValues.getAsString(CarsClientsConst.CarModelConst.GEARBOX + i)));
            carModel.set_modelColor(Color.valueOf(contentValues.getAsString(CarsClientsConst.CarModelConst.MODEL_COLOR+i)));
            carModel.set_passengers(contentValues.getAsInteger(CarsClientsConst.CarModelConst.NUMBER_SEATS + i));
            carModel.set_maxWeight(contentValues.getAsInteger(CarsClientsConst.CarModelConst.MAX_WEIGHT + i));
            carModel.set_priceForOneHour(contentValues.getAsDouble(CarsClientsConst.CarModelConst.PRICE + i));
            carModelArrayList.add(carModel);
        }
        return carModelArrayList;
    }
    public static List<Client> contentValuesToClientList(ContentValues contentValues) throws Exception {
        List<Client> clientArrayList = new ArrayList<>();
        Client client;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < contentValues.getAsInteger(CarsClientsConst.ClientConst.LIST_SIZE); i++) {
            client = new Client();
            client.set_Gender(Gender.valueOf(contentValues.getAsString(CarsClientsConst.ClientConst.GENDER + i)));
            client.set_birthDay(dateFormat.parse(contentValues.getAsString(CarsClientsConst.ClientConst.BIRTHDAY + i)));
            client.set_firstName(contentValues.getAsString(CarsClientsConst.ClientConst.FIRSTNAME + i));
            client.set_lastName(contentValues.getAsString(CarsClientsConst.ClientConst.LASTNAME + i));
            client.set_id(contentValues.getAsLong(CarsClientsConst.ClientConst.ID + i));
            client.set_password(contentValues.getAsInteger(CarsClientsConst.ClientConst.PASSWORD));
            client.set_phoneNumber(contentValues.getAsString(CarsClientsConst.ClientConst.PHONE + i));
            client.set_eMailAddress(contentValues.getAsString(CarsClientsConst.ClientConst.EMAIL + i));
            client.set_creditNumber(contentValues.getAsString(CarsClientsConst.ClientConst.CREDIT_NUMBER + i));
            client.set_customerNumber(contentValues.getAsLong(CarsClientsConst.ClientConst.CUSTOMER_NUMBER + i));
            clientArrayList.add(client);
        }
        return clientArrayList;

    }
    public static List<Order> contentValuesToOrderList(ContentValues contentValues) throws Exception {
        List<Order> orderArrayList = new ArrayList<>();
        Order order;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for (int i = 0; i < contentValues.getAsInteger(CarsClientsConst.OrderConst.LIST_SIZE); i++) {
            order = new Order();
            order.set_customerNumber(contentValues.getAsInteger(CarsClientsConst.OrderConst.CASTOMER_NUMBER + i));
            order.set_openOrder(contentValues.getAsBoolean(CarsClientsConst.OrderConst.OPEN_ORDER + i));
            order.set_carNumber(contentValues.getAsInteger(CarsClientsConst.OrderConst.CAR_NUMBER + i));
            order.set_rentalStart(dateFormat.parse(contentValues.getAsString(CarsClientsConst.OrderConst.RENTAL_START + i)));
            order.set_rentalEnd(dateFormat.parse(contentValues.getAsString(CarsClientsConst.OrderConst.RENTAL_END + i)));
            order.set_kilometerStart(contentValues.getAsInteger(CarsClientsConst.OrderConst.KILOMETER_START + i));
            order.set_kilometerEnd(contentValues.getAsInteger(CarsClientsConst.OrderConst.KILOMETER_END + i));
            order.set_fuelFilledSum(contentValues.getAsInteger(CarsClientsConst.OrderConst.FUEL_FILLED_SUM + i));
            order.set_orderNumber(contentValues.getAsLong(CarsClientsConst.OrderConst.ORDER_NUMBER + i));
            orderArrayList.add(order);
        }
        return orderArrayList;
    }
    public static List<Administrator> contentValuesToAdminList(ContentValues contentValues) throws Exception {

        List<Administrator> administratorList = new ArrayList<>();

        Administrator administrator;
        for(int index =0; index < contentValues.getAsInteger(CarsClientsConst.AdministratorConst.LIST_SIZE);index++)
        {
            administrator = new Administrator();
            administrator.set_username(contentValues.getAsString(CarsClientsConst.AdministratorConst.USER_NAME+index));
            administrator.set_password(contentValues.getAsString(CarsClientsConst.AdministratorConst.PASSWORD+index));
            administratorList.add(administrator);
        }
        return administratorList;
    }

    //CLASSES TO CONTENT VALUES
    public static ContentValues branchToContentValues(Branch branch) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(CarsClientsConst.BranchConst.PARKINGNUMBER, branch.get_numOfParking());
        contentValues.put(CarsClientsConst.BranchConst.BNUMBER, branch.get_branchNum());
        contentValues.put(CarsClientsConst.BranchConst.PHONE, branch.get_phoneNumber());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        for (int index = 0; index < branch.get_openingHours().size(); index++) {
            contentValues.put(CarsClientsConst.BranchConst.OPEN_DAY_WEEK + index, branch.get_openingHours().get(index).get_day().toString());
            contentValues.put(CarsClientsConst.BranchConst.OPEN_HOUR_OPEN + index, dateFormat.format(branch.get_openingHours().get(index).get_hourOpen()));
            contentValues.put(CarsClientsConst.BranchConst.OPEN_HOUR_CLOSE + index, dateFormat.format(branch.get_openingHours().get(index).get_hourClose()));
        }
        contentValues.put(CarsClientsConst.BranchConst.OPEN_HOUR_SIZE, branch.get_openingHours().size());

        contentValues.put(CarsClientsConst.BranchConst.ADDRESS_CITY, branch.get_branchAddress().get_city().toString());
        contentValues.put(CarsClientsConst.BranchConst.ADDRESS_STREET_NAME, branch.get_branchAddress().get_street());
        contentValues.put(CarsClientsConst.BranchConst.ADDRESS_STREET_NUMBER, branch.get_branchAddress().get_streetNumber());


        return contentValues;
    }
    public static ContentValues carToContentValues(Car car) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsClientsConst.CarConst.BRANCH_NUMBER, car.get_branchNumber());
        contentValues.put(CarsClientsConst.CarConst.CAR_MODEL, car.get_modelCode());
        contentValues.put(CarsClientsConst.CarConst.KILOMETERS, car.get_kilometers());
        contentValues.put(CarsClientsConst.CarConst.VEHICLE_NUMBER, car.get_vehicleNumber());

        return contentValues;
    }
    public static ContentValues carModelToContentValues(CarModel carModel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsClientsConst.CarModelConst.MODEL_CODE, carModel.get_modelCode());
        contentValues.put(CarsClientsConst.CarModelConst.CAR_COMPANY, carModel.get_carComp().toString());
        contentValues.put(CarsClientsConst.CarModelConst.CAR_MODEL, carModel.get_carModel());
        contentValues.put(CarsClientsConst.CarModelConst.CAR_YEAR, carModel.get_carYear());
        contentValues.put(CarsClientsConst.CarModelConst.AIR_CONDITIONING, carModel.is_airConditioning());
        contentValues.put(CarsClientsConst.CarModelConst.NUMBER_DOORS, carModel.get_numberOfDoors());
        contentValues.put(CarsClientsConst.CarModelConst.ENGINE_VOLUME, carModel.get_engineVolume());
        contentValues.put(CarsClientsConst.CarModelConst.GEARBOX, carModel.getGEARBOX().toString());
        contentValues.put(CarsClientsConst.CarModelConst.MODEL_COLOR, carModel.get_modelColor().toString());
        contentValues.put(CarsClientsConst.CarModelConst.NUMBER_SEATS, carModel.get_passengers());
        contentValues.put(CarsClientsConst.CarModelConst.MAX_WEIGHT, carModel.get_maxWeight());
        contentValues.put(CarsClientsConst.CarModelConst.PRICE, carModel.get_priceForOneHour());
        return contentValues;

    }
    public static ContentValues clientToContentValues(Client client) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsClientsConst.ClientConst.GENDER, client.get_Gender().toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        contentValues.put(CarsClientsConst.ClientConst.BIRTHDAY, dateFormat.format(client.get_birthDay()));
        contentValues.put(CarsClientsConst.ClientConst.FIRSTNAME, client.get_firstName());
        contentValues.put(CarsClientsConst.ClientConst.LASTNAME, client.get_lastName());
        contentValues.put(CarsClientsConst.ClientConst.ID, client.get_id());
        contentValues.put(CarsClientsConst.ClientConst.PASSWORD, client.get_password());
        contentValues.put(CarsClientsConst.ClientConst.PHONE, client.get_phoneNumber());
        contentValues.put(CarsClientsConst.ClientConst.EMAIL, client.get_eMailAddress());
        contentValues.put(CarsClientsConst.ClientConst.CREDIT_NUMBER, client.get_creditNumber());
        contentValues.put(CarsClientsConst.ClientConst.CUSTOMER_NUMBER, client.get_customerNumber());

        return contentValues;
    }
    public static ContentValues orderToContentValues(Order order) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsClientsConst.OrderConst.CASTOMER_NUMBER, order.get_customerNumber());
        contentValues.put(CarsClientsConst.OrderConst.OPEN_ORDER, order.get_orderNumber());
        contentValues.put(CarsClientsConst.OrderConst.CAR_NUMBER, order.get_carNumber());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        contentValues.put(CarsClientsConst.OrderConst.RENTAL_START, dateFormat.format(order.get_rentalStart()));
        contentValues.put(CarsClientsConst.OrderConst.RENTAL_END, dateFormat.format(order.get_rentalEnd()));
        contentValues.put(CarsClientsConst.OrderConst.KILOMETER_START, order.get_kilometerStart());
        contentValues.put(CarsClientsConst.OrderConst.KILOMETER_END, order.get_kilometerEnd());
        contentValues.put(CarsClientsConst.OrderConst.FUEL_FILLED_SUM, order.get_fuelFilledSum());
        contentValues.put(CarsClientsConst.OrderConst.ORDER_NUMBER, order.get_orderNumber());

        return contentValues;
    }
    public static ContentValues adminToContentValues(Administrator administrator) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsClientsConst.AdministratorConst.USER_NAME, administrator.get_username());
        contentValues.put(CarsClientsConst.AdministratorConst.PASSWORD, administrator.get_password());
        return contentValues;
    }

    //LISTS TO CONTENT VALUES
    public static ContentValues carListToContentValues(List<Car> carArrayList) {
        ContentValues contentValues = new ContentValues();
        int i;
        for (Car car : carArrayList) {
            i = carArrayList.indexOf(car);
            contentValues.put(CarsClientsConst.CarConst.BRANCH_NUMBER + i, car.get_branchNumber());
            contentValues.put(CarsClientsConst.CarConst.CAR_MODEL + + i, car.get_modelCode());
            contentValues.put(CarsClientsConst.CarConst.KILOMETERS + i, car.get_kilometers());
            contentValues.put(CarsClientsConst.CarConst.VEHICLE_NUMBER + i, car.get_vehicleNumber());
        }
        contentValues.put(CarsClientsConst.CarConst.LIST_SIZE, carArrayList.size());
        return contentValues;
    }
    public static ContentValues branchListToContentValues(List<Branch> branchArrayList) {
        ContentValues contentValues = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        contentValues.put(CarsClientsConst.BranchConst.LIST_SIZE, branchArrayList.size());
        int i;
        for (Branch branch : branchArrayList) {
            i = branchArrayList.indexOf(branch);
            contentValues.put(CarsClientsConst.BranchConst.PARKINGNUMBER + i, branch.get_numOfParking());
            contentValues.put(CarsClientsConst.BranchConst.BNUMBER + i, branch.get_branchNum());
            contentValues.put(CarsClientsConst.BranchConst.PHONE + i, branch.get_phoneNumber());
            int index = 0;
            for (Branch.OpeningHours item : branch.get_openingHours()) {
                contentValues.put(CarsClientsConst.BranchConst.OPEN_DAY_WEEK + index + "_" + i, item.get_day().toString());
                contentValues.put(CarsClientsConst.BranchConst.OPEN_HOUR_OPEN + index + "_" + i, dateFormat.format(item.get_hourOpen()));
                contentValues.put(CarsClientsConst.BranchConst.OPEN_HOUR_CLOSE + index + "_" + i, dateFormat.format(item.get_hourClose()));
                index++;
            }
            contentValues.put(CarsClientsConst.BranchConst.OPEN_HOUR_SIZE + i, index);
            contentValues.put(CarsClientsConst.BranchConst.ADDRESS_CITY + i, branch.get_branchAddress().get_city().toString());
            contentValues.put(CarsClientsConst.BranchConst.ADDRESS_STREET_NAME + i, branch.get_branchAddress().get_street());
            contentValues.put(CarsClientsConst.BranchConst.ADDRESS_STREET_NUMBER + i, branch.get_branchAddress().get_streetNumber());
        }
        return contentValues;
    }
    public static ContentValues carModelListToContentValues(List<CarModel> carModelArrayList) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsClientsConst.CarModelConst.LIST_SIZE, carModelArrayList.size());
        int i;
        for (CarModel carModel : carModelArrayList) {
            i = carModelArrayList.indexOf(carModel);
            contentValues.put(CarsClientsConst.CarModelConst.MODEL_CODE + i, carModel.get_modelCode());
            contentValues.put(CarsClientsConst.CarModelConst.CAR_MODEL + i, carModel.get_carModel());
            contentValues.put(CarsClientsConst.CarModelConst.CAR_YEAR + i, carModel.get_carYear());
            contentValues.put(CarsClientsConst.CarModelConst.NUMBER_DOORS + i, carModel.get_numberOfDoors());
            contentValues.put(CarsClientsConst.CarModelConst.ENGINE_VOLUME + i, carModel.get_engineVolume());
            contentValues.put(CarsClientsConst.CarModelConst.GEARBOX + i, carModel.getGEARBOX().toString());
            contentValues.put(CarsClientsConst.CarModelConst.MODEL_COLOR + i, carModel.get_modelColor().toString());
            contentValues.put(CarsClientsConst.CarModelConst.CAR_COMPANY + i, carModel.get_carComp().toString());
            contentValues.put(CarsClientsConst.CarModelConst.NUMBER_SEATS + i, carModel.get_passengers());
            contentValues.put(CarsClientsConst.CarModelConst.MAX_WEIGHT + i, carModel.get_maxWeight());
            contentValues.put(CarsClientsConst.CarModelConst.PRICE + i, carModel.get_priceForOneHour());
            contentValues.put(CarsClientsConst.CarModelConst.AIR_CONDITIONING + i, carModel.is_airConditioning());
        }
        return contentValues;

    }
    public static ContentValues clientListToContentValues(List<Client> clientArrayList) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsClientsConst.ClientConst.LIST_SIZE, clientArrayList.size());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int i;
        for (Client client : clientArrayList) {
            i = clientArrayList.indexOf(client);
            contentValues.put(CarsClientsConst.ClientConst.GENDER+ i, client.get_Gender().toString());
            contentValues.put(CarsClientsConst.ClientConst.BIRTHDAY+ i, dateFormat.format(client.get_birthDay()));
            contentValues.put(CarsClientsConst.ClientConst.FIRSTNAME+ i, client.get_firstName());
            contentValues.put(CarsClientsConst.ClientConst.LASTNAME+ i, client.get_lastName());
            contentValues.put(CarsClientsConst.ClientConst.ID+ i, client.get_id());
            contentValues.put(CarsClientsConst.ClientConst.PASSWORD + i, client.get_password());
            contentValues.put(CarsClientsConst.ClientConst.PHONE+ i, client.get_phoneNumber());
            contentValues.put(CarsClientsConst.ClientConst.EMAIL+ i, client.get_eMailAddress());
            contentValues.put(CarsClientsConst.ClientConst.CREDIT_NUMBER+ i, client.get_creditNumber());
            contentValues.put(CarsClientsConst.ClientConst.CUSTOMER_NUMBER+ i, client.get_customerNumber());
        }
        return contentValues;
    }
    public static ContentValues orderListToContentValues(List<Order> orderArrayList) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarsClientsConst.OrderConst.LIST_SIZE, orderArrayList.size());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        int i;
        for (Order order : orderArrayList) {
            i = orderArrayList.indexOf(order);
            contentValues.put(CarsClientsConst.OrderConst.CASTOMER_NUMBER + i, order.get_customerNumber());
            contentValues.put(CarsClientsConst.OrderConst.OPEN_ORDER + i, order.get_orderNumber());
            contentValues.put(CarsClientsConst.OrderConst.CAR_NUMBER + i, order.get_carNumber());
            contentValues.put(CarsClientsConst.OrderConst.RENTAL_START + i, dateFormat.format(order.get_rentalStart()));
            contentValues.put(CarsClientsConst.OrderConst.RENTAL_END + i, dateFormat.format(order.get_rentalEnd()));
            contentValues.put(CarsClientsConst.OrderConst.KILOMETER_START + i, order.get_kilometerStart());
            contentValues.put(CarsClientsConst.OrderConst.KILOMETER_END + i, order.get_kilometerEnd());
            contentValues.put(CarsClientsConst.OrderConst.FUEL_FILLED_SUM + i, order.get_fuelFilledSum());
            contentValues.put(CarsClientsConst.OrderConst.ORDER_NUMBER + i, order.get_orderNumber());
        }
        return contentValues;
    }
    public static ContentValues adminListToContentValues(List<Administrator> adminArrayList) {
        ContentValues contentValues=new ContentValues();
        int index=0;
        for(Administrator administrator : adminArrayList)
        {
            index = adminArrayList.indexOf(administrator);
            contentValues.put(CarsClientsConst.AdministratorConst.USER_NAME + index,administrator.get_username());
            contentValues.put(CarsClientsConst.AdministratorConst.PASSWORD + index,administrator.get_password());
        }
        contentValues.put(CarsClientsConst.AdministratorConst.LIST_SIZE,adminArrayList.size());
        return contentValues;
    }
}