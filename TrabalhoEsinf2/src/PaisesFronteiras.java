
import graphbase.Edge;
import graphbase.Graph;
import graphbase.GraphAlgorithms;
import static graphbase.GraphAlgorithms.BreadthFirstSearch;
import static graphbase.GraphAlgorithms.shortestPath;
import static graphbase.GraphAlgorithms.shortestPaths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DEI-ESINF
 */
public class PaisesFronteiras {

    private Graph<Pais, Integer> paisesFronteiras;

    public PaisesFronteiras() {
        paisesFronteiras = new Graph<>(false);
//is directed=true significa grafo direcionado
    }

    public void addPais(Pais vert) {

        paisesFronteiras.insertVertex(vert);
    }

    public Pais getPais(String vert) {
        for (Pais p : paisesFronteiras.allkeyVerts()) {
            if (p.getNome().equalsIgnoreCase(vert)) {
                return p;
            }
        }
        return null;
    }

    public void addFronteira(Pais a1, Pais a2, Integer npasseng, double miles) {

        paisesFronteiras.insertEdge(a1, a2, npasseng, miles);

    }

    public int keyPaises(Pais paises) {
        return paisesFronteiras.getKey(paises);
    }

    public Pais paisesbyKey(int key) {
        if (key > paisesFronteiras.numVertices()) {
            return null;
        }
        Pais[] nomesPais = paisesFronteiras.allkeyVerts();
        return nomesPais[key - 1];
    }

    public int narestas(Pais vert) {

        int degree = paisesFronteiras.outDegree(vert);

        return degree;
    }

    public String distanciaMaxPaises() {

        String str = "";
        double maxmiles = 0;

        for (Edge<Pais, Integer> edge : paisesFronteiras.edges()) {
            if (maxmiles == edge.getWeight()) {
                str += edge.getVOrig() + "" + edge.getVDest() + "\n";
            }
            if (maxmiles < edge.getWeight()) {
                str = "";
                maxmiles = edge.getWeight();
                str += edge.getWeight() + "" + edge.getVDest() + "\n";
            }
        }
        return str;
    }

    public boolean connectPaises(Pais pais1, Pais pais2) {
        if (!paisesFronteiras.validVertex(pais1) || !paisesFronteiras.validVertex(pais2)) {
            return false;
        }
        LinkedList<Pais> qbfs = BreadthFirstSearch(paisesFronteiras, pais1);

        if (qbfs.contains(pais2)) {
            return true;
        }

        return false;
    }

    public boolean paisesAdjacentes(Pais p1, Pais p2) {
        Iterable<Pais> listAdaj = paisesFronteiras.adjVertices(p1);
        for (Pais pais : listAdaj) {
            if (pais.equals(p2)) {
                return true;
            }
        }
        return false;
    }

    public Iterable<Pais> listaAdjacentes(Pais p1) {
        Iterable<Pais> listAdaj = paisesFronteiras.adjVertices(p1);
        return listAdaj;
    }

    @Override
    public String toString() {
        return paisesFronteiras.toString();
    }

    public int totalKeys() {
        Pais[] allkeyVerts = paisesFronteiras.allkeyVerts();
        int length = allkeyVerts.length;
        return length;
    }

