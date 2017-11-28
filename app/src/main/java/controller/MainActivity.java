package controller;


import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.shlomo.android5778_0009_2636_v001.R;
import model.backend.DBManager;
import model.backend.DBManager_Factory;
import model.entities.Classes.*;
import model.entities.Enums.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static model.datasource.Tools.*;

public class MainActivity extends Activity {
    private TextView listView;
    DBManager m = DBManager_Factory.getManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TODO: ask Oshri if the UML diagram is ok and if checks need to be in log or is good


        String text = "";
        try {
            // text += "------ CHECKS -------";
            // text += "\n\n*** cars check : ***\n" + carsChecks();
            //text += "\n\n*** orders check : ***\n" + orderChecks();
            //text += "\n\n*** branches check : ***\n" + branchChecks();
           // text += "\n\n*** car models check : ***\n " + carModelChecks();
           // text += "\n\n*** clients check : ***\n" + clientChecks();
            text += "\n\n*** admins check : ***\n" + adminsChecks();


        } catch (Exception e) {
            text += e;
        }

        findViews();
        listView.setMovementMethod(new ScrollingMovementMethod());
        listView.setText(text);
    }

    private String clientChecks() throws Exception {
        String s = "";
        Client client1 = createClient(Gender.FEMALE,"12/01/2017","sd@gmail.com","david","dani",324670009,"0502211530","4580030305621578");
        Client client2 = createClient(Gender.MALE, "10/10/2010", "s2@gr.f","dda","das",324670008, "0502153215","we3w");

        s += "\nADDING CLIENT1 (t): " + m.addNewClient(clientToContentValues(contentValuesToClient(clientToContentValues(client1))));
        s += "\nADDING CLIENT2 (t): " + m.addNewClient(clientToContentValues(contentValuesToClient(clientToContentValues(client2))));
        s += "\n ALL THE CLIENT LIST: \n" + contentValuesToClientList(m.getCLIENTS());
        s += "\n MODIFY CLIENT NAME1: "; client1.set_firstName("123"); m.updateClient(clientToContentValues(client1));
        s += "\n ALL THE CLIENT LIST: \n" + contentValuesToClientList(m.getCLIENTS());
        s+= "\nREMOVE CLIENT2 (t): " + m.removeClient(clientToContentValues(client2));
        s += "\n ALL THE CLIENT LIST: \n" + contentValuesToClientList(m.getCLIENTS());
        s += "\n TRY TO ADD AGAIN CLIENT1 (f): " + m.addNewClient(clientToContentValues(client1));
        s+= "\nREMOVE CLIENT1 (t): " + m.removeClient(clientToContentValues(client1));
        s += "\n ALL THE CLIENT LIST: \n" + contentValuesToClientList(m.getCLIENTS());

        return s;

    }
    private String carModelChecks() throws Exception {
        String s = "";
        CarModel carModel1 = createCarModel(1141,6, CarCompany.MERCEDES_BENZ,"S500",2010, Color.BLACK,true,1500, GearboxKind.ROBOTIC,153,6,120);
        CarModel carModel2 = createCarModel(1142,5, CarCompany.AUDI,"S505",2015, Color.GRAY,false,1505, GearboxKind.AUTOMATIC,154,5,122);

        s += "\nADDING CARMODEL1 (t): " + m.addNewCarModel(carModelToContentValues(contentValuesToCarModel(carModelToContentValues(carModel1))));
        s += "\nADDING CARMODEL2 (t): " + m.addNewCarModel(carModelToContentValues(contentValuesToCarModel(carModelToContentValues(carModel2))));
        s += "\nALL THE CARMODELS :\n" + contentValuesToCarModelList(m.getCAR_MODELS());
        s+= "\nMODIFY THE CARMODEL1 COMPANY :" ; carModel1.set_carComp(CarCompany.AUDI); m.updateCarModel(carModelToContentValues(carModel1));
       // s += "\nALL THE CARMODELS :\n" + contentValuesToCarModelList(m.getCAR_MODELS());
        s += "\nREMOVE CARMODEL2 (t): " + m.removeCarModel(carModelToContentValues(carModel2));
        //s += "\nALL THE CARMODELS :\n" + contentValuesToCarModelList(m.getCAR_MODELS());
        s += "\nTRY TO ADD AGAIN CARMODEL1 (f): " + m.addNewCarModel(carModelToContentValues(carModel1));
        s += "\nREMOVE CARMODEL1 (t): " + m.removeCarModel(carModelToContentValues(carModel1));
       // s += "\nALL THE CARMODELS :\n" + contentValuesToCarModelList(m.getCAR_MODELS());

        return s;
    }
    private String branchChecks() throws Exception {
        String s = "";
        Branch branch1 = createBranch(121, City.JERUSALEM,"shoshana",13,"0502211530",10,"08:00","18:00", WeekDay.SATURDAY,"06:00","15:00", WeekDay.THURSDAY);
        Branch branch2 = createBranch(122, City.ASHKELON,"shoshanI",14,"0502211531",11,"08:01","18:01", WeekDay.SUNDAY,"06:01","15:01", WeekDay.FRIDAY);

        s += "\nADDING BRANCH1 (t): " + m.addNewBranch(branchToContentValues(branch1));
        s += "\nADDING BRANCH2 (t): " + m.addNewBranch(branchToContentValues(branch2));
        s += "\nALL THE BRANCHES :\n" + contentValuesToBranchList(m.getBRANCHES());
        s+= "\nMODIFY THE BRANCH1 City :" ; branch1.get_branchAddress().set_city(City.HAIFA);
        m.updateBranch(branchToContentValues(branch1));
        s += "\nALL THE BRANCHES :\n" + contentValuesToBranchList(m.getBRANCHES());
        s += "\nREMOVE BRANCH2 (t): " + m.removeBranch(branchToContentValues(branch2));
        s += "\nALL THE BRANCHES :\n" + contentValuesToBranchList(m.getBRANCHES());
        s += "\nTRY TO ADD AGAIN BRANCH1 (f): " + m.addNewBranch(branchToContentValues(branch1));
        s += "\nREMOVE BRANCH1 (t): " + m.removeBranch(branchToContentValues(branch1));
        s += "\nALL THE BRANCHES :" + contentValuesToBranchList(m.getBRANCHES());
        return s;
    }
    private String orderChecks() throws Exception {
        String s = "";
        Order order1 = createOrder(1000,1505658,false,"10/10/2017 10:00","12/10/2017 15:00",345,100000,120000);
        Order order2 = createOrder(2000,2565485,true,"05/05/2017 15:00","06/06/2017 16:00",1500,23000,24000);
        Order order3 = createOrder(3000,3565485,true,"04/05/2017 17:01","08/06/2017 16:01",1400,13000,24600);

        s += "\nADDING ORDER1 (t): " + m.addNewOrder(orderToContentValues(contentValuesToOrder(orderToContentValues(order1))));
        s += "\nADDING ORDER2 (t): " + m.addNewOrder(orderToContentValues(contentValuesToOrder(orderToContentValues(order2))));
        s += "\nADDING ORDER3 (t): " + m.addNewOrder(orderToContentValues(contentValuesToOrder(orderToContentValues(order3))));
        s += "\nALL THE ORDERS :\n" + contentValuesToOrderList(m.getORDERS());

        s+= "\n\nMODIFY THE ORDER1 FUEL SUM TO ZERO : " ; order1.set_fuelFilledSum(0); m.updateOrder(orderToContentValues(order1));
        s += "\nCHECK IF FUEL FILLED PASSED TO FALSE (f): " + contentValuesToOrder(m.getOrder(order1.get_orderNumber())).is_fuelFilled();
        s += "\nALL THE ORDERS :\n" + contentValuesToOrderList(m.getORDERS());

        s += "\n\nTRY TO ADD AGAIN ORDER1 (f): " + m.addNewOrder(orderToContentValues(contentValuesToOrder(orderToContentValues(order1))));
        s += "\nREMOVE ORDER1 (t): " + m.removeOrder(orderToContentValues(order1));
        s += "\nALL THE ORDERS :\n" + contentValuesToOrderList(m.getORDERS());

        s += "\n\nTRY TO ADD AGAIN ORDER2 (f): " + m.addNewOrder(orderToContentValues(contentValuesToOrder(orderToContentValues(order2))));
        s += "\nTRY TO ADD AGAIN ORDER1 (t): " + m.addNewOrder(orderToContentValues(contentValuesToOrder(orderToContentValues(order1))));
        s += "\nALL THE ORDERS :\n" + contentValuesToOrderList(m.getORDERS());

        s += "\n\nREMOVE ORDER1 (t): " + m.removeOrder(orderToContentValues(order1));
        s += "\nREMOVE ORDER2 (t): " + m.removeOrder(orderToContentValues(order2));
        s += "\nREMOVE ORDER3 (t): " + m.removeOrder(orderToContentValues(order3));
        s += "\nALL THE ORDERS :\n" + contentValuesToOrderList(m.getORDERS());
        return s;
    }
    private String carsChecks() throws Exception {
        String s = "";
        Car car1 = createCar(7505658,121,40000,1141);
        Car car2 = createCar(4565485,121,50000,2564);

        s += "\nADDING CAR1 (t): " + m.addNewCar(carToContentValues(contentValuesToCar(carToContentValues(car1))));
        s += "\nADDING CAR2 (t): " + m.addNewCar(carToContentValues(contentValuesToCar(carToContentValues(car2))));
        s += "\nALL THE CARS :\n" + contentValuesToCarList(m.getCARS());
        //s+= "\nMODIFY THE CAR1 Color : " ; car1.set_vehicleColor("YELL"); m.updateCar(carToContentValues(car1));
        s += "\nALL THE CARS :\n" + contentValuesToCarList(m.getCARS());
        s += "\nREMOVE CAR2 (t): " + m.removeCar(carToContentValues(car2));
        s += "\nALL THE CARS :\n" + contentValuesToCarList(m.getCARS());
        s += "\nTRY TO ADD AGAIN CAR1 (f): " + m.addNewCar(carToContentValues(car1));
        s += "\nREMOVE CAR1 (t): " + m.removeCar(carToContentValues(car1));
        s += "\nALL THE CARS :\n" + contentValuesToCarList(m.getCARS());
        return s;
    }
    private String adminsChecks() throws Exception{

        String string ="";
        Administrator administrator1= createAdmin("shimmon","1245");
        Administrator administrator2= createAdmin("Gili","3333");
        string +=   "\nADDING ADMIN1 (t): " + m.addNewAdministrator(adminToContentValues(contentValuesToAdmin(adminToContentValues(administrator1))));
        string +=   "\nADDING ADMIN2 (t): " + m.addNewAdministrator(adminToContentValues(contentValuesToAdmin(adminToContentValues(administrator2))));
        string += "\nALL THE ADMINS :\n" + contentValuesToAdminList(m.getADMINS());
       string += "\nREMOVE ADMIN2 (t): " + m.removeAdministrator(adminToContentValues(administrator2));
        string +=   "\nADDING ADMIN1 (t): " + m.addNewAdministrator(adminToContentValues(contentValuesToAdmin(adminToContentValues(administrator1))));
       string +=   "\nADDING ADMIN2 (t): " + m.addNewAdministrator(adminToContentValues(contentValuesToAdmin(adminToContentValues(administrator2))));


        return string;
    }

    private Car createCar(int _id , int _branchNum, long _KM, int _mCode) {
        Car car = new Car();
        car.set_vehicleNumber(_id);
        car.set_branchNumber(_branchNum);
        car.set_kilometers(_KM);
        car.set_modelCode(_mCode);
        return car;
    }
    private Branch createBranch(int _id , City _city, String _street, int _numStreet, String _phone, int _parknum, String _hourO1, String _hourC1, WeekDay _week1, String _hourO2, String _hourC2, WeekDay _week2) {
        Branch branch = new Branch();
        branch.set_branchAddress(_city , _street , _numStreet);
        branch.set_phoneNumber(_phone);
        branch.set_branchNum(_id);
        branch.set_numOfParking(_parknum);
        Branch.OpeningHours openingHours;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try {
            openingHours = new Branch.OpeningHours();
            openingHours.set_hourOpen(dateFormat.parse(_hourO1));
            openingHours.set_hourClose(dateFormat.parse(_hourC1));
            openingHours.set_day(_week1);
            branch.add_openingHours(openingHours);
            openingHours = new Branch.OpeningHours();
            openingHours.set_hourOpen(dateFormat.parse(_hourO2));
            openingHours.set_hourClose(dateFormat.parse(_hourC2));
            openingHours.set_day(_week2);
            branch.add_openingHours(openingHours);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return branch;
    }
    private CarModel createCarModel(int _id , int _doorNum, CarCompany _carComp, String _carModel, int _carYear, Color color, boolean _airConditioning,
                                    int _engineVolume, GearboxKind _gearbox, int _maxWeight, int _numSeet, double _price) {
        CarModel carModel = new CarModel();
        carModel.set_modelCode(_id);
        carModel.set_carComp(_carComp);
        carModel.set_carModel(_carModel);
        carModel.set_carYear(_carYear);
        carModel.set_numberOfDoors(_doorNum);
        carModel.set_engineVolume(_engineVolume);
        carModel.set_GEARBOX(_gearbox);
        carModel.set_airConditioning(_airConditioning);
        carModel.set_modelColor(color);
        carModel.set_passengers(_numSeet);
        carModel.set_maxWeight(_maxWeight);
        carModel.set_priceForOneHour(_price);
        return carModel;
    }
    private Client createClient(Gender _gender, String _birthday, String _email, String _first, String _last, int _id, String _phone, String _CreditNum) {
        Client client = new Client();
        client.set_Gender(_gender);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            client.set_birthDay(dateFormat.parse(_birthday));
        } catch (ParseException e) {
        }
        client.set_customerNumber();
        client.set_eMailAddress(_email);
        client.set_firstName(_first);
        client.set_lastName(_last);
        client.set_id(_id);
        client.set_phoneNumber(_phone);
        client.set_creditNumber(_CreditNum);
        return client;
    }
    private Order createOrder(int _custom, int _carNum, boolean _isOpen, String _start, String _end, int _sumfilled, long _kiloStart, long _kiloEnd) {
        Order order = new Order();
        order.set_orderNumber();
        order.set_customerNumber(_custom);
        order.set_carNumber(_carNum);
        order.set_openOrder(_isOpen);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            order.set_rentalStart(dateFormat.parse(_start));
            order.set_rentalEnd(dateFormat.parse(_end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.set_fuelFilledSum(_sumfilled);
        order.set_kilometerEnd(_kiloEnd);
        order.set_kilometerStart(_kiloStart);
        return order;
    }
    private Administrator createAdmin(String username, String password) {

        Administrator administrator = new Administrator();
        administrator.set_username(username);
        administrator.set_password(password);

        return administrator;
    }


    private void findViews() {
        listView = (TextView)findViewById(R.id.list_item);
    }
}