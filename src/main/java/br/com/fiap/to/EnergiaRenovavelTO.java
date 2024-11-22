package br.com.fiap.to;

public class EnergiaRenovavelTO {
    private int id;
    private String tipo;
    private double eficiencia;
    private double custo;

    // Construtores
    public EnergiaRenovavelTO() {}

    public EnergiaRenovavelTO(int id, String tipo, double eficiencia, double custo) {
        this.id = id;
        this.tipo = tipo;
        this.eficiencia = eficiencia;
        this.custo = custo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
