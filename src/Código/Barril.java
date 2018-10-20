/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código;

/**
 *
 * @author Maru
 */
public class Barril {
    private float cantActual;
    private float cantMinima;
    private int id;

    public Barril(int id,float cantActual, float cantMinima) {
        this.id = id;
        this.cantActual = cantActual;
        this.cantMinima = cantMinima;
    }
    
    public Barril(){
        this.cantActual=0;
        this.cantMinima=0;
    }

    public float getCantActual() {
        return cantActual;
    }

    public float getCantMinima() {
        return cantMinima;
    }

    public void setCantActual(float cantActual) {
        this.cantActual = cantActual;
    }

    public void setCantMinima(float cantMinima) {
        this.cantMinima = cantMinima;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public Barril clone(){
        Barril barril= new Barril();
        barril.setCantActual(this.getCantActual());
        barril.setCantMinima(this.getCantMinima());
        return barril;
    }
    
}
