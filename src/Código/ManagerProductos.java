/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Maru
 */
public class ManagerProductos {
    
    public List verCatálogo(){
        List<Producto> listado = new ArrayList();
        DAOSQLite dao = new DAOSQLite();
        
        listado.addAll(dao.readIndustriales());
        listado.addAll(dao.readArtesanales());
        listado.addAll(dao.readTragos());
        listado.addAll(dao.readNarguiles());
        listado.addAll(dao.readGaseosas());
        listado.addAll(dao.readVinos());
        listado.addAll(dao.readPizzas());
        listado.addAll(dao.readPicadas());
        
        return listado;
    }
    /*public Producto verDetalle(int id,String categoria){
        Producto
        
        return producto;
    }*/
    
   
}
