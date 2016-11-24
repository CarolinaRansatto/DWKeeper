package com.keeper.company.dwkeeper;

/**
 * Created by gustavo on 18/11/16.
 */

public class FichaHelper {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int nivel;
    private int  atributos [];
    private String classe;
    private String raça;
    private String alinhamento;
    private String nome;
    private int pv_total;
    private int pv_atual;
    private int carga;
    private int dano;
    private int exp;
    private int armadura;



    public FichaHelper(){

    }


    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getArmadura() {
        return armadura;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int[] getAtributos() {
        return atributos;
    }

    public void setAtributos(int[] atributos) {
        this.atributos = atributos;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(String alinhamento) {
        this.alinhamento = alinhamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPv_total() {
        return pv_total;
    }

    public void setPv_total(int pv_total) {
        this.pv_total = pv_total;
    }

    public int getPv_atual() {
        return pv_atual;
    }

    public void setPv_atual(int pv_atual) {
        this.pv_atual = pv_atual;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int[] getAtributo(String atr){
        
        int [] aux = new int [2];
        
        switch (atr){
            case "for":
                aux[0] = atributos[0];
                aux[1] = atributos[1];
                break;
            case "des":
                aux[0] = atributos[2];
                aux[1] = atributos[3];
                break;
            case "con":
                aux[0] = atributos[4];
                aux[1] = atributos[5];
                break;
            case "int":
                aux[0] = atributos[6];
                aux[1] = atributos[7];
                break;
            case "sab":
                aux[0] = atributos[8];
                aux[1] = atributos[9];
                break;
            case "car":
                aux[0] = atributos[10];
                aux[1] = atributos[11];
                break;
        

        }
        return aux;
    }

    public String getAtributosString(){

        String res = "";
        res += atributos[0] + "";
        for(int i = 1; i < atributos.length; i++){
            res +=  "/" +  atributos[i];
        }

        return res;
    }



}
