package modelos;

public class Quarto {
    protected String tipo;
    protected double diaria;

    public Quarto(String tipo, double diaria) {
        this.tipo = tipo;
        this.diaria = diaria;
    }

    public String getTipo() {
        return tipo;
    }

    public double getDiaria() {
        return diaria;
    }
}

