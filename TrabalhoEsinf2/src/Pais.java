/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Objects;

/**
 *
 * @author jujps00
 */
public class Pais {

    /**
     * O nome do pais
     */
    private String nome;
    /**
     * O continente do pais
     */
    private String continente;
    /**
     * A populacao do pais
     */
    private Double populacao;
    /**
     * A capital do pais
     */
    private String capital;
    /**
     * A latitude do pais
     */
    private float latitude;
    /**
     * A longitude do pais
     */
    private float longitude;

    /**
     * Construtor de um pais onde os atributos sao:
     *
     * @param nome
     * @param continente
     * @param populacao
     * @param capital
     * @param latitude
     * @param longitude
     *
     */
    public Pais(String nome, String continente, Double populacao, String capital, float latitude, float longitude) {
        this.nome = nome;
        this.continente = continente;
        this.populacao = populacao;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Retorna o nome do pais
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Permite alterar o nome do pais
     *
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o continente do pais
     *
     * @return the continente
     */
    public String getContinente() {
        return continente;
    }

    /**
     * Permite alterar o continente de um pais
     *
     * @param continente the continente to set
     */
    public void setContinente(String continente) {
        this.continente = continente;
    }

    /**
     * Retorna a populacao do pais
     *
     * @return the populacao
     */
    public Double getPopulacao() {
        return populacao;
    }

    /**
     * Permite alterar a populacao do pais
     *
     * @param populacao the populacao to set
     */
    public void setPopulacao(Double populacao) {
        this.populacao = populacao;
    }

    /**
     * Retorna a capital do pais
     *
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Permite alterar a capital do pais
     *
     * @param capital the capital to set
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Retorna a latitude do pais
     *
     * @return the latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Permite alterar a latitude do pais
     *
     * @param latitude the latitude to set
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Retorna a longitude do pais
     *
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Permite alterar a longitude do pais
     *
     * @param longitude the longitude to set
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Permite verificar se o nome de dois paises sao iguais
     *
     * @return true se o nome dos paises sao iguais ou false caso o nome dos
     * paises sejam diferentes
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // null check
        if (obj == null) {
            return false;
        }
        // type check and cast
        if (getClass() != obj.getClass()) {
            return false;
        }
        // field comparison
        Pais o = (Pais) obj;
        return (Objects.equals(nome, o.nome));
    }

    /**
     *
     * Retorna um hash code associado
     *
     * @return o hashcode
     */
    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    /**
     * Compara dois paises
     *
     * @param o
     *
     */
    public int compareTo(Pais o) {
        int x = (this.nome).compareTo(o.nome);
        return x;
    }

    /**
     * Imprime um pais
     *
     * @return o pais
     */
    @Override
    public String toString() {
        return "Pais{" + "nome=" + nome + ", populacao=" + populacao + '}';
    }

}
