/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maru
 */
public class DAOSQLite implements DAO{
    
    private Connection conn;
    private Statement stmt;
    
    public List readVentas(){
        List<Venta> listaVentas=new ArrayList();
        Venta venta= new Venta();
        Renglon renglon=new Renglon();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM VENTAS");
            while(resultado.next()){
                venta.setFecha(resultado.getString(1));
                venta.setId(resultado.getInt(2));
                venta.setPrecioTotal(resultado.getFloat(1));
                venta.setUsuario(resultado.getString(4));
                listaVentas.add(venta.clone());
            }
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return listaVentas;
    }

    public List readCompras() {
        List <Compra> listaCompras= new ArrayList();
        Compra compra= new Compra();
        Renglon renglon= new Renglon();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM COMPRAS");
            while(resultado.next()){
                compra.setFecha(resultado.getString(1));
                compra.setId(resultado.getInt(2));
                compra.setPrecioTotal(resultado.getFloat(1));
                compra.setUsuario(resultado.getString(4));
                listaCompras.add(compra.clone());
            } 
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return listaCompras;
    }

    public List readIndustriales() {
        List<Industrial> industriales = new ArrayList();
        Industrial ind = new Industrial();
        Stock stock;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,INDUSTRIALES WHERE PRODUCTOS.Prod_ID = INDUSTRIALES.Prod_ID");
            while(resultado.next()){
                ind.setId(resultado.getInt(1));
                ind.setPrecioVenta(resultado.getFloat(2));
                ind.setNombreProducto(resultado.getString(3));
                ind.setMarca(resultado.getString(6));
                ind.setTipo(resultado.getString(7));
                ind.setPrecioCosto(resultado.getFloat(8));
                ind.setGraduacionAlc(resultado.getFloat(9));
                ind.setContenido(resultado.getFloat(10));
                ind.setOrigen(resultado.getString(11));
                stock = new Stock(resultado.getInt(12),resultado.getInt(13));
                ind.setStock(stock);
                industriales.add(ind.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readIndustriales");
        }
        return industriales;
    }
    
    public Industrial readIndustrial(int id){
        Industrial ind = new Industrial();
        Stock stock;
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
        
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,INDUSTRIALES WHERE PRODUCTOS.Prod_ID = INDUSTRIALES.Prod_ID, PRODUCTOS.Prod_ID="+id);
            
            ind.setId(resultado.getInt(1));
            ind.setPrecioVenta(resultado.getFloat(2));
            ind.setNombreProducto(resultado.getString(3));
            ind.setMarca(resultado.getString(6));
            ind.setTipo(resultado.getString(7));
            ind.setPrecioCosto(resultado.getFloat(8));
            ind.setGraduacionAlc(resultado.getFloat(9));
            ind.setContenido(resultado.getFloat(10));
            ind.setOrigen(resultado.getString(11));
            stock = new Stock(resultado.getInt(12),resultado.getInt(13));
            ind.setStock(stock);
            
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        
        return ind;
        
    }
    
    public List readArtesanales() {
        List<Artesanal> artesanales=new ArrayList();
        Artesanal art = new Artesanal();
        Barril barril;
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
        
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,ARTESANALES,BARRILES WHERE PRODUCTOS.Prod_ID = ARTESANALES.Prod_ID AND ARTESANALES.Bar_ID = BARRILES.Bar_ID");
            while(resultado.next()){
                art.setId(resultado.getInt(1));
                art.setPrecioVenta(resultado.getFloat(2));
                art.setNombreProducto(resultado.getString(3));
                art.setMarca(resultado.getString(6));
                art.setTipo(resultado.getString(7));
                art.setGraduacionAlc(resultado.getFloat(8));
                art.setContenido(resultado.getFloat(9));
                art.setColor(resultado.getString(10));
                art.setLupulo(resultado.getString(11));
                art.setMalta(resultado.getString(12));
                barril = new Barril(resultado.getInt(13),resultado.getFloat(14),resultado.getFloat(15));
                art.setBarril(barril);
                
                artesanales.add(art.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readArtesanales");
        }
        return artesanales;  
    }

    public List readTragos() {
        List<Trago> tragos=new ArrayList();
        Trago trago = new Trago();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,TRAGOS WHERE PRODUCTOS.Prod_ID = TRAGOS.Prod_ID");
            while(resultado.next()){
                trago.setId(resultado.getInt(1));
                trago.setPrecioVenta(resultado.getFloat(2));
                trago.setNombreProducto(resultado.getString(3));
                trago.setIngredientes(resultado.getString(6));
                tragos.add(trago.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readTragos");
        }
        return tragos;
    }

    public List readNarguiles() {
        List <Narguile> narguiles=new ArrayList();
        Narguile nar = new Narguile();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,NARGUILE WHERE PRODUCTOS.Prod_ID = NARGUILE.Prod_ID");
            while(resultado.next()){
                nar.setId(resultado.getInt(1));
                nar.setPrecioVenta(resultado.getFloat(2));
                nar.setNombreProducto(resultado.getString(3));
                nar.setTabaco(resultado.getString(6));
                narguiles.add(nar.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readNarguiles");
        }
        return narguiles;
    }

    public List readGaseosas() {
        List <Gaseosa> gaseosas= new ArrayList();
        Gaseosa gas = new Gaseosa();
        Stock stock;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,GASEOSAS WHERE PRODUCTOS.Prod_ID = GASEOSAS.Prod_ID");
            while(resultado.next()){
                gas.setId(resultado.getInt(1));
                gas.setPrecioVenta(resultado.getFloat(2));
                gas.setNombreProducto(resultado.getString(3));
                gas.setSabor(resultado.getString(6));
                gas.setContenido(resultado.getFloat(7));
                gas.setPrecioCosto(resultado.getFloat(8));
                stock = new Stock(resultado.getInt(9), resultado.getInt(10));
                gas.setStock(stock);
                gaseosas.add(gas.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readGaseosas");
        }
        return gaseosas;
    }

    public List readVinos() {
        List <Vino> vinos= new ArrayList();
        Vino vino = new Vino();
        Stock stock;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,VINOS WHERE PRODUCTOS.Prod_ID = VINOS.Prod_ID");
            while(resultado.next()){
                vino.setId(resultado.getInt(1));
                vino.setPrecioVenta(resultado.getFloat(2));
                vino.setNombreProducto(resultado.getString(3));
                vino.setBodega(resultado.getString(6));
                vino.setColor(resultado.getString(7));
                vino.setTipoDeUva(resultado.getString(8));
                vino.setGraduacionAlc(resultado.getFloat(9));
                vino.setPrecioCosto(resultado.getFloat(10));
                stock = new Stock(resultado.getInt(11),resultado.getInt(12));
                vino.setStock(stock);
                vinos.add(vino.clone());
            }
            
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readVinos");
        }
        return vinos;
    }

    public List readPizzas() {
        List <Pizza> pizzas= new ArrayList();
        Pizza pizza = new Pizza();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,PIZZAS WHERE PRODUCTOS.Prod_ID = PIZZAS.Prod_ID");
            while(resultado.next()){
                pizza.setId(resultado.getInt(1));
                pizza.setPrecioVenta(resultado.getFloat(2));
                pizza.setNombreProducto(resultado.getString(3));
                pizza.setSabor(resultado.getString(6));
                pizzas.add(pizza.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readPizzas");
        }
        return pizzas;
    }

    public List readPicadas() {
        List <Picada> picadas= new ArrayList();
        Picada picada = new Picada();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS,PICADAS WHERE PRODUCTOS.Prod_ID = PICADAS.Prod_ID");
            while(resultado.next()){
                picada.setId(resultado.getInt(1));
                picada.setPrecioVenta(resultado.getFloat(2));
                picada.setNombreProducto(resultado.getString(3));
                picada.setcPersonas(resultado.getInt(6));
                picadas.add(picada.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readPicadas");
        }
        return picadas;
    }

    public boolean createVenta(Venta venta) {
        try{
        conn = ConexionBD.getConexionBD();
        stmt = conn.createStatement();
        int id = venta.getId();
        float precioTotal = venta.getPrecioTotal();
        String usuario = venta.getUsuario();
        String fecha= venta.getFecha();
        stmt.execute ("INSERT "
                + "INTO VENTAS "
                + "VALUES('"+fecha+"',"+id+","+precioTotal+",'"+usuario+"')");
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean createRenglon(Renglon renglon) {
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            int idproducto = renglon.getIdProducto();
            int cantidad = renglon.getCantidad();
            int id = renglon.getId();
            stmt.execute("INSERT "
                        + "INTO RENGLONES "
                        + "VALUES("+idproducto+","+cantidad+","+id+")");
        }catch(SQLException e){
            System.out.println("");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public int consultarStockIndustrial(int idProducto){
        int stockActual=0;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT I_StockActual FROM INDUSTRIALES WHERE Prod_ID = "+idProducto);
            stockActual=resultado.getInt(1);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta de stock industrial");
        }
        return stockActual;
    }
    
    public float consultarStockArtesanal(int idProducto){
        float stockActual=0;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT Bar_CantActual FROM BARRILES,ARTESANALES WHERE Prod_ID = "+idProducto+" AND BARRILES.Bar_ID = ARTESANALES.Bar_ID");
            stockActual=resultado.getFloat(1);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta de stock artesanal");
        }
        return stockActual;
    }
    
    public int consultarStockGaseosas(int idProducto){
        int stockActual=0;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT G_StockActual FROM GASOESAS WHERE Prod_ID = "+idProducto);
            stockActual=resultado.getInt(1);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta de stock gaseosa");
        }
        return stockActual;
    }
    
    public int consultarStockVinos(int idProducto){
        int stockActual=0;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT Vi_StockActual FROM VINOS WHERE Prod_ID = "+idProducto);
            stockActual=resultado.getInt(1);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta de stock gaseosa");
        }
        return stockActual;
    }
    
    public float consultarContenidoArtesanal(int idProducto){
        float contenido=0;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT A_Cont FROM ARTESANALES WHERE Prod_ID = "+idProducto);
            contenido=resultado.getFloat(1);
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta del contenido de la cerveza artesanal");
        }
        return contenido;
    }
    
    public float consultarPrecioProducto(int idProducto){
        float precioVenta = 0;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            String consulta = "SELECT Prod_PrecioVenta FROM PRODUCTOS WHERE Prod_ID ="+idProducto; 
            ResultSet resultado = stmt.executeQuery(consulta);
            precioVenta=resultado.getFloat(1);
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta del precio de venta");
            e.printStackTrace();
        }
        return precioVenta;
    }
    
    public void updateStockIndustriales(int id,int stock) {
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE INDUSTRIALES "
                        + "SET I_StockActual = "+stock+" "
                        + "WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion");
        }
    }

    public void updateStockArtesanalas(int id, float stock) {
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE BARRILES "
                        + "SET Bar_CantActual = "+stock+" "
                        + "WHERE ARTESANALES.Prod_ID = "+id+" AND ARTESANALES.Bar_ID = BARRILES.Bar_ID");
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion");
        }
    }

    public void updateStockGaseosa(int id, int stock) {
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE GASEOSAS "
                        + "SET G_StockActual = "+stock+" "
                        + "WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion");
        }
    }

    public void updateStockVino(int id, int stock) {
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE VINOS "
                        + "SET Vi_StockActual = "+stock+" "
                        + "WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion");
        }
    }

}
