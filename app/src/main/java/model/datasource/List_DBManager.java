package model.datasource;


import android.content.ContentValues;

import model.backend.DBManager;
import model.entities.Classes.*;

import java.util.ArrayList;
import java.util.List;

import static model.datasource.Tools.*;

/**
 * Created by shlomo on 05-Nov-17.
 */

public class List_DBManager implements DBManager {

    //Lists
    private static List<CarModel> carModels;
    private static List<Client> clients;
    private static List<Branch> branches;
    private static List<Car> cars;
    private static List<Order> orders;
    private static List<Administrator> administrators;

    static {
        carModels = new ArrayList<>();
        clients = new ArrayList<>();
        branches = new ArrayList<>();
        cars = new ArrayList<>();
        orders = new ArrayList<>();
        administrators = new ArrayList<>();
    }

    @Override
    public boolean ifIsValid(Object o , Class<?> _class) throws Exception {
        // if we got the object as content value
        if (o.getClass() == ContentValues.class)
        {
            if (o.getClass() == Client.class)
            {
                return ifIsValid(contentValuesToClient((ContentValues) o), Client.class);
            }
            if (o.getClass() == Car.class) {
                return ifIsValid(contentValuesToCar((ContentValues) o), Car.class);
            }
            if (o.getClass() == CarModel.class) {
                return ifIsValid(contentValuesToCarModel((ContentValues) o), CarModel.class);
            }
            if (o.getClass() == Branch.class) {
                return ifIsValid(contentValuesToBranch((ContentValues) o), Branch.class);
            }
            if (o.getClass() == Order.class) {
                return ifIsValid(contentValuesToOrder((ContentValues) o), Order.class);
            }
            if (o.getClass() == Administrator.class) {
                return ifIsValid(contentValuesToAdmin((ContentValues) o), Administrator.class);
            }
            return false;
        }
        else
            {
            //TODO: ifIsValid methods
            //if we got the object as class
            if (_class == Client.class) {
                return true;
            }
            if (_class == Car.class) {
                return true;
            }
            if (_class == CarModel.class) {
                return true;
            }
            if (_class == Branch.class) {
                return true;
            }
            if (_class == Order.class) {
                return true;
            }
            if (_class == Administrator.class) {
                return true;
            }
        }
        return false;
    }

    private boolean IfIsValid(Object o) throws Exception {return ifIsValid(o , o.getClass());}


    // Add methods
    @Override
    public  boolean addNewClient(ContentValues client) throws Exception {
        Client newClient = contentValuesToClient(client);
        if (!IfIsValid(newClient))
            return false;
        for (Client c : clients) {
            if (c.get_id() == newClient.get_id())
                return false;
        }
        try {
            clients.add(newClient);
            return true;
        } catch (Exception e) {
            throw new Exception("\nError in adding the client " + newClient + " " + e);
        }

    }
    @Override
    public  boolean addNewCar(ContentValues car) throws Exception{
        Car newCar = contentValuesToCar(car);
        if (!IfIsValid(newCar))
            return false;
        for (Car c: cars) {
            if (c.get_vehicleNumber() == newCar.get_vehicleNumber())
                return false;
        }
        try {
            cars.add(newCar);
            return true;
        } catch (Exception e) {
            throw new Exception("\nError in adding the car " + newCar + " " + e);
        }
    }
    @Override
    public  boolean addNewCarModel(ContentValues carModel) throws Exception {
        CarModel newCarModel = contentValuesToCarModel(carModel);
        if (!IfIsValid(newCarModel))
            return false;
        for (CarModel c: carModels) {
            if(c.get_modelCode() == newCarModel.get_modelCode())
                return false;
        }
        try{
            carModels.add(newCarModel);
            return true;
        } catch (Exception e){
            throw new Exception("\nError in adding the car " + newCarModel + " " + e);
        }
    }
    @Override
    public  boolean addNewBranch(ContentValues branch) throws Exception {
        Branch newBranch = contentValuesToBranch(branch);
        if (!IfIsValid(newBranch))
            return false;
        for (Branch b: branches) {
            if(b.get_branchNum() == newBranch.get_branchNum())
                return false;
        }
        try{
            branches.add(newBranch);
            return true;
        } catch (Exception e) {
            throw new Exception("\nError in adding the branch " + newBranch + " " + e);
        }
    }
    @Override
    public  boolean addNewOrder(ContentValues order) throws Exception{
        Order newOrder = contentValuesToOrder(order);
        if(!IfIsValid(newOrder))
            return false;
        for (Order o : orders) {
            if(o.get_orderNumber() == newOrder.get_orderNumber())
                return false;
        }
        try{
            orders.add(newOrder);
            return true;
        } catch (Exception e) {
            throw new Exception("\nError in adding the branch " + newOrder + " " + e);
        }
    }
    @Override
    public boolean addNewAdministrator(ContentValues admin) throws Exception
    {

        Administrator newAdmin = contentValuesToAdmin(admin);
       if(!IfIsValid(newAdmin))
           return false;
       for (Administrator adm: administrators )
       {
           if(adm.get_username() == newAdmin.get_username())
               return false;
       }
       try {
           administrators.add(newAdmin);
          return true;
       }
       catch (Exception e) {
           throw new Exception("\n Error in adding new admin " + newAdmin + " " + e);
       }

    }

