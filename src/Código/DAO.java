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
    
    //creates
    public boolean createVenta(Venta venta);
    public boolean createRenglon(Renglon renglon);
    
    //updates
    public void updateStockIndustriales(int id,int stock);
    public void updateStockArtesanalas(int id,float stock);
    public void updateStockGaseosa(int id,int stock);
    public void updateStockVino(int id,int stock);
    
    //consultas
    public int consultarStockIndustrial(int idProducto);
    public float consultarStockArtesanal(int idProducto);
    public int consultarStockGaseosas(int idProducto);
    public int consultarStockVinos(int idProducto);
    public float consultarContenidoArtesanal(int idProducto);
}
