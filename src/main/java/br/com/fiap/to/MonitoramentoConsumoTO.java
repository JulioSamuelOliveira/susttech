package br.com.fiap.to;

public class MonitoramentoConsumoTO {
    private int id;
    private String dispositivo;
    private double consumoAtual;
    private boolean alerta;

    // Construtores
    public MonitoramentoConsumoTO() {}

    public MonitoramentoConsumoTO(int id, String dispositivo, double consumoAtual, boolean alerta) {
        this.id = id;
        this.dispositivo = dispositivo;
        this.consumoAtual = consumoAtual;
        this.alerta = alerta;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public double getConsumoAtual() {
        return consumoAtual;
    }

    public void setConsumoAtual(double consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public boolean isAlerta() {
        return alerta;
    }

    public void setAlerta(boolean alerta) {
        this.alerta = alerta;
    }
}