    //Update methods
    @Override
    public  boolean updateClient(ContentValues client) throws Exception {
        Client updateClient = contentValuesToClient(client);
        if (!IfIsValid(updateClient))
            return false;

        try {
            for (Client c : clients) {
                if(c.get_id() == updateClient.get_id()) {
                    c.set_Gender(updateClient.get_Gender());
                    c.set_birthDay(updateClient.get_birthDay());
                    c.set_firstName(updateClient.get_firstName());
                    c.set_lastName(updateClient.get_lastName());
                    c.set_phoneNumber(updateClient.get_phoneNumber());
                    c.set_eMailAddress(updateClient.get_eMailAddress());
                    c.set_creditNumber(updateClient.get_creditNumber());
                    c.set_customerNumber(updateClient.get_customerNumber());
                    c.set_password(updateClient.get_password());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new Exception("Error in uploading the client " + updateClient +", please try again. error: " + e);
        }
    }
    @Override
    public  boolean updateCar(ContentValues car) throws Exception {
        Car updateCar = contentValuesToCar(car);
        if(!IfIsValid(updateCar))
            return false;

        try {
            for (Car c: cars) {
                if(c.get_vehicleNumber() == updateCar.get_vehicleNumber()) {
                    c.set_branchNumber(updateCar.get_branchNumber());
                    c.set_modelCode(updateCar.get_modelCode());
                    c.set_kilometers(updateCar.get_kilometers());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new Exception("Error in uploading the car " + updateCar +", please try again. error: " + e);
        }
    }
    @Override
    public  boolean updateCarModel(ContentValues carModel) throws Exception {
        CarModel updateCarModel = contentValuesToCarModel(carModel);
        if (!IfIsValid(updateCarModel))
            return false;

        try {
            for (CarModel c : carModels) {
                if (c.get_modelCode() == updateCarModel.get_modelCode()) {
                    c.set_carComp(updateCarModel.get_carComp());
                    c.set_airConditioning(updateCarModel.is_airConditioning());
                    c.set_carModel(updateCarModel.get_carModel());
                    c.set_carYear(updateCarModel.get_carYear());
                    c.set_numberOfDoors(updateCarModel.get_numberOfDoors());
                    c.set_engineVolume(updateCarModel.get_engineVolume());
                    c.set_GEARBOX(updateCarModel.getGEARBOX());
                    c.set_modelColor(updateCarModel.get_modelColor());
                    c.set_passengers(updateCarModel.get_passengers());
                    c.set_maxWeight(updateCarModel.get_maxWeight());
                    c.set_priceForOneHour(updateCarModel.get_priceForOneHour());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new Exception("Error in uploading the car model " + updateCarModel + ", please try again. error: " + e);
        }
    }
    @Override
    public  boolean updateBranch(ContentValues branch) throws Exception {
        Branch updateBranch = contentValuesToBranch(branch);
        if (!IfIsValid(updateBranch))
            return false;

        try {
            for (Branch b : branches) {
                if (b.get_branchNum() == updateBranch.get_branchNum()) {
                    b.set_numOfParking(updateBranch.get_numOfParking());
                    b.set_phoneNumber(updateBranch.get_phoneNumber());
                    b.set_openingHours(updateBranch.get_openingHours());
                    b.set_branchAddress(updateBranch.get_branchAddress());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new Exception("Error in uploading the branch " + updateBranch + ", please try again. error: " + e);
        }
    }
    @Override
    public boolean updateAdministrator(ContentValues admin) throws Exception {


        Administrator upAdmin = contentValuesToAdmin(admin);
        try{

            if(!IfIsValid(upAdmin))
                return false;
              for(Administrator a : administrators) {
                  if (a.get_username() == upAdmin.get_username()) {
                      a.set_username(upAdmin.get_username());
                      a.set_password(upAdmin.get_password());
                      return true;
                  }
              }
                 return false;
        }
        catch (Exception e)
        {
            throw new Exception("Error in uploading the  " + upAdmin  + ", please try again. error: " + e);
        }

    }
    @Override
    public  boolean updateOrder(ContentValues _order) throws Exception {
        Order updateOrder = contentValuesToOrder(_order);
        if(!IfIsValid(updateOrder))
            return false;
        try {
            for (Order order : orders) {
                if (order.get_orderNumber() == updateOrder.get_orderNumber()) {
                    order.set_rentalStart(updateOrder.get_rentalStart());
                    order.set_carNumber(updateOrder.get_carNumber());
                    order.set_rentalStart(updateOrder.get_rentalStart());
                    order.set_rentalEnd(updateOrder.get_rentalEnd());
                    order.set_kilometerStart(updateOrder.get_kilometerStart());
                    order.set_kilometerEnd(updateOrder.get_kilometerEnd());
                    order.set_fuelFilledSum(updateOrder.get_fuelFilledSum());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new Exception("Error in uploading the  " + updateOrder + ", please try again. error: " + e);
        }
    }

    //Remove methods
    @Override
    public  boolean removeCarModel(ContentValues carModel) throws Exception {
        CarModel toRemove = contentValuesToCarModel(carModel);
        for (CarModel c : carModels) {
            if (c.get_modelCode() == toRemove.get_modelCode()) {
                carModels.remove(c);
                return true;
            }
        }
        return false;
    }
    @Override
    public  boolean removeBranch(ContentValues branch) throws Exception {
        Branch toRemove = contentValuesToBranch(branch);
        for (Branch b: branches) {
            if (b.get_branchNum() == toRemove.get_branchNum()) {
                branches.remove(b);
                return true;
            }
        }
        return false;
    }
    @Override
    public  boolean removeCar(ContentValues car) throws Exception {
        Car toRemove = contentValuesToCar(car);
        for (Car c : cars) {
            if (c.get_vehicleNumber() == toRemove.get_vehicleNumber()) {
                cars.remove(c);
                return true;
            }
        }
        return false;
    }
    @Override
    public  boolean removeClient(ContentValues client) throws Exception {
        Client toRemove = contentValuesToClient(client);
        for (Client c: clients) {
            if(c.get_id() == toRemove.get_id()) {
                clients.remove(c);
                return true;
            }
        }
        return false;
    }
    @Override
    public  boolean removeOrder(ContentValues order) throws Exception {
        Order toRemove = contentValuesToOrder(order);
        for (Order o : orders) {
            if(o.get_orderNumber() == toRemove.get_orderNumber()) {
                orders.remove(o);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean removeAdministrator(ContentValues admin) throws Exception {

        Administrator administratorToRemove = contentValuesToAdmin(admin);
        try
        {
            if(!IfIsValid(administratorToRemove))
                return false;
            for(Administrator a : administrators)
            {
                if(a.get_username() == administratorToRemove.get_username())
                {
                    administrators.remove(a);
                    return true;
                }
            }
            return false;
        }
        catch(Exception e)
        {
            throw new Exception("Error to remove  : " + administratorToRemove + " " + e);
        }
    }

    //Get a member methods
    @Override
    public ContentValues getCar(int id) throws Exception {
        int index = -1;
        for (Car c : cars)
            if (c.get_vehicleNumber() == id)
                index = cars.indexOf(c);
        if(index < 0)
            return null;
        return carToContentValues(cars.get(index));
    }
    @Override
    public ContentValues getCarModel(int id) throws Exception {
        int index = -1;
        for (CarModel c : carModels)
            if (c.get_modelCode() == id)
                index = carModels.indexOf(c);
        if(index < 0)
            return null;
        return carModelToContentValues(carModels.get(index));
    }
    @Override
    public ContentValues getBranch(int id) throws Exception {
        int index = -1;
        for (Branch c : branches)
            if (c.get_branchNum() == id)
                index = branches.indexOf(c);
        if(index < 0)
            return null;
        return branchToContentValues(branches.get(index));
    }
    @Override
    public ContentValues getOrder(long id) throws Exception {
        int index = -1;
        for (Order c : orders)
            if (c.get_orderNumber() == id)
                index = orders.indexOf(c);
        if(index < 0)
            return null;
        return orderToContentValues(orders.get(index));
    }
    @Override
    public ContentValues getClient(long id) throws Exception {
        int index = -1;
        for (Client c : clients)
            if (c.get_id() == id) {
                index = clients.indexOf(c);
                break;
            }
        if(index < 0)
            return null;
        return clientToContentValues(clients.get(index));
    }
    @Override
    public ContentValues getAdmin(String username) throws Exception {
        int index = -1;
        for ( Administrator admin : administrators)
            if(admin.get_username() == username) {
                index = administrators.indexOf(admin);
                break;
            }
        if(index < 0)
            return null;
        return adminToContentValues(administrators.get(index));
    }

    //Get all list methods
    @Override
    public ContentValues

    getCAR_MODELS() throws Exception {

        try {
            return carModelListToContentValues(carModels);
        } catch (Exception e) {
            throw new Exception("Error while loading the list of carModels | Error: " + e);
        }
    }
    @Override
    public ContentValues getCLIENTS() throws Exception {

        try {
            return clientListToContentValues(clients);
        } catch (Exception e) {
            throw new Exception("Error while loading the list of clients | Error: " + e);
        }
    }
    @Override
    public ContentValues getORDERS() throws Exception {

        try {
            return orderListToContentValues(orders);
        } catch (Exception e) {
            throw new Exception("Error while loading the list of orders | Error: " + e);
        }
    }
    @Override
    public ContentValues getBRANCHES() throws Exception {

        try {
            return branchListToContentValues(branches);
        } catch (Exception e) {
            throw new Exception("Error while loading the list of branches | Error: " + e);
        }
    }
    @Override
    public ContentValues getCARS() throws Exception {

        try {
            return carListToContentValues(cars);
        } catch (Exception e) {
            throw new Exception("Error while loading the list of cars | Error: " + e);
        }
    }
    @Override
    public ContentValues getADMINS() throws Exception {
        try {
            return adminListToContentValues(administrators);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
