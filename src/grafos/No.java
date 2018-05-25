/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author jpgiandoso
 */
public class No {
    
    private int destino;
    private double peso;
    
    public No(int destino, double peso){
        this.destino = destino;
        this.peso = peso;
    }

    public int getDestino() {
        return this.destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
}