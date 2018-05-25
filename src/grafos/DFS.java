/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import static grafos.Cores.*;
import static grafos.Representacao.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpgiandoso
 */
public final class DFS {

    int tempo;
    Cores[] v;
    int[] d;
    int[] f;
    int vertices;
    GrafoAbstrato grafo;
    
    public DFS(GrafoAbstrato pGrafo) {
        this.grafo = pGrafo;
        this.vertices = grafo.getNumVertices();
        v = new Cores[vertices];
        d = new int[vertices];
        f = new int[vertices];
        for (int i = 0; i < this.vertices; i++) {
            v[i] = BRANCO;
        }
        tempo = 0;
        for (int i = 0; i < vertices; i++) {
            if (v[i] == BRANCO) {
                DFS_VISIT(i);
            }
        }
    }


    public void DFS_VISIT(int u) {
        v[u] = CINZA;
        tempo++;
        d[u] = tempo;
        List<Integer> adj = grafo.getAdjacentes(u);
        for (int i = 0; i < this.vertices; i++) {
            if (adj.contains(i)) {
                if (v[i] == BRANCO) {
                    DFS_VISIT(i);
                }
            }
        }
        v[u] = PRETO;
        f[u] = ++tempo;
    }

    public void getResults() {
        System.out.println("Distancias:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("|" + d[i] + "|");
        }
        System.out.println("");
        System.out.println("T. de finalização:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("|" + f[i] + "|");
        }
        System.out.println("");
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
