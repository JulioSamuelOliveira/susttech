package br.com.fiap.to;

public class RelatorioAnaliticoTO {
    private int id;
    private String usuario;
    private double consumoMensal;
    private double custoMensal;

    // Construtores
    public RelatorioAnaliticoTO() {}

    public RelatorioAnaliticoTO(int id, String usuario, double consumoMensal, double custoMensal) {
        this.id = id;
        this.usuario = usuario;
        this.consumoMensal = consumoMensal;
        this.custoMensal = custoMensal;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(double consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }
}
