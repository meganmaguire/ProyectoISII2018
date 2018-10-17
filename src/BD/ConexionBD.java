/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author megan
 */
public class ConexionBD {
    
    private static ConexionBD conBD = null;
    private Statement stmt;
    private Connection conn;
    
    private ConexionBD(){
        String      driver = "org.postgresql.Driver";
        String      name = "BD-BARBA-AZUL";
        String      dbURL = "jdbc:postgresql://localhost/";
        String      username = "postgres";
        String      password = "postgres";
        
        
        try{
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(dbURL,username,password);
            stmt = conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al cargar la BD");
        }
        try{
            stmt.executeUpdate("CREATE DATABASE \""+name+"\"");
            System.out.println("BD creada!");
            //Si no existen las tablas las crea
            try{
                stmt.execute("CREATE TABLE Productos(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Prod-PrecioVenta    REAL        NOT NULL,\n" +
                            "    Prod-Esp            VARCHAR(10) NOT NULL,\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Usuarios(\n" +
                            "    U-Nombre            VARCHAR(20) NOT NULL,\n" +
                            "    U-Apellido          VARCHAR(20) NOT NULL,\n" +
                            "    U-FechaNac          DATE        NOT NULL,\n" +
                            "    U-User              VARCHAR(20) NOT NULL    PRIMARY KEY,\n" +
                            "    U-Pass              VARCHAR(20) NOT NULL,\n" +
                            "    U-Permiso           INT         NOT NULL\n" +
                            ");");
                stmt.execute("CREATE TABLE Ventas(\n" +
                            "    V-Fecha             DATE        NOT NULL,\n" +
                            "    V-ID                INT         NOT NULL    PRIMARY KEY,\n" +
                            "    V-PrecioTotal       REAL        NOT NULL,\n" +
                            "    U-User              INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(U-User) REFERENCES Usuarios(U-User)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Compras(\n" +
                            "    C-Fecha             DATE        NOT NULL,\n" +
                            "    C-ID                INT         NOT NULL    PRIMARY KEY,\n" +
                            "    C-PrecioTotal       REAL        NOT NULL,\n" +
                            "    U-User              VARCHAR(20) NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(U-User) REFERENCES Usuarios(U-User)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Renglones(\n" +
                            "    R-Producto          VARCHAR(20) NOT NULL,\n" +
                            "    R-Cant              INT         NOT NULL,\n" +
                            "    V-ID                INT         NOT NULL    PRIMARY KEY,\n" +
                            "\n" +
                            "    FOREIGN KEY(V-ID) REFERENCES Ventas(V-ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Industriales(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    I-Nombre            VARCHAR(20) NOT NULL,\n" +
                            "    I-Marca             VARCHAR(30) NOT NULL,\n" +
                            "    I-Tipo              VARCHAR(30) NOT NULL,\n" +
                            "    I-PrecioCosto       REAL        NOT NULL,\n" +
                            "    I-GradAlc           REAL        NOT NULL,\n" +
                            "    I-Cont              REAL        NOT NULL,\n" +
                            "    I-Origen            VARCHAR(20) NOT NULL,\n" +
                            "    I-StockActual       INT         NOT NULL,\n" +
                            "    I-StockMinimo       INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod-ID) REFERENCES Productos(Prod-ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Artesanales(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    A-Nombre            VARCHAR(20) NOT NULL,\n" +
                            "    A-Marca             VARCHAR(30) NOT NULL,\n" +
                            "    A-Tipo              VARCHAR(30) NOT NULL,\n" +
                            "    A-PrecioCosto       REAL        NOT NULL,\n" +
                            "    A-GradAlc           REAL        NOT NULL,\n" +
                            "    A-Cont              REAL        NOT NULL,\n" +
                            "    A-Color             VARCHAR(20) NOT NULL,\n" +
                            "    A-Lúpulo            VARCHAR(30) NOT NULL,\n" +
                            "    A-Malta             VARCHAR(30) NOT NULL,\n" +
                            "    A-CantActual        REAL        NOT NULL,\n" +
                            "    A-CantMinima        REAL        NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod-ID) REFERENCES Productos(Prod-ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Tragos(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    T-Nombre            VARCHAR(20) NOT NULL,\n" +
                            "    T-Ingredientes      VARCHAR(100) NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod-ID) REFERENCES Productos(Prod-ID)\n" +
                            ");");
                stmt.execute("CREATE TABLE Narguiles(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    N-Tabaco            VARCHAR     NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod-ID) REFERENCES Productos(Prod-ID)\n" +
                            ");");
                stmt.execute("CREATE TABLE Gaseosas(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    G-Nombre            VARCHAR(30) NOT NULL,\n" +
                            "    G-Sabor             VARCHAR(20) NOT NULL,\n" +
                            "    G-Cont              REAL        NOT NULL,\n" +
                            "    G-PrecioCosto       REAL        NOT NULL,\n" +
                            "    G-StockActual       INT         NOT NULL,\n" +
                            "    G-StockMinima       INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod-ID) REFERENCES Productos(Prod-ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Vinos(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Vi-Nombre           VARCHAR(30) NOT NULL,\n" +
                            "    Vi-Bodega           VARCHAR(20) NOT NULL,\n" +
                            "    Vi-Color            VARCHAR(20) NOT NULL,\n" +
                            "    Vi-Uva              VARCHAR(30) NOT NULL,\n" +
                            "    Vi-GradAlc          REAL        NOT NULL,\n" +
                            "    Vi-PrecioCosto      REAL        NOT NULL,\n" +
                            "    Vi-StockActual      INT         NOT NULL,\n" +
                            "    Vi-StockMinimo      INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod-ID) REFERENCES Productos(Prod-ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Pizzas(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Pizza-Sabor         VARCHAR(30) NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod-ID) REFERENCES Productos(Prod-ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE Picadas(\n" +
                            "    Prod-ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Pic-CantPersonas    INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod-ID) REFERENCES Productos(Prod-ID)\n" +
                            "    \n" +
                            ");");
            }catch(Exception e){}
        }catch(Exception e){
            System.out.println("BD ya creada!");
        }
        
    }
    public Connection getConn(){
        return conn;
    }
    private static void createConexionBD(){
        if(conBD == null)
            conBD = new ConexionBD();
    }
    public static ConexionBD getConexionBD(){
        if(conBD == null)
            createConexionBD();
        return conBD;
    }
}
