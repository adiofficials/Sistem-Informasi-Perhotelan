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

public class NPM07028_Admin2 extends JFrame {

    public NPM07028_Admin2() {
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame_menu1 = new JFrame();
        JButton button_datakamar = new JButton("DATA KAMAR");
        JButton button_rsp1 = new JButton("RESEPSIONIS");

        button_datakamar.setFont(new Font("Consolas", Font.BOLD, 24));
        button_datakamar.setBounds(0, 0, 800, 300);
        button_datakamar.setBackground(Color.black);
        button_datakamar.setForeground(new Color(255, 255, 255));
        button_datakamar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NPM07028_Insert frame_menu2 = new NPM07028_Insert();
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Admin2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        button_rsp1.setFont(new Font("Consolas", Font.BOLD, 24));
        button_rsp1.setBounds(0, 300, 800, 300);
        button_rsp1.setBackground(Color.black);
        button_rsp1.setForeground(Color.white);
        button_rsp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NPM07028_Insert2 frame_menu2 = new NPM07028_Insert2();
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Admin2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        add(button_datakamar);
        add(button_rsp1);
        setVisible(true);
    }
}
