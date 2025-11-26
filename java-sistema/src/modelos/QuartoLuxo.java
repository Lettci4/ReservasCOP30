package modelos;

public class QuartoLuxo extends Quarto {

    public QuartoLuxo(String tipo, double diaria) {
        super(tipo, diaria);
    }

    @Override
    public double getDiaria() {
        return diaria * 1.5;
    }
}