    public int[] colorirGrafo() {

        int i = 0, cor = 1;
        Pais temp;
        Pais[] paises = new Pais[totalKeys()];
        int[] resultado = new int[totalKeys()];
        boolean[] colorido = new boolean[totalKeys()];

        for (Pais p : paisesFronteiras.allkeyVerts()) {
            paises[i] = p;
            i++;
        }
        paises = ordenarPais(paises);

        for (int j = 0; j < paises.length; j++) {
            if (narestas(paises[j]) == 0) {
                resultado[j] = 1;
                colorido[j] = true;
            }
            if (!colorido[j]) {
                resultado[j] = cor;
                colorido[j] = true;
                for (i = j + 1; i < paises.length - 1; i++) {
                    if (!colorido[i]) {
                        for (int k = 0; k < resultado.length; k++) {
                            if (k != i) {
                                if (resultado[k] == cor) {
                                    if (!paisesAdjacentes(paises[k], paises[i])) {
                                        resultado[i] = cor;
                                        colorido[i] = true;
                                    } else {
                                        resultado[i] = 0;
                                        colorido[i] = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                cor++;
            }
        }
        return resultado;
    }

    public Pais[] ordenarPais(Pais[] paises) {
        Pais temp;
        for (int i = 0; i < paises.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < paises.length; j++) {
                if (narestas(paises[j]) > narestas(paises[max])) {
                    max = j;
                }
            }
            temp = paises[i];
            paises[i] = paises[max];
            paises[max] = temp;
        }
        return paises;
    }

    public double milesFronteiras(Pais pais1, Pais pais2) {

        double d2 = 0.017453292519943295769236;
        double latitudeRad = (pais1.getLatitude());
        double longitudeRad = (pais1.getLongitude());
        double latitude2Rad = (pais2.getLatitude());
        double longitude2Rad = (pais2.getLongitude());

        double diferencaLat = (latitude2Rad - latitudeRad) * d2;
        double diferencaLong = (longitude2Rad - longitudeRad) * d2;

        double a = Math.sin(diferencaLat / 2) * Math.sin(diferencaLat / 2) + Math.cos(latitudeRad * d2) * Math.cos(latitude2Rad * d2) * Math.sin(diferencaLong / 2) * Math.sin(diferencaLong / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = (6368.1 * c);
        return d;
    }

    public LinkedList<Pais> calcularCaminhoMaisCurto(Pais pais1, Pais pais2) {
        double shortestPath = 0;
        if (!paisesFronteiras.validVertex(pais1) || !paisesFronteiras.validVertex(pais2)) {
            return null;
        }
        ArrayList<Double> dists = new ArrayList<>();
        ArrayList<LinkedList<Pais>> allPaths = GraphAlgorithms.allPaths(paisesFronteiras, pais1, pais2);
        LinkedList<Pais> shortPath = new LinkedList<>();
        for (int i = 0; i < allPaths.size(); i++) {
            dists.add(milesFronteiras(allPaths.get(i).getFirst(), allPaths.get(i).getLast()));

        }
        boolean shortestPaths = shortestPaths(paisesFronteiras, pais1, allPaths, dists);
        if (shortestPaths) {
            shortestPath = shortestPath(paisesFronteiras, pais1, pais2, shortPath);
        }
        for (int i = 0; i < allPaths.size(); i++) {
            if (dists.get(i).equals(shortestPath)) {
                return allPaths.get(i);
            }
        }
        System.out.println("Os paises distam-se " + (int) shortestPath + "km");
        return null;
    }

    public int fatorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    public ArrayList<LinkedList<Pais>> permutacoes(LinkedList<Pais> lista) {
        ArrayList<LinkedList<Pais>> tempList = new ArrayList<>();
        while (tempList.size() != fatorial(lista.size())) {
            Collections.shuffle(lista);
            LinkedList<Pais> list = new LinkedList<>(lista);
            if (!tempList.contains(list)) {
                tempList.add(list);
            }

        }
        return tempList;
    }

    public LinkedList<Pais> calcularCaminhoMaisCurtoComCapitais(Pais paisOrigem, Pais paisDestino, LinkedList<Pais> capitaisObrigatorias) {
        double shortestPath = 0;
        ArrayList<Double> dists = new ArrayList<>();
        ArrayList<LinkedList<Pais>> allPaths = GraphAlgorithms.allPaths(paisesFronteiras, paisOrigem, paisDestino);
        LinkedList<Pais> caminhoMaisCurto = new LinkedList<>();
        ArrayList<LinkedList<Pais>> permutacoes = permutacoes(capitaisObrigatorias);
        for (int i = 0; i < permutacoes.size(); i++) {
            dists.add(milesFronteiras(permutacoes.get(i).getFirst(), permutacoes.get(i).getLast()));
        }
        boolean shortestPaths = shortestPaths(paisesFronteiras, paisOrigem,allPaths, dists);
        if (shortestPaths) {
            shortestPath = shortestPath(paisesFronteiras, paisOrigem, paisDestino, caminhoMaisCurto);
        }
        for (int i = 0; i < permutacoes.size(); i++) {
            if (dists.get(i).equals(shortestPath)) {
                return permutacoes.get(i);
            }
        }
return null;
}
}
