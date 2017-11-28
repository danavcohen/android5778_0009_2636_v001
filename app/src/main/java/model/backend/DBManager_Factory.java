package model.backend;


import model.datasource.List_DBManager;

/**
 * Created by temp on 11/10/2017.
 */

public class DBManager_Factory {



        private static DBManager manager = null;

        public static DBManager getManager() {
            if (manager == null)
                manager = (DBManager) new List_DBManager();
            return manager;
        }
    }

