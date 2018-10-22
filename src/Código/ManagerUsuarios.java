/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Maru
 */
public class ManagerUsuarios {
    DAOSQLite dao;
    
    public ManagerUsuarios(){
        dao= new DAOSQLite();
    }
}
