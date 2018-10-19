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
        String      name = "BD_BARBA_AZUL";
        String      dbURL = "jdbc:sqlite:";
        
        
        try{
            this.conn = (Connection)DriverManager.getConnection(dbURL+name+".db");
            stmt = conn.createStatement();
        
            try{
                //stmt.executeUpdate("CREATE DATABASE '"+name+"';");

                //System.out.println("BD creada!");

             }catch(Exception e){
                System.out.println("BD ya creada!");
                e.printStackTrace();
            }
                //Si no existen las tablas las crea
            try{
                stmt.execute("CREATE TABLE IF NOT EXISTS PRODUCTOS(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Prod_PrecioVenta    REAL        NOT NULL,\n" +
                            "    Prod_Esp            VARCHAR(10) NOT NULL\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS USUARIOS(\n" +
                            "    U_Nombre            VARCHAR(20) NOT NULL,\n" +
                            "    U_Apellido          VARCHAR(20) NOT NULL,\n" +
                            "    U_FechaNac          DATE        NOT NULL,\n" +
                            "    U_User              VARCHAR(20) NOT NULL    PRIMARY KEY,\n" +
                            "    U_Pass              VARCHAR(20) NOT NULL,\n" +
                            "    U_Permiso           INT         NOT NULL\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS VENTAS(\n" +
                            "    V_Fecha             DATE        NOT NULL,\n" +
                            "    V_ID                INT         NOT NULL    PRIMARY KEY,\n" +
                            "    V_PrecioTotal       REAL        NOT NULL,\n" +
                            "    U_User              VARCHAR(20) NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(U_User) REFERENCES Usuarios(U_User)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS COMPRAS(\n" +
                            "    C_Fecha             DATE        NOT NULL,\n" +
                            "    C_ID                INT         NOT NULL    PRIMARY KEY,\n" +
                            "    C_PrecioTotal       REAL        NOT NULL,\n" +
                            "    U_User              VARCHAR(20) NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(U_User) REFERENCES Usuarios(U_User)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS RENGLONES(\n" +
                            "    R_Producto          VARCHAR(20) NOT NULL,\n" +
                            "    R_Cant              INT         NOT NULL,\n" +
                            "    V_ID                INT         NOT NULL    PRIMARY KEY,\n" +
                            "\n" +
                            "    FOREIGN KEY(V_ID) REFERENCES Ventas(V_ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS BARRILES(\n" +
                            "    Bar_ID              INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Bar_CantActual      REAL        NOT NULL,\n" +
                            "    Bar_CantMinima      REAL        NOT NULL\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS INDUSTRIALES(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    I_Nombre            VARCHAR(20) NOT NULL,\n" +
                            "    I_Marca             VARCHAR(30) NOT NULL,\n" +
                            "    I_Tipo              VARCHAR(30) NOT NULL,\n" +
                            "    I_PrecioCosto       REAL        NOT NULL,\n" +
                            "    I_GradAlc           REAL        NOT NULL,\n" +
                            "    I_Cont              REAL        NOT NULL,\n" +
                            "    I_Origen            VARCHAR(20) NOT NULL,\n" +
                            "    I_StockActual       INT         NOT NULL,\n" +
                            "    I_StockMinimo       INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod_ID) REFERENCES Productos(Prod_ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS ARTESANALES(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    A_Nombre            VARCHAR(20) NOT NULL,\n" +
                            "    A_Marca             VARCHAR(30) NOT NULL,\n" +
                            "    A_Tipo              VARCHAR(30) NOT NULL,\n" +
                            "    A_PrecioCosto       REAL        NOT NULL,\n" +
                            "    A_GradAlc           REAL        NOT NULL,\n" +
                            "    A_Cont              REAL        NOT NULL,\n" +
                            "    A_Color             VARCHAR(20) NOT NULL,\n" +
                            "    A_Lúpulo            VARCHAR(30) NOT NULL,\n" +
                            "    A_Malta             VARCHAR(30) NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod_ID) REFERENCES Productos(Prod_ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS TRAGOS(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    T_Nombre            VARCHAR(20) NOT NULL,\n" +
                            "    T_Ingredientes      VARCHAR(100) NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod_ID) REFERENCES Productos(Prod_ID)\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS NARGUILE(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    N_Tabaco            VARCHAR     NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod_ID) REFERENCES Productos(Prod_ID)\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS GASEOSAS(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    G_Nombre            VARCHAR(30) NOT NULL,\n" +
                            "    G_Sabor             VARCHAR(20) NOT NULL,\n" +
                            "    G_Cont              REAL        NOT NULL,\n" +
                            "    G_PrecioCosto       REAL        NOT NULL,\n" +
                            "    G_StockActual       INT         NOT NULL,\n" +
                            "    G_StockMinima       INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod_ID) REFERENCES Productos(Prod_ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS VINOS(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Vi_Nombre           VARCHAR(30) NOT NULL,\n" +
                            "    Vi_Bodega           VARCHAR(20) NOT NULL,\n" +
                            "    Vi_Color            VARCHAR(20) NOT NULL,\n" +
                            "    Vi_Uva              VARCHAR(30) NOT NULL,\n" +
                            "    Vi_GradAlc          REAL        NOT NULL,\n" +
                            "    Vi_PrecioCosto      REAL        NOT NULL,\n" +
                            "    Vi_StockActual      INT         NOT NULL,\n" +
                            "    Vi_StockMinimo      INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod_ID) REFERENCES Productos(Prod_ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS PIZZAS(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Pizza_Sabor         VARCHAR(30) NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod_ID) REFERENCES Productos(Prod_ID)\n" +
                            "\n" +
                            ");");
                stmt.execute("CREATE TABLE IF NOT EXISTS PICADAS(\n" +
                            "    Prod_ID             INT         NOT NULL    PRIMARY KEY,\n" +
                            "    Pic_CantPersonas    INT         NOT NULL,\n" +
                            "\n" +
                            "    FOREIGN KEY(Prod_ID) REFERENCES Productos(Prod_ID)\n" +
                            "    \n" +
                            ");");

                System.out.println("Tablas creadas");
            }catch(Exception e){
                System.out.println("No se pudieron crear las tablas");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al cargar la BD");
        }
    }
    public Connection getConn(){
        return conn;
    }
    public static void createConexionBD(){
        if(conBD == null)
            conBD = new ConexionBD();
    }
    public static ConexionBD getConexionBD(){
        if(conBD == null)
            createConexionBD();
        return conBD;
    }
}
