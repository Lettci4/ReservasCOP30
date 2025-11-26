package modelos;

import interfaces.Reservavel;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva implements Reservavel {

    private Hospede hospede;
    private Quarto quarto;
    private LocalDate entrada;
    private LocalDate saida;

    public Reserva(Hospede hospede, Quarto quarto, LocalDate entrada, LocalDate saida) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Reserva(Hospede hospede, Quarto quarto) {
        this(hospede, quarto, LocalDate.now(), LocalDate.now().plusDays(1));
    }

    @Override
    public double calcularValor() {
        long dias = ChronoUnit.DAYS.between(entrada, saida);
        return quarto.getDiaria() * dias;
    }

    public String resumo() {
        return "===== RESERVA COP 30 =====\n" +
                "\nHóspede: " + hospede.getNome() +
                "\nEmail: " + hospede.getEmail() +
                "\nTipo de Quarto: " + quarto.getTipo() +
                "\nEntrada: " + entrada +
                "\nSaída: " + saida +
                "\nValor Total: R$ " + calcularValor() +
                "\n=============================";
    }
}
