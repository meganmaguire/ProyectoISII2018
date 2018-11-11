/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

/**
 *
 * @author megan
 */
public class FactoryDAO {
    
    public static DAO getDAO(String dao){
        if(dao.equals("bd")){
            return new DAOSQLite();
        }
        else{
            return null;
        }
    }
}
