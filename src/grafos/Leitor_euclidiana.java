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
public class Leitor_euclidiana {

    FileReader scanner;
    BufferedReader file;
    ArrayList<double[]> tuplas = new ArrayList<>();

    public Leitor_euclidiana(String fileName) throws FileNotFoundException, IOException {
        this.scanner = new FileReader(fileName);
        BufferedReader file = new BufferedReader(scanner);
        file.readLine();
        while (file.ready()) {
            String line = file.readLine();
            if ("".equals(line)) {
                break;
            }
            double[] aux = new double[2];//tamanho eh a qtd de colunas
            String[] s = line.split(",");
//            System.out.println(s.length);
            //popula vet aux com conteudo do arquivo
            aux[0] = Double.parseDouble(s[0].trim());
            aux[1] = Double.parseDouble(s[1].trim());
            //adiciona aux em tuplas
            tuplas.add(aux);
        }
    }

    public void printaTuplas() {
        for (int i = 0; i < this.tuplas.size(); i++) {
            System.out.println("(" + tuplas.get(i)[0] + "," + tuplas.get(i)[1] + ") " + i);
        }

    }

    public MA buildGrafo_MA() {
        MA grafo = new MA(this.tuplas.size());
        for (int i = 0; i < this.tuplas.size(); i++) {
            for (int j = 0; j < this.tuplas.size(); j++) {
                grafo.addAresta(i, j, getDistancia(tuplas.get(i), tuplas.get(j)));
            }
        }
        return grafo;
    }

    public LA buildGrafo_LA() {
        LA grafo = new LA(this.tuplas.size());
        for (int i = 0; i < this.tuplas.size(); i++) {
            for (int j = 0; j < this.tuplas.size(); j++) {
                grafo.addAresta(i, j, getDistancia(tuplas.get(i), tuplas.get(j)));
            }
        }
        return grafo;
    }

    public double getDistancia(double[] v1, double[] v2) {
        double distancia;
        distancia = java.lang.Math.pow((v2[0] - v1[0]), 2) + java.lang.Math.pow((v2[1] - v1[1]), 2);
        distancia = java.lang.Math.pow(distancia, 0.5);
        return distancia;
    }
}
