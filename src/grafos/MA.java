/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpgiandoso
 */
public final class MA extends GrafoAbstrato {

    private double[][] m;

    @Override
    public void criarGrafo(int numVertices) {
        m = new double[numVertices][numVertices];
        super.representacao = Representacao.MAT_ADJACENCIA;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = Double.POSITIVE_INFINITY;
            }

        }
    }

    public MA(int vertices) {
        criarGrafo(vertices);
    }

    @Override
    public void setPesoAresta(int origem, int destino, double peso) {
        this.m[origem][destino] = peso;
    }

    @Override
    public void addAresta(int origem, int destino, double peso) {
        this.m[origem][destino] = peso;
    }

    @Override
    public double getPesoAresta(int origem, int destino) {
        return this.m[origem][destino];
    }

    @Override
    public void removeAresta(int origem, int destino) {
        this.m[origem][destino] = Double.POSITIVE_INFINITY;
    }

    @Override
    public int getNumArestas() {
        int cont = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] != Double.POSITIVE_INFINITY) {
                    cont++;
                }
            }
        }
        return cont;
    }

    @Override
    public boolean existeAresta(int origem, int destino) {
        return m[origem][destino] != Double.POSITIVE_INFINITY;
    }

    @Override
    public Representacao getRepresentacaoComputacional() {
        return super.representacao;
    }

    @Override
    public void printarGrafo() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.print("|0.0|");
                } else {
                    System.out.print("|" + m[i][j] + "|");
                }
            }
            System.out.println("");
        }
    }

    @Override
    public List<Integer> getAdjacentes(int vertice) {
        List<Integer> l = new ArrayList();
        for (int i = 0; i < m.length; i++) {
            if (m[vertice][i] != Double.POSITIVE_INFINITY) {
                l.add(i);
            }
        }
        return l;
    }

    @Override
    public List<No> getNosAdjacentes(int vertice) {
        List<No> l = new ArrayList();
        for (int i = 0; i < m.length; i++) {
            if (m[vertice][i] != Double.POSITIVE_INFINITY) {
                No aux = new No(i, m[vertice][i]);
                l.add(aux);
            }
        }
        return l;
    }

    @Override
    public int getNumVertices() {
        return this.m.length;
    }

}
