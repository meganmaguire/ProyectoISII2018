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
public class Stock {
    private int stockActual;
    private int stockMinimo;

    public Stock(int stockActual, int stockMinimo) {
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

    public Stock(){
        this.stockActual=0;
        this.stockMinimo=0;
    }
    
    public int getStockActual() {
        return stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    
    public Stock clone(){
        Stock stock= new Stock();
        stock.setStockActual(this.getStockActual());
        stock.setStockMinimo(this.getStockMinimo());
        return stock;
    }
}
