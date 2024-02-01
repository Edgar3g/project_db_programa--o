package aej.ui;

import aej.database.DBConnection;
import aej.repository.CostumerImpl;
import aej.repository.CostumerRespository;
import aej.service.CostumerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class CostumerRegistrationApp {

    private CostumerService costumerService;

    public CostumerRegistrationApp(CostumerService costumerService) {
        this.costumerService = costumerService;
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Costumer Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("NIF:"));
        JTextField nifField = new JTextField();
        panel.add(nifField);

        panel.add(new JLabel("Phone Number:"));
        JTextField phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        panel.add(new JLabel("Balance to Pay:"));
        JTextField balanceToPayField = new JTextField();
        panel.add(balanceToPayField);

        JButton registerButton = new JButton("Register Costumer");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String nif = nifField.getText();
                String phoneNumber = phoneNumberField.getText();
                String balanceToPay = balanceToPayField.getText();

                costumerService.registerCostumer(name, nif, phoneNumber, balanceToPay);

                // Adicione uma mensagem ou lógica adicional conforme necessário
                JOptionPane.showMessageDialog(frame, "Costumer registered successfully!");
            }
        });
        panel.add(registerButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Utilize a classe DBConnection para obter uma conexão com o banco de dados
        try {
            Connection connection = DBConnection.connect();

            // Substitua CostumerRepositoryImpl pelo nome correto da sua implementação do repositório
            CostumerRespository costumerRespository = new CostumerImpl(connection);
            CostumerService costumerService = new CostumerService(costumerRespository);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new CostumerRegistrationApp(costumerService);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
