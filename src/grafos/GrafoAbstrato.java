/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.List;

/**
 *
 * @author jpgiandoso
 */
public abstract class GrafoAbstrato {

    Representacao representacao = null;

    public abstract void criarGrafo(int numVertices);

    //Dependendo da representação pode ser add ou set
    public abstract void setPesoAresta(int origem, int destino, double peso);

    public abstract void addAresta(int origem, int destino, double peso);

    public abstract double getPesoAresta(int origem, int destino);

    public abstract void removeAresta(int origem, int destino);

    public abstract int getNumArestas();

    public abstract boolean existeAresta (int origem, int destino);
    
    public abstract Representacao getRepresentacaoComputacional();
    
    public abstract void printarGrafo();

    public abstract int getNumVertices();
        
    public abstract List<Integer> getAdjacentes (int vertice);
    
    public abstract List<Aresta> getArestasOrdenadas();
    //public abstract List<No> getNosAdjacentes (int vertice);
    
}