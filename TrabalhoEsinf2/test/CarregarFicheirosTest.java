/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Ana Rita Veiga
 */
public class CarregarFicheirosTest {

    private static CarregarFicheiros instance;

    public CarregarFicheirosTest() {
        
    }

    @BeforeClass
    public static void setUp() throws IOException {
        instance = new CarregarFicheiros();
        List<String> p = Files.lines(Paths.get("paises.txt")).collect(Collectors.toList());
        List<String> f = Files.lines(Paths.get("fronteiras.txt")).collect(Collectors.toList());
        instance.getPaises(p, f);
        System.out.println("Ficheiros carregados com sucesso!! \n\n");
    }

    /**
     * Test of milesFronteiras method, of class CarregarFicheiros.
     */
    @Test
    public void testMilesFronteiras() {
//        Pais pais1 = new Pais("chile", "americasul", 16.80, "santiago", Float.parseFloat("-33.4569400"), Float.parseFloat(" -70.6482700"));
//        Pais pais2 = new Pais("argentina", "americasul", 41.67, "buenosaires", Float.parseFloat("-34.6131500"), Float.parseFloat(" -58.3772300"));
//        Pais pais3 = new Pais(" uruguai", "americasul", 3.35, "montevideu", Float.parseFloat("-34.9032800"), Float.parseFloat("-56.1881600"));
//        Pais pais4 = new Pais("paraguai", "americasul", 6.24, "assuncao", Float.parseFloat(" -25.3006600"), Float.parseFloat(" -57.6359100"));
//        Pais pais6 = new Pais("bolivia", "americasul", 9.70, "lapaz", Float.parseFloat("-16.5000000"), Float.parseFloat(" -68.1500000"));
//        Pais pais7 = new Pais("peru", "americasul", 28.22, "lima", Float.parseFloat("-12.0431800"), Float.parseFloat("-77.0282400"));
//        Pais pais5 = new Pais("brasil", "americasul", 206.12, "brasilia", Float.parseFloat("-15.7797200"), Float.parseFloat("-47.9297200"));

        Pais pais01 = new Pais("argentina", "americasul", 41.67, "buenosaires", Float.parseFloat("-34.6131500"), Float.parseFloat(" -58.3772300"));
        Pais pais02 = new Pais("bolivia", "americasul", 9.70, "lapaz", Float.parseFloat("-16.5000000"), Float.parseFloat(" -68.1500000"));
        int v = 2235;
        int numV = (int) instance.milesFronteiras(pais01, pais02);
        System.out.printf("Distancia Esperada: %d \nDistancia Obtida: %d \n\n", v, numV);
        assertEquals(v, numV);
    }

    /**
     * Test of numV method, of class CarregarFicheiros.
     */
    @Test
    public void testNumV() {

        int v = 59;
        int numV = instance.numV();
        assertEquals(numV, v);

    }

    /**
     * Test of numA method, of class CarregarFicheiros.
     */
    @Test
    public void testNumA() {
        int v = 0;
        Pais pais1 = new Pais("chipre", "europa", 0.85, "nicosia", Float.parseFloat("35.167604"), Float.parseFloat("33.373621"));
        Pais pais2 = new Pais("islandia", "europa", 0.34, "reiquiavique", Float.parseFloat("64.135338"), Float.parseFloat("-21.89521"));
        int numV = instance.numA(pais1);
        System.out.printf("Numero Arestas Esperadas: %d \nNumero Arestas Obtidas: %d \n\n", v, numV);
        assertEquals(v, numV);
    }

    /**
     * Test of paisesAdjacentes method, of class CarregarFicheiros.
     */
    @Test
    public void testPaisesAdjacentes() {

        Pais pais1 = new Pais("argentina", "americasul", 41.67, "buenosaires", Float.parseFloat("-34.6131500"), Float.parseFloat(" -58.3772300"));
        Pais pais2 = new Pais("russia", "europa", 146.5, "moscovo", Float.parseFloat("55.755786"), Float.parseFloat("37.617633"));

        boolean exp = false;
        boolean res = instance.paisesAdjacentes(pais1, pais2);
        assertEquals(exp, res);

    }

