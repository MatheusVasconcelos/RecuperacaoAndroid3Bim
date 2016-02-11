package com.ifpb30_01_16.projeto_3bimestre.model;

public class IMC {

    private int altura;
    private double peso;


    public IMC() {

    }

    public IMC(int altura, double peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "IMC{" +
                "altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
