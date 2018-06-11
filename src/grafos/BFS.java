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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author jpgiandoso
 */
public class BFS {

    Cores[] cor;
    int[] pai;
    int[] d;
    GrafoAbstrato grafo;
    int vertices;
    Queue<Integer> Q = new LinkedList<>();

    public BFS(GrafoAbstrato pGrafo, int s) {
        this.grafo = pGrafo;
        this.vertices = grafo.getNumVertices();
        cor = new Cores[vertices];
        d = new int[vertices];
        pai = new int[vertices];
        for (int u = 0; u < this.vertices; u++) {
            cor[u] = BRANCO;
            d[u] = Integer.MAX_VALUE;
        }
        cor[s] = CINZA;
        d[s] = 0;
        pai[s] = -1;
        Q.add(s);
        int u;
        while (Q.peek() != null) {
            u = Q.remove();
            List<Integer> adjU = grafo.getAdjacentes(u);
            for (int v : adjU) {
                if (cor[v] == BRANCO) {
                    cor[v] = CINZA;
                    d[v] = d[u] + 1;
                    pai[v] = u;
                    Q.add(v);
                }
            }
            cor[u] = PRETO;
        }
    }

    public void getResults() {
        System.out.println("Vetor Pai");
        for (int i = 0; i < vertices; i++) {
            System.out.print("|" + pai[i] + "|");
        }
        System.out.println("");
        System.out.println("Distancias");
        for (int i = 0; i < vertices; i++) {
            System.out.print("|" + d[i] + "|");
        }
        System.out.println("");
    }

    public void escreveCSV(String fileName) throws IOException {
        FileWriter file;
        file = new FileWriter(new File(fileName + ".csv"));
        file.write("Vertice, Distancia, Pai\n");
        file.flush();
        for (int i = 0; i < vertices; i++) {
            file.write(i + "," + d[i] + "," + pai[i] + "\n");
            file.flush();
        }
        System.out.println("Arquivo criado com sucesso!");
    }

}
