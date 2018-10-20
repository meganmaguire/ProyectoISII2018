/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Maru
 */
public class ManagerVentas {
    DAOSQLite dao;
    
    public List balanceVentas(Date fecha1, Date fecha2){
        List <Double> listaBalance=new ArrayList();
        List <Venta> listaVentas= dao.readVentas();
        List <Compra> listaCompras= dao.readCompras();
        double totalVentas=0;
        double totalCompras=0;
        double totalDeTotales=0;
        Iterator i= listaVentas.iterator();
        while(i.hasNext()){
            Venta venta= (Venta) i.next();
            if(venta.getFecha().compareTo(fecha1) >=0 && venta.getFecha().compareTo(fecha2) <=0){
                totalVentas= totalVentas+venta.getPrecioTotal();
            }
        }
        listaBalance.add(totalVentas);
        Iterator j= listaCompras.iterator();
        while(j.hasNext()){
            Compra compra= (Compra) j.next();
            if(compra.getFecha().compareTo(fecha1) >=0 && compra.getFecha().compareTo(fecha2) <=0){
                totalCompras= totalCompras+compra.getPrecioTotal();
            }
        }
        listaBalance.add(totalCompras);
        totalDeTotales=totalVentas-totalCompras;
        listaBalance.add(totalDeTotales);
        return listaBalance;
    }
    
    //Genera una venta, la carga en la base de datos y actualiza el stock
    public void agregarVenta(Venta v){
    }

}
