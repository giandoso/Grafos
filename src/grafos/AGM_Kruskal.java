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
public class AGM_Kruskal {

    GrafoAbstrato grafo;
    List<Aresta> X = new ArrayList<>();
    List<Aresta> A;
    ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();

    public AGM_Kruskal(GrafoAbstrato grafo) {
        this.grafo = grafo;
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            criarConjunto(i);
        }
        A = grafo.getArestasOrdenadas();
//        IMPRIME A
//        for (int j = 0; j < A.size(); j++) {
//            System.out.print(A.get(j).getOrigem() + ",");
//            System.out.print(A.get(j).getDestino() + ",") ;
//            System.out.println(A.get(j).getPeso());
//        }
        for (Aresta a : A) {
            int v1 = a.getOrigem();
            int v2 = a.getDestino();
            
            System.out.println(v1 +","+ v2);
            System.out.println(X.size());
            if ((c.get(v1).equals(c.get(v2))) == false && X.size() < grafo.getNumVertices()) {
                //encontrar uma maneira de substituir elementos caso ja esteja na lista
                X.add(a);
                aplicarUniao(v1, v2);
            }
        }
    }

    private void criarConjunto(int e) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(e);
        c.add(l);
    }

    private void aplicarUniao(int u, int v) {
        ArrayList<Integer> l = c.get(u);
        System.out.println(c.get(u));
        System.out.println(c.get(v));
        for (Integer get : c.get(v)) {
            if(l.contains(get) == false){
                l.add(get);
            }
        }
        c.set(u, l);
        c.set(v, l);
        System.out.println(c.get(u));
//        c.remove(v);
        System.out.println(c.get(v));
    }

    public void getResults() {
        double totalPeso = 0;
        for (int i = 0; i < X.size(); i++) {
            System.out.print(X.get(i).getOrigem() + "\t|");
            System.out.print(X.get(i).getDestino() + "\t|");
            System.out.print(X.get(i).getPeso() + "");
            System.out.println("");
            totalPeso += X.get(i).getPeso();
        }
        System.out.println("Peso: " + totalPeso);
    }

}
