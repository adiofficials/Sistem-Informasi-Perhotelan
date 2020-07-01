package GUI;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class NPM07028_Resepsionis extends JFrame {

    public NPM07028_Resepsionis() {
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame_regis = new JFrame();
        JFrame frame_checkin = new JFrame();
        JFrame frame_checkout = new JFrame();
        JButton button_regis = new JButton("REGISTRASI");
        JButton button_cekin = new JButton("CHECK IN");
        JButton button_cekout = new JButton("CHECK OUT");

        button_regis.setFont(new Font("Consolas", Font.BOLD, 24));
        button_regis.setBounds(0, 0, 800, 200);
        button_regis.setBackground(Color.black);
        button_regis.setForeground(Color.white);
        button_regis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NPM07028_Registrasi regis = new NPM07028_Registrasi();
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Resepsionis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        button_cekin.setFont(new Font("Consolas", Font.BOLD, 24));
        button_cekin.setBounds(0, 200, 800, 200);
        button_cekin.setBackground(Color.black);
        button_cekin.setForeground(Color.white);
        button_cekin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NPM07028_Checkin checkin = new NPM07028_Checkin();
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Resepsionis.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame_checkin.dispose();
            }
        });

        button_cekout.setFont(new Font("Consolas", Font.BOLD, 24));
        button_cekout.setBounds(0, 400, 800, 200);
        button_cekout.setBackground(Color.black);
        button_cekout.setForeground(Color.white);
        button_cekout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NPM07028_Checkout checkout = new NPM07028_Checkout();
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Resepsionis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        add(button_regis);
        add(button_cekin);
        add(button_cekout);
        setVisible(true);
    }
}
