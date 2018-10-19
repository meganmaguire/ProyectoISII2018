/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import java.util.List;

/**
 *
 * @author Maru
 */
public interface DAO {
    //reads
    //public List readeUsuarios();
    public List readVentas();
    public List readCompras();
    public List readIndustriales();
    public List readArtesanal();
    public List readTragos();
    public List readNarguiles();
    public List readGaseosas();
    public List readVinos();
    public List readPizzas();
    public List readPicadas();
    
    //creates
    //public boolean createUsuario(Usuario usuario);
    public boolean createVenta(Venta venta);
    //public boolean createCompra(Compra compra);
    //public boolean createIndustriales(Industrial industrial);
    //public boolean createArtesanalas(Artesanal artesanal);
    //public boolean createTragos(Trago trago);
    //public boolea createNarguile(Narguile narguile);
    //public boolean createGaseosa(Gaseosa gaseosa);
    //public boolean createVino(Vino vino);
    //public boolean createPizza(Pizza pizza);
    //public boolean createPicada(Picada picada);
    
    //updates
    //public void upDateUsuario(Usuario usuario);
    //public void upDateVenta(Venta venta);
    //public void upDateCompra(Compra compra);
    //public void upDateIndustriales(Industrial industrial);
    //public void upDateArtesanalas(Artesanal artesanal);
    //public void upDateTragos(Trago trago);
    //public void upDateNarguile(Narguile narguile);
    //public void upDateGaseosa(Gaseosa gaseosa);
    //public void upDateVino(Vino vino);
    //public void upDatePizza(Pizza pizza);
    //public void upDatePicada(Picada picada);
    
    //deletes
    //public boolean deleteUsuario(Usuario usuario);
    //public boolean deleteVenta(Venta venta);
    //public boolean deleteCompra(Compra compra);
    //public boolean deleteIndustriales(Industrial industrial);
    //public boolean deleteArtesanalas(Artesanal artesanal);
    //public boolean deleteTragos(Trago trago);
    //public boolean deleteNarguile(Narguile narguile);
    //public boolean deleteGaseosa(Gaseosa gaseosa);
    //public boolean deleteVino(Vino vino);
    //public boolean deletePizza(Pizza pizza);
    //public boolean deletePicada(Picada picada);
    
}
