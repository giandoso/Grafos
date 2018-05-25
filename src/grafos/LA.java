/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jpgiandoso
 */
public class LA extends GrafoAbstrato {

    private List<No>[] v;

    @Override
    public void criarGrafo(int numVertices) {
        super.representacao = Representacao.LISTA_ADJACENCIA;
        v = new List[numVertices];
        for (int i = 0; i < numVertices; i++) {
            v[i] = new LinkedList<>();
        }
    }

    public LA(int vertices) {
        criarGrafo(vertices);
    }

    @Override
    public void setPesoAresta(int origem, int destino, double peso) {
        for (int i = 0; i < v[origem].size(); i++) {
            if (v[origem].get(i).getDestino() == destino) {
                No a = new No(destino,peso);
                v[origem].set(i,a);
            }
        }
    }

    @Override
    public void addAresta(int origem, int destino, double peso) {
        No a = new No(destino, peso);
        v[origem].add(a);
    }

    @Override
    public double getPesoAresta(int origem, int destino) {
        for (int i = 0; i < v[origem].size(); i++) {
            if (v[origem].get(i).getDestino() == destino) {
                return v[origem].get(i).getPeso();
            }

        }
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public void removeAresta(int origem, int destino) {
        for (int i = 0; i < v[origem].size(); i++) {
            if (v[origem].get(i).getDestino() == destino) {
                v[origem].remove(i);
            }

        }
    }

    @Override
    public int getNumArestas() {
        int cont = 0;
        for (int i = 0; i < v.length; i++) {
            cont += v[i].size();
        }
        return cont;
    }

    @Override
    public boolean existeAresta(int origem, int destino) {
        for (int i = 0; i < v[origem].size(); i++) {
            if (v[origem].get(i).getDestino() == destino) {
                return true;
            }

        }
        return false;
    }

    @Override
    public Representacao getRepresentacaoComputacional() {
        return super.representacao;
    }

    @Override
    public void printarGrafo() {
        for (int i = 0; i < v.length; i++) {
            System.out.print("|"+i+"|  ");
            for (int j = 0; j < v[i].size() ; j++) {
                System.out.print("-->  |"+v[i].get(j).getDestino()+"|\t  ");
            }
            System.out.println("");
        }
    }

    @Override
    public List<Integer> getAdjacentes(int vertice) {
        List<Integer> l = new ArrayList();
        for (int i = 0; i < v[vertice].size(); i++) {
            l.add(v[vertice].get(i).getDestino());
        }
        return l;
    }

    @Override
    public List<No> getNosAdjacentes(int vertice) {
        List<No> l = new ArrayList();
        for (int i = 0; i < v[vertice].size(); i++) {
            l.add(v[vertice].get(i));
        }
        return l;
    }

    @Override
    public int getNumVertices() {
        return v.length;
    }

}
