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
    public List readVentas();
    public List readCompras();
    public List readIndustriales();
    public List readArtesanales();
    public List readTragos();
    public List readNarguiles();
    public List readGaseosas();
    public List readVinos();
    public List readPizzas();
    public List readPicadas();
    public List<Renglon> readRenglonesVenta(int idVenta);
    public Producto readProducto(int id);
    public List readBarriles();
    
    //creates
    public boolean createVenta(Venta venta);
    public boolean createRenglonVenta(Renglon renglon);
    public boolean createIndustrial(Industrial ind);
    public boolean createArtesanal(Artesanal art);
    public boolean createVino(Vino vino);
    public boolean createGaseosa(Gaseosa gas);
    public boolean createTrago(Trago trago);
    public boolean createNarguile(Narguile nar);
    public boolean createPizza(Pizza pizza);
    public boolean createPicada(Picada pic);
    
    //updates
    public void updateStockIndustriales(int id,int stock);
    public void updateStockArtesanalas(int id,float stock);
    public void updateStockGaseosa(int id,int stock);
    public void updateStockVino(int id,int stock);
    public boolean updateIndustrial(Industrial ind);
    public boolean updateArtesanal(Artesanal art);
    public boolean updateVino(Vino vino);
    public boolean updateGaseosa(Gaseosa gas);
    public boolean updateTrago(Trago trago);
    public boolean updateNarguile(Narguile nar);
    public boolean updatePizza(Pizza pizza);
    public boolean updatePicada(Picada pic);
    
    //consultas
    public int consultarStockIndustrial(int idProducto);
    public float consultarStockArtesanal(int idProducto);
    public int consultarStockGaseosas(int idProducto);
    public int consultarStockVinos(int idProducto);
    public float consultarContenidoArtesanal(int idProducto);
    public float consultarPrecioProducto(int idProducto);
    public int consultarIdBarril(int idProducto);
}
