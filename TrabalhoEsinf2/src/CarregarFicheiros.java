/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Ana Rita Veiga
 */
public class CarregarFicheiros {

    private PaisesFronteiras paisesFronteiras;

    public CarregarFicheiros() {
        paisesFronteiras = new PaisesFronteiras();
    }

    /**
     * Carrega toda a informacao recebida por parametro nos mapas anteriormente
     * criados
     */
    public PaisesFronteiras getPaises(List<String> paises, List<String> fronteiras) {
        String linha = null;
        String[] args;
        String[] temp;
        for (int i = 0; i < paises.size(); i++) {
            linha = paises.get(i);

            args = linha.split(",");
            // criar um pais
            Pais ppp = new Pais(
                    args[0].trim(),
                    args[1].trim(),
                    Double.parseDouble(args[2]),
                    args[3], Float.parseFloat(args[4]),
                    Float.parseFloat(args[5]));

            paisesFronteiras.addPais(ppp);
        }

        for (int k = 0; k < fronteiras.size(); k++) {
            linha = fronteiras.get(k).trim();
            args = linha.split(",");

            Pais pais1 = paisesFronteiras.getPais(args[0].trim());

            Pais pais2 = paisesFronteiras.getPais(args[1].trim());

            double distancia = paisesFronteiras.milesFronteiras(pais1, pais2);
            paisesFronteiras.addFronteira(pais1, pais2, null, distancia);
        }
        return paisesFronteiras;
    }

    public double milesFronteiras(Pais pais1, Pais pais2) {
        return paisesFronteiras.milesFronteiras(pais1, pais2);

    }

    public int numV() {
        int totalKeys = paisesFronteiras.totalKeys();
        return totalKeys;
    }

    public int numA(Pais v) {
        return paisesFronteiras.narestas(v);
    }

    public boolean paisesAdjacentes(Pais pais1, Pais pais2) {
        return paisesFronteiras.paisesAdjacentes(pais1, pais2);
    }

    public Iterable<Pais> listaAdjacentes(Pais pais1) {
        return paisesFronteiras.listaAdjacentes(pais1);
    }

    public Pais[] ordenarPais(Pais[] paises) {
        paisesFronteiras.ordenarPais(paises);
        return paises;
    }

    public int[] colorirGrafo() {
        return paisesFronteiras.colorirGrafo();
    }

    public LinkedList<Pais> calcularCaminhoMaisCurto(Pais pais1, Pais pais2) {
        return paisesFronteiras.calcularCaminhoMaisCurto(pais1, pais2);
    }
    public LinkedList<Pais> calcularCaminhoMaisCurtoComCapitais(Pais paisOrigem, Pais paisDestino, LinkedList<Pais> capitaisObrigatorias) {
    return paisesFronteiras.calcularCaminhoMaisCurtoComCapitais(paisOrigem, paisDestino, capitaisObrigatorias);
    }
    
    public int fatorial(int n) {
        return paisesFronteiras.fatorial(n);
    }
    
   public ArrayList<LinkedList<Pais>> permutacoes(LinkedList<Pais> lista) {
        return paisesFronteiras.permutacoes(lista);
    }

   
}
