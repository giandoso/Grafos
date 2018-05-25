/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jpgiandoso
 */
public final class Leitor {

    FileReader scanner;
    BufferedReader file;
    ArrayList<int[]> tuplas = new ArrayList<>();
    int menorVertice;
    int maiorVertice;

    public Leitor(String fileName) throws FileNotFoundException, IOException {
        this.scanner = new FileReader(fileName);
        BufferedReader file = new BufferedReader(scanner);
        file.readLine();
        //cria um array list de vetores int
        while (file.ready()) {
            String line = file.readLine();
            if("".equals(line)){
                break;
            }
            int[] aux = new int[2];//tamanho eh a qtd de colunas
            String[] s = line.split(",");
            //popula vet aux com conteudo do arquivo
            aux[0] = Integer.parseInt(s[0].trim());
            aux[1] = Integer.parseInt(s[1].trim());
            //adiciona aux em tuplas
            tuplas.add(aux);
        }
        getMaxMin();
    }

    public ArrayList<int[]> getTuplas() {
        return this.tuplas;
    }

    public void getMaxMin() {
        this.maiorVertice = this.tuplas.get(this.tuplas.size() - 1)[0];
        this.menorVertice = this.tuplas.get(0)[0];
        System.out.println("Menor vertice: " + this.menorVertice);
        System.out.println("Maior vertice: " + this.maiorVertice);
    }

    public void printaTuplas() {
        for (int i = 0; i < this.tuplas.size(); i++) {
            System.out.println("(" + tuplas.get(i)[0] + "," + tuplas.get(i)[1] + ") "+ i);
        }

    }

    public MA buildGrafo_MA() {
        MA grafo = new MA(this.maiorVertice + 1);
        for (int i = this.menorVertice; i < this.tuplas.size(); i++) {
            grafo.addAresta(tuplas.get(i)[0], tuplas.get(i)[1], 1.0);
        }
        return grafo;
    }

    public LA buildGrafo_LA() {
        LA grafo = new LA(this.maiorVertice + 1);
        for (int i = this.menorVertice; i < this.tuplas.size(); i++) {
            grafo.addAresta(tuplas.get(i)[0], tuplas.get(i)[1], 1);
        }
        return grafo;
    }

}
