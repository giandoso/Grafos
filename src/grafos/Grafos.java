/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.IOException;

/**
 *
 * @author jpgiandoso
 */
public class Grafos {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        GrafoAbstrato grafo = null;
        Leitor l;
        String rep = null;
        String origem = null;
        String destino = null;
        Integer vInicial = null;
        Integer pGrafo = null;
        String f = null;
        for (int i = 0; i < args.length; i+=2) {
            switch (args[i]) {
                case "-rep":
                    rep = args[i + 1].toLowerCase();
                    break;
                case "-f":
                    f = args[i + 1];
                    break;
                case "-csvorigem":
                    origem = args[i + 1];
                    break;
                case "-csvdestino":
                    destino = args[i + 1];
                    break;
                case "-verticeinicial":
                    vInicial = Integer.parseInt(args[i + 1]);
                    break;
                case "-grafo":
                    pGrafo = Integer.parseInt(args[i + 1]);
                    break;
            }
        }
        l = new Leitor(origem);
        switch (pGrafo) {
            case 1:
                System.out.print("MA, ");
                grafo = l.buildGrafo_MA();
                break;
            case 2:
                System.out.println("LA, ");
                grafo = l.buildGrafo_LA();
                break;
        }
        switch (rep) {
            case "bfs":
                BFS bfs = new BFS(grafo, vInicial);
                bfs.escreveCSV();
                break;
            case "dfs":
                System.out.print("DFS, ");
                switch (f) {
                    case "r":
                        System.out.println("recursivo");
                        DFS dfs = new DFS(grafo);
                        dfs.escreveCSV(destino);
                        break;
                    case "i":
                        System.out.println("iterativo");
                        DFS_iterativo dfs_i = new DFS_iterativo(grafo);
                        dfs_i.escreveCSV(destino);
                        break;
                }
                break;
        }

    }

}
