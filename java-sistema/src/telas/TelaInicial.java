package telas;

import javax.swing.*;

public class TelaInicial extends JFrame {

     public TelaInicial() {
        setTitle("COP 30 - Reservas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton botaoReserva = new JButton("Fazer Reserva");
        botaoReserva.addActionListener(e -> {
            new TelaReserva();
            dispose();
        });

        JPanel painel = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Bem-vindo ao Sistema COP 30", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        painel.add(titulo, BorderLayout.CENTER);
        painel.add(botaoReserva, BorderLayout.SOUTH);

        add(painel);
        setVisible(true);
    }

}