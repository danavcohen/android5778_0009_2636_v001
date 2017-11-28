package model.backend;

/**
 * Created by temp on 11/10/2017.
 */

public class CarsClientsConst {

    public static final class BranchConst {

        public static final String ADDRESS_CITY ="_city";
        public static final String ADDRESS_STREET_NAME ="_street";
        public static final String ADDRESS_STREET_NUMBER ="_streetNumber";
        public static final String PARKINGNUMBER ="_numOfParking";
        public static final String BNUMBER ="_branchNum";
        public static final String PHONE = "_phoneNumber";
        public static final String OPEN_DAY_WEEK = "_dayOfWeek";
        public static final String  OPEN_HOUR_OPEN ="_hourOpen";
        public static final String  OPEN_HOUR_CLOSE ="_hourClose";
        public static final String  OPEN_HOUR_SIZE ="_listSize";
        public static final String LIST_SIZE ="_listSize";

    }
    public static final class CarConst{
        public static final String BRANCH_NUMBER = "_branchNumber";
        public static final String CAR_MODEL = "_carModel";
        public static final String KILOMETERS ="_kilometers";
        public static final String VEHICLE_NUMBER ="_vehicleNumber";
        public static final String LIST_SIZE ="_listSize";
    }
    public static final class CarModelConst{
        public static final String MODEL_CODE="_modelCode";
        public static final String CAR_COMPANY= "_carCompany";
        public static final String AIR_CONDITIONING = "_airConditioning";
        public static final String CAR_MODEL ="_carModel";
        public static final String CAR_YEAR ="_carYear";
        public static final String NUMBER_DOORS ="_numberOfDoors";
        public static final String ENGINE_VOLUME ="_engineVolume";
        public static final String MODEL_COLOR ="_modelColor";
        public static final String GEARBOX ="GEARBOX";
        public static final String NUMBER_SEATS ="_numOfSeats";
        public static final String MAX_WEIGHT ="_maxWeight";
        public static final String LIST_SIZE ="_listSize";
        public static final String PRICE = "_price";

    }
    public static final class ClientConst{
        public static final String GENDER ="_GENDER";
        public static final String BIRTHDAY ="_birthDay";
        public static final String FIRSTNAME ="_firstName";
        public static final String LASTNAME="_lastName";
        public static final String ID="_id";
        public static final String PHONE ="_phoneNumber";
        public static final String EMAIL ="_eMailAddress";
        public static final String CREDIT_NUMBER ="_creditNumber";
        public static final String LIST_SIZE ="_listSize";
        public static final String CUSTOMER_NUMBER = "_customerNumber";
        public static final String PASSWORD = "_password";
    }
    public static final class OrderConst{
        public static final String CASTOMER_NUMBER ="_creditNumber";
        public static final String OPEN_ORDER ="_openOrder";
        public static final String CAR_NUMBER ="_carNumber";
        public static final String RENTAL_START ="_rentalStart";
        public static final String RENTAL_END ="_rentalEnd";
        public static final String KILOMETER_START ="_kilometerStart";
        public static final String KILOMETER_END ="_kilometerEnd";
        public static final String FUEL_FILLED ="_fuelFilled";
        public static final String FUEL_FILLED_SUM ="_fuelFilledSum";
        public static final String FINAL_BILL ="_finalBillAmount";
        public static final String ORDER_NUMBER ="_orderNumber";
        public static final String LIST_SIZE ="_listSize";

    }
    public static final class AdministratorConst {
        public static final String USER_NAME = "_username";
        public static final String PASSWORD = "_password";
        public static final String LIST_SIZE = "_listSize";
    }
}
