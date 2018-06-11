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
public class Aresta implements Comparable<Aresta>{
    
    private int destino;
    private int origem;
    private double peso;
    
    public Aresta(int destino, double peso){
        this.destino = destino;
        this.peso = peso;
    }

    public Aresta(int origem,int destino, double peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    
    public int getOrigem(){
        return this.origem;
    }
    public void setOrigem(int origem){
        this.origem = origem;
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
           
    @Override
    public int compareTo(Aresta o) {
        if (this.peso < o.getPeso()) {
            return -1;
        }
        if (this.peso > o.getPeso()) {
            return 1;
        }
        return 0;
    }
}