    /**
     * Test of listaAdjacentes method, of class CarregarFicheiros.
     */
    @Test
    public void testListaAdjacentes() {
        Pais pais8 = new Pais("montenegro", "europa", 0.62, "podgorica", Float.parseFloat("42.442575"), Float.parseFloat("19.268646"));

        Iterable<Pais> res = instance.listaAdjacentes(pais8);
        System.out.println(res);

    }

    /**
     * Test of ordenarPais method, of class CarregarFicheiros.
     */
    @Test
    public void testOrdenarPais() {
         Pais[] paises = new Pais[8];
        Pais[] paisesObtido = new Pais[8];
        Pais pais1 = new Pais("argentina", "americasul", 41.67, "buenosaires", Float.parseFloat("-34.6131500"), Float.parseFloat(" -58.3772300"));
        Pais pais2 = new Pais("russia", "europa", 146.5, "moscovo", Float.parseFloat("55.755786"), Float.parseFloat("37.617633"));
        Pais pais3 = new Pais("brasil", "americasul", 206.12, "brasilia", Float.parseFloat("-15.7797200"), Float.parseFloat("-47.9297200"));
        Pais pais4 = new Pais("bolivia", "americasul", 9.70, "lapaz", Float.parseFloat("-16.5000000"), Float.parseFloat(" -68.1500000"));
        Pais pais5 = new Pais("austria", "europa", 8.77, "viena", Float.parseFloat("48.2092062"), Float.parseFloat("16.3727778"));
        Pais pais6 = new Pais("moldavia", "europa", 3.55, "chisinau", Float.parseFloat("47.026859"), Float.parseFloat("28.841551"));
        Pais pais7 = new Pais("alemanha", "europa", 82.8, "berlim", Float.parseFloat("52.5234051"), Float.parseFloat("13.4113999"));
        Pais pais8 = new Pais("luxemburgo", "europa", 0.59, "luxemburgo", Float.parseFloat("49.815273"), Float.parseFloat("6.129583"));

        paises[0] = pais5;
        paises[1] = pais6;
        paises[2] = pais7;
        paises[3] = pais3;
        paises[4] = pais2;
        paises[5] = pais4;
        paises[6] = pais8;
        paises[7] = pais1;

        paisesObtido = instance.ordenarPais(paises);
        System.out.printf("Paises Obtidos:\n");
        for (int i = 0; i < paisesObtido.length; i++) {
            System.out.println(paisesObtido[i]);
        }
        System.out.printf("\n");
        assertEquals(paises, paisesObtido);
    }

    /**
     * Test of colorirGrafo method, of class CarregarFicheiros.
     */
    @Test
    public void testColorirGrafo() {
         int[] cor = new int[59];
        cor[0] = 1;
        cor[1] = 1;
        cor[2] = 2;
        cor[3] = 1;
        cor[4] = 1;
        cor[5] = 2;
        cor[6] = 3;
        cor[7] = 2;
        cor[8] = 3;
        cor[9] = 2;
        cor[10] = 3;
        cor[11] = 2;
        cor[12] = 4;
        cor[13] = 2;
        cor[14] = 2;
        cor[15] = 1;
        cor[16] = 3;
        cor[17] = 3;
        cor[18] = 4;
        cor[19] = 3;
        cor[20] = 1;
        cor[21] = 1;
        cor[22] = 4;
        cor[23] = 4;
        cor[24] = 2;
        cor[25] = 2;
        cor[26] = 5;
        cor[27] = 3;
        cor[28] = 4;
        cor[29] = 3;
        cor[30] = 1;
        cor[31] = 2;
        cor[32] = 3;
        cor[33] = 4;
        cor[34] = 2;
        cor[35] = 2;
        cor[36] = 4;
        cor[37] = 3;
        cor[38] = 1;
        cor[39] = 4;
        cor[40] = 2;
        cor[41] = 2;
        cor[42] = 1;
        cor[43] = 3;
        cor[44] = 3;
        cor[45] = 3;
        cor[46] = 1;
        cor[47] = 1;
        cor[48] = 1;
        cor[49] = 1;
        cor[50] = 3;
        cor[51] = 1;
        cor[52] = 1;
        cor[53] = 2;
        cor[54] = 2;
        cor[55] = 2;
        cor[56] = 1;
        cor[57] = 1;
        cor[58] = 1;

        int[] corObtida = instance.colorirGrafo();
        System.out.printf("Cores Obtidas:     Cores Esperadas:\n");
        for (int i = 0; i < corObtida.length; i++) {
            System.out.printf("%d                  %d", corObtida[i], cor[i]);
            System.out.printf("\n");
        }
        System.out.printf("\n");
        Assert.assertArrayEquals(cor, corObtida);
    }


