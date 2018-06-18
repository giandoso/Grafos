/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jpgiandoso
 */
public class AGM_Prim {

    GrafoAbstrato grafo;
    List<Aresta> X = new ArrayList<>();
    List<Integer> Q = new ArrayList<>();
    List<Double> chave = new ArrayList<>();
    Integer pai[];

    public AGM_Prim(GrafoAbstrato grafo, int r) {
        this.grafo = grafo;
        pai = new Integer[grafo.getNumVertices()];
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            chave.add(Double.MAX_VALUE);
            Q.add(i);
            pai[i] = null;
        }
        chave.set(r, 0.0);
        while (!Q.isEmpty()) {
            int indexU = extrairMinimo(chave);
            if (indexU != r) {
                Aresta a = new Aresta(indexU, pai[indexU], grafo.getPesoAresta(indexU, pai[indexU]));
                X.add(a);
            }
            List<Integer> adj = grafo.getAdjacentes(indexU);
            for (Integer v : adj) {
                double peso = grafo.getPesoAresta(indexU, v);
                if (Q.contains(v) && peso < chave.get(v)) {
                    chave.set(v, peso);
                    pai[v] = indexU;
                }
            }
        }
    }

    private int extrairMinimo(List<Double> l) {
        double u = Collections.min(l);
        int indexU = chave.indexOf(u);
        if (Q.contains(indexU)) {
            Q.remove(Q.indexOf(indexU));
            return indexU;
        } else {
            List<Double> lAux = new ArrayList<>();
            for (Double l1 : l) {
                lAux.add(l1);
            }
            int indexAux = lAux.indexOf(u);
            lAux.remove(indexAux);
            return extrairMinimo(lAux);
        }
    }

    public void getResults() {
        double total = 0;
        for (Aresta X1 : X) {
            total += X1.getPeso();
        }
        System.out.println("Peso total: " + total);
    }

    public void escreveCSV(String fileName) throws IOException {
        FileWriter file;
        file = new FileWriter(new File(fileName + ".csv"));
        file.write("Origem, Destino, Peso\n");
        file.flush();
        for (Aresta a : X) {
            file.write(a.getOrigem() + "," + a.getDestino() + "," + a.getPeso() + "\n");
            file.flush();

        }
        System.out.println("Arquivo de saida '" + fileName + ".csv' criado com sucesso!");
    }

    public double getDistancia(double[] v1, double[] v2) {
        double distancia;
        distancia = java.lang.Math.pow((v2[0] - v1[0]), 2) + java.lang.Math.pow((v2[1] - v1[1]), 2);
        distancia = java.lang.Math.pow(distancia, 0.5);
        return distancia;
    }
}
