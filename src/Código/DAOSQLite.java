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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maru
 */
public class DAOSQLite implements DAO{
    
    private Connection conn;
    private Statement stmt;
    
    @Override
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
                venta.setPrecioTotal(resultado.getFloat(3));
                venta.setUsuario(resultado.getString(4));
                listaVentas.add(venta.clone());
            }
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return listaVentas;
    }

    @Override
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
                compra.setPrecioTotal(resultado.getFloat(3));
                compra.setUsuario(resultado.getString(4));
                listaCompras.add(compra.clone());
            } 
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
        return listaCompras;
    }

    @Override
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
    
    @Override
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
                art.setPrecioCosto(resultado.getFloat(8));
                art.setGraduacionAlc(resultado.getFloat(9));
                art.setContenido(resultado.getFloat(10));
                art.setColor(resultado.getString(11));
                art.setLupulo(resultado.getString(12));
                art.setMalta(resultado.getString(13));
                barril = new Barril(resultado.getInt(14),resultado.getFloat(16),resultado.getFloat(17));
                art.setBarril(barril);
                
                artesanales.add(art.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readArtesanales");
        }
        return artesanales;  
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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
    
    
    @Override
    public List readRenglonesVenta(int idVenta) {
        List <Renglon> listaRenglones= new ArrayList();
        Renglon renglon= new Renglon();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM RENGLONESVENTA WHERE V_ID = "+idVenta);
            while(resultado.next()){
                renglon.setIdProducto(resultado.getInt(1));
                renglon.setCantidad(resultado.getInt(2));
                renglon.setId(resultado.getInt(3));
                listaRenglones.add(renglon);
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readrenglonesVenta");
        }
        return listaRenglones;
    }
    
    public Producto readProducto(int id){
        Producto prod =  null;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS WHERE Prod_ID = "+id);
            float precioVenta = resultado.getInt(2);
            String nombre = resultado.getString(3);
            String categoria = resultado.getString(4);
            ManagerProductos manager = new ManagerProductos();
            prod = manager.instanciarProducto(id, nombre, categoria, precioVenta);
            
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readrenglonesVenta");
        }
         return prod;      
    }
    
    public List<Object[]> readBarriles(){
        List<Object[]> barriles = new ArrayList();
        Barril barril = new Barril();
        Object[] info = new Object[3];
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT DISTINCT BARRILES.Bar_ID,Bar_CantActual,Bar_CantMinima,A_Tipo,A_Marca "
                                                  + "FROM BARRILES,ARTESANALES "
                                                  + "WHERE BARRILES.Bar_ID = ARTESANALES.Bar_ID");
            while(resultado.next()){
                barril.setId(resultado.getInt(1));
                barril.setCantActual(resultado.getInt(2));
                barril.setCantMinima(resultado.getInt(3));
                info[0] = barril.clone();
                info[1] = resultado.getString(4);
                info[2] = resultado.getString(5);
                barriles.add(info.clone());
            }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta readBarriles");
            e.printStackTrace();
        }
        return barriles;
    }

    @Override
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
    
    @Override
    public boolean createRenglonVenta(Renglon renglon) {
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            int idproducto = renglon.getIdProducto();
            int cantidad = renglon.getCantidad();
            int id = renglon.getId();
            stmt.execute("INSERT "
                        + "INTO RENGLONESVENTA "
                        + "VALUES("+idproducto+","+cantidad+","+id+")");
        }catch(SQLException e){
            System.out.println("");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean createIndustrial(Industrial ind){
        int id = ind.getId();
        float precioVenta = ind.getPrecioVenta();
        String nombre = ind.getNombreProducto();
        String marca = ind.getMarca();
        String tipo = ind.getTipo();
        float precioCosto = ind.getPrecioCosto();
        float gradAlc = ind.getGraduacionAlc();
        float contenido = ind.getContenido();
        String origen = ind.getOrigen();
        int stockActual = ind.getStock().getStockActual();
        int stockMin = ind.getStock().getStockMinimo();
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("INSERT "
                        + "INTO PRODUCTOS "
                        + "VALUES("+id+","+precioVenta+",'"+nombre+"','Industrial')");
            stmt.execute("INSERT "
                        + "INTO INDUSTRIALES "
                        + "VALUES("+id+",'"+marca+"','"+tipo+"',"+precioCosto+","+gradAlc+","+contenido+",'"+origen+"',"+stockActual+","+stockMin+")");
        }catch(SQLException e){
            System.out.println("No se pudo crear la cerveza");
            e.printStackTrace();
            return false;
        }
        return true;
        
    }
    @Override
    public boolean createArtesanal(Artesanal art){
        int id = art.getId();
        float precioVenta = art.getPrecioVenta();
        String nombre = art.getNombreProducto();
        String marca = art.getMarca();
        String tipo = art.getTipo();
        float precioCosto = art.getPrecioCosto();
        float gradAlc = art.getGraduacionAlc();
        float contenido = art.getContenido();
        String color = art.getColor();
        String lupulo = art.getLupulo();
        String malta = art.getMalta();
        int idBarril = art.getBarril().getId();
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("INSERT "
                        + "INTO PRODUCTOS "
                        + "VALUES("+id+","+precioVenta+",'"+nombre+"','Artesanal')");
            stmt.execute("INSERT "
                        + "INTO ARTESANALES "
                        + "VALUES("+id+",'"+marca+"','"+tipo+"',"+precioCosto+","+gradAlc+","+contenido+",'"+color+"','"+lupulo+"','"+malta+"',"+idBarril+")");
        }catch(SQLException e){
            System.out.println("No se pudo crear la cerveza");
            e.printStackTrace();
            return false;
        }
        return true;
        
    }
    
    public boolean createVino(Vino vino){
        int id = vino.getId();
        float precioVenta = vino.getPrecioVenta();
        String nombre = vino.getNombreProducto();
        String bodega = vino.getBodega();
        String color = vino.getColor();
        String uva = vino.getTipoDeUva();
        float precioCosto = vino.getPrecioCosto();
        float gradAlc = vino.getGraduacionAlc();
        int stockActual = vino.getStock().getStockActual();
        int stockMin = vino.getStock().getStockMinimo();
                    
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("INSERT "
                        + "INTO PRODUCTOS "
                        + "VALUES("+id+","+precioVenta+",'"+nombre+"','Vino')");
            stmt.execute("INSERT "
                        + "INTO VINOS "
                        + "VALUES("+id+",'"+bodega+"','"+color+"','"+uva+"',"+gradAlc+","+precioCosto+","+stockActual+","+stockMin+")");
        
        }catch(SQLException e){
            System.out.println("No se pudo realizar la creacion de Vino");
            return false;
        }
        return true;
    }
    
    @Override
    public boolean createGaseosa(Gaseosa gas){
        int id = gas.getId();
        float precioVenta = gas.getPrecioVenta();
        String nombre = gas.getNombreProducto();
        String sabor = gas.getSabor();
        float contenido = gas.getContenido();
        float precioCosto = gas.getPrecioCosto();
        int stockActual = gas.getStock().getStockActual();
        int stockMin = gas.getStock().getStockMinimo();
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("INSERT "
                        + "INTO PRODUCTOS "
                        + "VALUES("+id+","+precioVenta+",'"+nombre+"','Gaseosa')");
            stmt.execute("INSERT "
                        + "INTO GASEOSAS "
                        + "VALUES("+id+",'"+sabor+"',"+contenido+","+precioCosto+","+stockActual+","+stockMin+")");
        }catch(SQLException e){
            System.out.println("No se pudo realizar la creacion de Gaseosa");
            return false;
        }
        return true;
    }
    
    @Override
    public boolean createTrago(Trago trago){
        int id = trago.getId();
        float precioVenta = trago.getPrecioVenta();
        String nombre = trago.getNombreProducto();
        String ingredientes = trago.getIngredientes();
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("INSERT "
                        + "INTO PRODUCTOS "
                        + "VALUES("+id+","+precioVenta+",'"+nombre+"','Trago')");
            stmt.execute("INSERT "
                        + "INTO TRAGOS "
                        + "VALUES("+id+",'"+ingredientes+"')");
        }catch(SQLException e){
            System.out.println("No se pudo realizar la creacion de Trago");
            return false;
        }
        return true;
        
    }
    
    @Override
    public boolean createNarguile(Narguile nar){
        int id = nar.getId();
        float precioVenta = nar.getPrecioVenta();
        String nombre = nar.getNombreProducto();
        String tabaco = nar.getTabaco();
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("INSERT "
                        + "INTO PRODUCTOS "
                        + "VALUES("+id+","+precioVenta+",'"+nombre+"','Narguile')");
            stmt.execute("INSERT "
                        + "INTO NARGUILE "
                        + "VALUES("+id+",'"+tabaco+"')");
        }catch(SQLException e){
            System.out.println("No se pudo realizar la creacion de Narguile");
            return false;
        }
        return true;
        
    }
    
    @Override
    public boolean createPizza(Pizza pizza){
        int id = pizza.getId();
        float precioVenta = pizza.getPrecioVenta();
        String nombre = pizza.getNombreProducto();
        String variedad = pizza.getSabor();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("INSERT "
                        + "INTO PRODUCTOS "
                        + "VALUES("+id+","+precioVenta+",'"+nombre+"','Pizza')");
            stmt.execute("INSERT "
                        + "INTO PIZZAS "
                        + "VALUES("+id+",'"+variedad+"')");
        }catch(SQLException e){
            System.out.println("No se pudo realizar la creacion de Pizza");
            return false;
        }
        return true;
        
    }
    
    @Override
    public boolean createPicada(Picada pic){
        int id = pic.getId();
        float precioVenta = pic.getPrecioVenta();
        String nombre = pic.getNombreProducto();
        int personas = pic.getcPersonas();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("INSERT "
                        + "INTO PRODUCTOS "
                        + "VALUES("+id+","+precioVenta+",'"+nombre+"','Picada')");
            stmt.execute("INSERT "
                        + "INTO PICADAS "
                        + "VALUES("+id+","+personas+")");
        }catch(SQLException e){
            System.out.println("No se pudo realizar la creacion de Picada");
            return false;
        }
        return true;
        
    }
    
    @Override
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
    
    @Override
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
    
    @Override
    public int consultarStockGaseosas(int idProducto){
        int stockActual=0;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT G_StockActual FROM GASEOSAS WHERE Prod_ID = "+idProducto);
            stockActual=resultado.getInt(1);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta de stock gaseosa");
        }
        return stockActual;
    }
    
    @Override
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
    
    @Override
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
    
    public int consultarIdBarril(int idProducto){
        int idBarril=0;
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT Bar_ID FROM ARTESANALES WHERE Prod_ID = "+idProducto);
            idBarril=resultado.getInt(1);
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la consulta del contenido de la cerveza artesanal");
        }
        return idBarril;
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
    
    @Override
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

    @Override
    public void updateStockArtesanalas(int id, float stock) {
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE BARRILES "
                        + "SET Bar_CantActual = "+stock+" "
                        + "WHERE Bar_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion");
        }
    }

    @Override
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

    @Override
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
    
    @Override
    public boolean updateIndustrial(Industrial ind){
        int id = ind.getId();
        float precioVenta = ind.getPrecioVenta();
        String nombre = ind.getNombreProducto();
        String marca = ind.getMarca();
        String tipo = ind.getTipo();
        float precioCosto = ind.getPrecioCosto();
        float gradAlc = ind.getGraduacionAlc();
        float contenido = ind.getContenido();
        String origen = ind.getOrigen();
        int stockActual = ind.getStock().getStockActual();
        int stockMin = ind.getStock().getStockMinimo();
               
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE PRODUCTOS "
                        + "SET Prod_PrecioVenta = "+precioVenta+",Prod_Nombre =  '"+nombre+"' "
                        + "WHERE Prod_ID = "+id);
            stmt.execute("UPDATE INDUSTRIALES "
                        + "SET I_Marca = '"+marca+"',I_Tipo = '"+tipo+"',I_PrecioCosto = "+precioCosto+" "
                        +",I_GradAlc = "+gradAlc+",I_Cont = "+contenido+",I_Origen = '"+origen+"',I_StockActual = "+stockActual+",I_StockMinimo = "+stockMin+" "
                        +"WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion de Industrial");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateArtesanal(Artesanal art){
        int id = art.getId();
        float precioVenta = art.getPrecioVenta();
        String nombre = art.getNombreProducto();
        String marca = art.getMarca();
        String tipo = art.getTipo();
        float precioCosto = art.getPrecioCosto();
        float gradAlc = art.getGraduacionAlc();
        float contenido = art.getContenido();
        String color = art.getColor();
        String lupulo = art.getLupulo();
        String malta = art.getMalta();
                    
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE PRODUCTOS "
                        + "SET Prod_PrecioVenta = "+precioVenta+",Prod_Nombre =  '"+nombre+"' "
                        + "WHERE Prod_ID = "+id);
            stmt.execute("UPDATE ARTESANALES "
                        + "SET A_Marca = '"+marca+"',A_Tipo = '"+tipo+"',A_PrecioCosto = "+precioCosto+" "
                        +",A_GradAlc = "+gradAlc+",A_Cont = "+contenido+",A_Color = '"+color+"',A_Lúpulo = '"+lupulo+"',A_Malta = '"+malta+"' "
                        +"WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion de Artesanal");
            return false;
        }
        return true;
    }
    
    @Override
    public boolean updateVino(Vino vino){
        int id = vino.getId();
        float precioVenta = vino.getPrecioVenta();
        String nombre = vino.getNombreProducto();
        String bodega = vino.getBodega();
        String color = vino.getColor();
        String uva = vino.getTipoDeUva();
        float precioCosto = vino.getPrecioCosto();
        float gradAlc = vino.getGraduacionAlc();
        int stockActual = vino.getStock().getStockActual();
        int stockMin = vino.getStock().getStockMinimo();
                    
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE PRODUCTOS "
                        + "SET Prod_PrecioVenta = "+precioVenta+",Prod_Nombre =  '"+nombre+"' "
                        + "WHERE Prod_ID = "+id);
            stmt.execute("UPDATE VINOS "
                        + "SET Vi_Bodega = '"+bodega+"',Vi_Color = '"+color+"',Vi_PrecioCosto = "+precioCosto+" "
                        +",Vi_GradAlc = "+gradAlc+",Vi_Uva = '"+uva+"',Vi_StockActual = "+stockActual+",Vi_StockMinimo = "+stockMin+" "
                        +"WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion de Vino");
            return false;
        }
        return true;
    }
    
    @Override
    public boolean updateGaseosa(Gaseosa gas){
        int id = gas.getId();
        float precioVenta = gas.getPrecioVenta();
        String nombre = gas.getNombreProducto();
        String sabor = gas.getSabor();
        float contenido = gas.getContenido();
        float precioCosto = gas.getPrecioCosto();
        int stockActual = gas.getStock().getStockActual();
        int stockMin = gas.getStock().getStockMinimo();
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE PRODUCTOS "
                        + "SET Prod_PrecioVenta = "+precioVenta+",Prod_Nombre =  '"+nombre+"' "
                        + "WHERE Prod_ID = "+id);
            stmt.execute("UPDATE GASEOSAS "
                        + "SET G_Sabor = '"+sabor+"',G_Cont = "+contenido+",G_PrecioCosto = "+precioCosto+", "
                        +"G_StockActual = "+stockActual+",G_StockMinima = "+stockMin+" "
                        +"WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion de Gaseosa");
            return false;
        }
        return true;
    }
    
    @Override
    public boolean updateTrago(Trago trago){
        int id = trago.getId();
        float precioVenta = trago.getPrecioVenta();
        String nombre = trago.getNombreProducto();
        String ingredientes = trago.getIngredientes();
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE PRODUCTOS "
                        + "SET Prod_PrecioVenta = "+precioVenta+",Prod_Nombre =  '"+nombre+"' "
                        + "WHERE Prod_ID = "+id);
            stmt.execute("UPDATE TRAGOS "
                        + "SET T_Ingredientes = '"+ingredientes+"' "
                        +"WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion de Trago");
            return false;
        }
        return true;
        
    }
    
    @Override
    public boolean updateNarguile(Narguile nar){
        int id = nar.getId();
        float precioVenta = nar.getPrecioVenta();
        String nombre = nar.getNombreProducto();
        String tabaco = nar.getTabaco();
        
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE PRODUCTOS "
                        + "SET Prod_PrecioVenta = "+precioVenta+",Prod_Nombre =  '"+nombre+"' "
                        + "WHERE Prod_ID = "+id);
            stmt.execute("UPDATE NARGUILE "
                        + "SET N_Tabaco = '"+tabaco+"' "
                        +"WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion de Narguile");
            return false;
        }
        return true;
        
    }
    
    @Override
    public boolean updatePizza(Pizza pizza){
        int id = pizza.getId();
        float precioVenta = pizza.getPrecioVenta();
        String nombre = pizza.getNombreProducto();
        String variedad = pizza.getSabor();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE PRODUCTOS "
                        + "SET Prod_PrecioVenta = "+precioVenta+",Prod_Nombre =  '"+nombre+"' "
                        + "WHERE Prod_ID = "+id);
            stmt.execute("UPDATE PIZZAS "
                        + "SET Pizza_Sabor = '"+variedad+"' "
                        +"WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion de Pizza");
            return false;
        }
        return true;
        
    }
    
    @Override
    public boolean updatePicada(Picada pic){
        int id = pic.getId();
        float precioVenta = pic.getPrecioVenta();
        String nombre = pic.getNombreProducto();
        int personas = pic.getcPersonas();
        try{
            conn = ConexionBD.getConexionBD();
            stmt = conn.createStatement();
            stmt.execute("UPDATE PRODUCTOS "
                        + "SET Prod_PrecioVenta = "+precioVenta+",Prod_Nombre = '"+nombre+"' "
                        + "WHERE Prod_ID = "+id);
            stmt.execute("UPDATE PICADAS "
                        + "SET Pic_CantPersonas = "+personas+" "
                        +"WHERE Prod_ID = "+id);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la modificacion de Picada");
            return false;
        }
        return true;
        
    }
    
}
