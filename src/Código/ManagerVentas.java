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
    List <Venta> listaVentas;
    List <Compra> listaCompras;
    
    //Constructor
    public ManagerVentas(){
        listaVentas=new ArrayList();
        listaCompras=new ArrayList();
    }
    
    //Getters
    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    //Setters
    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    //Metodos para le manejo del manager ventas
    public void cargarVentas(){
        //cargar lista desde la bd
    }
    
    public void cargarCompras(){
        //cargar lista desde la bd
    }
    
    public void balanceVentas(Date fecha1, Date fecha2){
        float totalVentas=0;
        float totalCompras=0;
        float totalDeTotales=0;
        Iterator i= listaVentas.iterator();
        while(i.hasNext()){
            Venta venta= (Venta) i.next();
            if(venta.getFecha().compareTo(fecha1) >=0 && venta.getFecha().compareTo(fecha2) <=0){
                totalVentas= totalVentas+venta.getPrecioTotal();
            }
        }
        Iterator j= listaCompras.iterator();
        while(j.hasNext()){
            Compra compra= (Compra) j.next();
            if(compra.getFecha().compareTo(fecha1) >=0 && compra.getFecha().compareTo(fecha2) <=0){
                totalCompras= totalCompras+compra.getPrecioTotal();
            }
        }
        totalDeTotales=totalVentas-totalCompras;
    }
    
    //Genera una venta, la carga en la base de datos y actualiza el stock
    public void agregarVenta(Venta v){
        Stock stock=null;
        listaVentas.add(v);
        Iterator i=v.getRenglonesDeVenta().iterator();
        while(i.hasNext()){
            Renglon renglon=(Renglon) i.next();
            Producto p=renglon.getProducto();
            if(p.getTipoProducto().equals("gaseosa")){
                Gaseosa g=(Gaseosa) p;
                stock.setStockActual((g.getStock().getStockActual())-renglon.getCantidad());
                stock.setStockMinimo(g.getStock().getStockMinimo());
                g.setStock(stock);
            }
            if(p.getTipoProducto().equals("vino")){
                Vino vino= (Vino) p;
                stock.setStockActual((vino.getStock().getStockActual())-renglon.getCantidad());
                stock.setStockMinimo(vino.getStock().getStockMinimo());
                vino.setStock(stock);
            }
            if(p.getTipoProducto().equals("industrial")){
                Industrial ind=(Industrial) p;
                stock.setStockActual((ind.getStock().getStockActual())-renglon.getCantidad());
                stock.setStockMinimo(ind.getStock().getStockMinimo());
                ind.setStock(stock);
            }   
        }
    }

}
