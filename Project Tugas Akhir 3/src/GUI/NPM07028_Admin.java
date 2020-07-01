package GUI;

import Model.NPM07028_Modelinsertkamar;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.IOException;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class NPM07028_Admin extends JFrame {

    NPM07028_Modelinsertkamar modelinsert;

    public NPM07028_Admin() {

        JFrame frame_admin = new JFrame();
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel judul = new JLabel("Sistem Informasi Perhotelan");
        judul.setFont(new Font("Consolas", Font.BOLD, 28));
        judul.setBounds(170, 80, 500, 30);
        judul.setForeground(Color.white);

        getContentPane().setBackground(Color.black);
        JButton button_admin = new JButton("ADMIN");
        JButton button_rsp = new JButton("RESEPSIONIS");

        button_admin.setFont(new Font("Consolas", Font.BOLD, 24));
        button_admin.setBounds(100, 200, 300, 150);
        button_admin.setBackground(Color.black);
        button_admin.setForeground(Color.white);
        button_admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NPM07028_Admin2 frame_menu1 = new NPM07028_Admin2();
                dispose();
            }
        });

        button_rsp.setFont(new Font("Consolas", Font.BOLD, 24));
        button_rsp.setBounds(400, 200, 300, 150);
        button_rsp.setBackground(Color.black);
        button_rsp.setForeground(Color.white);
        button_rsp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NPM07028_Resepsionis frame_regis = new NPM07028_Resepsionis();
                dispose();
            }
        });

        add(button_admin);
        add(button_rsp);
        add(judul);
        setVisible(true);

    }
}
