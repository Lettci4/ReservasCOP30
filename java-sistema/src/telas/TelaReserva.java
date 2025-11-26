package telas;

import modelos.*;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class TelaReserva extends JFrame {

    public TelaReserva() {
        setTitle("Fazer Reserva - COP 30");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(12, 1, 5, 5));

        JTextField nome = new JTextField();
        JTextField email = new JTextField();
        JTextField entrada = new JTextField("2025-11-15");
        JTextField saida = new JTextField("2025-11-20");

        String[] tipos = { "Hotel", "Pousada", "Resort" };
        JComboBox<String> tipoQuarto = new JComboBox<>(tipos);

        JButton confirmar = new JButton("Confirmar Reserva");

        painel.add(new JLabel("Nome completo:"));
        painel.add(nome);
        painel.add(new JLabel("Email:"));
        painel.add(email);
        painel.add(new JLabel("Data de entrada (AAAA-MM-DD):"));
        painel.add(entrada);
        painel.add(new JLabel("Data de saída (AAAA-MM-DD):"));
        painel.add(saida);
        painel.add(new JLabel("Tipo de hospedagem:"));
        painel.add(tipoQuarto);
        painel.add(confirmar);

        add(painel);

        confirmar.addActionListener(e -> {

            Hospede h = new Hospede(nome.getText(), email.getText());

            Quarto q;
            if (tipoQuarto.getSelectedItem().equals("Resort"))
                q = new QuartoLuxo("Resort Luxo", 800);
            else if (tipoQuarto.getSelectedItem().equals("Hotel"))
                q = new Quarto("Hotel Standard", 450);
            else
                q = new Quarto("Pousada", 250);

            Reserva r = new Reserva(
                    h,
                    q,
                    LocalDate.parse(entrada.getText()),
                    LocalDate.parse(saida.getText())
            );

            new TelaConfirmacao(r);
            dispose();
        });

        setVisible(true);
}
}
