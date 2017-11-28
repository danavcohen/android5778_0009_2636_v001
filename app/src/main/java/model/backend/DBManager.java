package model.backend;


import android.content.ContentValues;
import java.text.ParseException;

/**
 * Created by temp on 11/10/2017.
 */

public interface DBManager {

    boolean ifIsValid(Object o , Class<?> c) throws ParseException, Exception;

    //Add methods
    boolean addNewClient(ContentValues client) throws Exception;
    boolean addNewCar(ContentValues car) throws Exception;
    boolean addNewCarModel(ContentValues carModel) throws Exception;
    boolean addNewBranch(ContentValues branch) throws Exception;
    boolean addNewOrder(ContentValues order) throws Exception;
    boolean addNewAdministrator(ContentValues admin) throws Exception;

    //Update methods
    boolean updateClient(ContentValues client) throws Exception;
    boolean updateCar(ContentValues car) throws Exception;
    boolean updateCarModel(ContentValues carModel) throws Exception;
    boolean updateOrder(ContentValues order) throws Exception;
    boolean updateBranch(ContentValues branch) throws Exception;
    boolean updateAdministrator(ContentValues admin) throws Exception;

    //Remove methods
    boolean removeCarModel(ContentValues carModel) throws Exception;
    boolean removeBranch(ContentValues branch) throws Exception;
    boolean removeCar(ContentValues car) throws Exception;
    boolean removeClient(ContentValues client) throws Exception;
    boolean removeOrder(ContentValues order) throws Exception;
    boolean removeAdministrator(ContentValues admin) throws Exception;

    ContentValues getCar(int id) throws Exception;
    ContentValues getCarModel(int id) throws Exception;
    ContentValues getBranch(int id) throws Exception;
    ContentValues getOrder(long id) throws Exception;
    ContentValues getClient(long id) throws Exception;
    ContentValues getAdmin(String username) throws Exception;

    ContentValues getCAR_MODELS() throws Exception;
    ContentValues getCLIENTS() throws Exception;
    ContentValues getORDERS() throws Exception;
    ContentValues getBRANCHES() throws Exception;
    ContentValues getCARS() throws Exception;
    ContentValues getADMINS() throws Exception;
}
