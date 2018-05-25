/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import static grafos.Cores.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author jpgiandoso
 */
public class DFS_iterativo {
    int tempo; 
    Cores[] v;
    int[] d;
    int[] f;
    int vertices;
    GrafoAbstrato grafo;
    Stack<Integer> pilha = new Stack();
    public DFS_iterativo(GrafoAbstrato pGrafo){
        this.grafo = pGrafo;
        this.vertices = grafo.getNumVertices();
        v = new Cores[vertices];
        d = new int[vertices];
        f = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            v[i] = BRANCO;
        }
        tempo = 0;
        pilha.push(0);
        v[0] = CINZA;
        d[0] = ++tempo;
        
        while(!pilha.empty()){
            int aux = pilha.peek();
            List<Integer> adj = grafo.getAdjacentes(aux);
            for (int vertice : adj) {
                if(v[vertice] == BRANCO){
                    pilha.push(vertice);
                    v[vertice] = CINZA;
                    d[vertice] = ++tempo;
                    adj = grafo.getAdjacentes(vertice);
                }
            }
            int finalizado = pilha.pop();
            v[finalizado] = PRETO;
            f[finalizado] = ++tempo;
        }
    }
    
    public void escreveCSV(String fileName) throws IOException {
        FileWriter file;
        file = new FileWriter(new File(fileName));
        file.write("Vertice, Descoberto, Finalizado\n");
        file.flush();
        for (int i = 0; i < vertices; i++) {
            file.write(i+","+d[i]+","+f[i]+"\n");
            file.flush();
        }
        System.out.println("Arquivo criado com sucesso!");
    }
}
