package telas;

import java.awt.*;
import javax.swing.*;
import modelos.Reserva;

public class TelaConfirmacao extends JFrame {
    public TelaConfirmacao(Reserva reserva) {
        setTitle("Reserva Confirmada");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea texto = new JTextArea(reserva.resumo());
        texto.setEditable(false);
        texto.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton voltar = new JButton("Voltar ao Início");
        voltar.addActionListener(e -> {
            new TelaInicial();
            dispose();
        });

        add(new JScrollPane(texto), BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);

        setVisible(true);
    }
}