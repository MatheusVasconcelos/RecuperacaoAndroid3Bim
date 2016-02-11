package com.ifpb30_01_16.projeto_3bimestre.model;

public class ValorCaloricoTotal {


    private double peso;
    private int altura;
    private String dataDeNascimento;
    private String sexo;
    private int nivel;

   public ValorCaloricoTotal(){

   }

    public ValorCaloricoTotal(double peso, int altura, String dataDeNascimento, String sexo, int nivel) {
        this.peso = peso;
        this.altura = altura;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.nivel = nivel;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "ValorCaloricoTotal{" +
                "peso=" + peso +
                ", altura=" + altura +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