    /**
     * Test of calcularCaminhoMaisCurto method, of class CarregarFicheiros.
     */
    @Test
    public void testCalcularCaminhoMaisCurto() {
         Pais pais2 = new Pais("argentina", "americasul", 41.67, "buenosaires", Float.parseFloat("-34.6131500"), Float.parseFloat(" -58.3772300"));
        Pais pais1 = new Pais("chile", "americasul", 16.80, "santiago", Float.parseFloat("-33.4569400"), Float.parseFloat(" -70.6482700"));
        Pais pais3 = new Pais("uruguai", "americasul", 3.35, "montevideu", Float.parseFloat("-34.9032800"), Float.parseFloat("-56.1881600"));
        Pais pais4 = new Pais("paraguai", "americasul", 6.24, "assuncao", Float.parseFloat(" -25.3006600"), Float.parseFloat(" -57.6359100"));
        Pais pais5 = new Pais("brasil", "americasul", 206.12, "brasilia", Float.parseFloat("-15.7797200"), Float.parseFloat("-47.9297200"));
        Pais pais6 = new Pais("bolivia", "americasul", 9.70, "lapaz", Float.parseFloat("-16.5000000"), Float.parseFloat(" -68.1500000"));
        Pais pais7 = new Pais("peru", "americasul", 28.22, "lima", Float.parseFloat("-12.0431800"), Float.parseFloat("-77.0282400"));
        Pais pais8 = new Pais("lituania", "europa", 2.85, "vilnius", Float.parseFloat(" 54.6893865"), Float.parseFloat("25.2800243"));
        Pais pais9 = new Pais("russia", "europa", 146.5, "moscovo", Float.parseFloat("55.755786"), Float.parseFloat("37.617633"));

        LinkedList<Pais> exp = new LinkedList<>();
        exp.add(pais1);
        exp.add(pais2);
        exp.add(pais5);

        LinkedList<Pais> res = instance.calcularCaminhoMaisCurto(pais1, pais5);
        System.out.println("\nO caminho mais curto é:");

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        assertEquals(exp, res);

    
    }

    /**
     * Test of calcularCaminhoMaisCurtoComCapitais method, of class
     * CarregarFicheiros.
     */
    @Test
    public void testCalcularCaminhoMaisCurtoComCapitais() {
    }

    /**
     * Test of fatorial method, of class CarregarFicheiros.
     */
    @Test
    public void testFatorial() {
         int exp = 24;
        int n = 4;
        int res = instance.fatorial(n);
        System.out.println("\nO fatorial de " + n + " é:" + res);
        assertEquals(exp, res);
    }

    /**
     * Test of permutacoes method, of class CarregarFicheiros.
     */
    @Test
    public void testPermutacoes() {
         Pais pais2 = new Pais("argentina", "americasul", 41.67, "buenosaires", Float.parseFloat("-34.6131500"), Float.parseFloat(" -58.3772300"));
        Pais pais1 = new Pais("chile", "americasul", 16.80, "santiago", Float.parseFloat("-33.4569400"), Float.parseFloat(" -70.6482700"));

        LinkedList<Pais> lista = new LinkedList<>();
        lista.add(pais2);
        lista.add(pais1);
        ArrayList<LinkedList<Pais>> res = instance.permutacoes(lista);
        System.out.println("\nAs permutações dos paises intermédios são:");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}
