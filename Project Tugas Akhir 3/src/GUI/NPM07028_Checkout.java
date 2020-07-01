package GUI;

import Model.NPM07028_AllObject;
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

public class NPM07028_Checkout extends JFrame {

    public NPM07028_Checkout() throws SQLException {
        setSize(700, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JFrame frame_checkout = new JFrame();
        getContentPane().setBackground(Color.PINK);
        JButton button_checkout = new JButton("Check out");
        JButton button_back = new JButton("Back");
        JLabel label_nocekin = new JLabel("No.Check In");
        JLabel label_biaya = new JLabel("Bayar Kamar");
        label_nocekin.setForeground(Color.white);
        label_biaya.setForeground(Color.white);
        JTextField text_nocekin = new JTextField();
        JTextField text_bayar = new JTextField();

        JTable tabel_checkout = new JTable();
        JScrollPane scroll_pane = new JScrollPane(tabel_checkout);
        scroll_pane.setBounds(150, 100, 480, 180);

        button_checkout.setBounds(25, 150, 100, 30);
        button_checkout.setFont(new Font("Consolas", Font.BOLD, 11));
        button_checkout.setBackground(Color.white);
        button_checkout.setForeground(Color.black);
        button_checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int noKamar = Integer.parseInt(text_nocekin.getText());
                    NPM07028_AllObject.datacheckout.delete(noKamar);
                    tabel_checkout.setModel(NPM07028_AllObject.datacheckout.viewTabel());
                }catch(SQLException ex){
                    Logger.getLogger(NPM07028_Checkout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tabel_checkout.setModel(NPM07028_AllObject.datacheckout.viewTabel());


        button_back.setBounds(25, 200, 100, 30);
        button_back.setBackground(Color.white);
        button_back.setForeground(Color.black);
        button_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NPM07028_Admin frame_admin = new NPM07028_Admin();
                dispose();
            }
        });

        text_nocekin.setBounds(150, 50, 100, 30);
        text_bayar.setBounds(400, 50, 100, 30);

        label_nocekin.setFont(new Font("Consolas", Font.BOLD, 12));
        label_nocekin.setBounds(150, 15, 100, 30);
        label_biaya.setFont(new Font("Consolas", Font.BOLD, 12));
        label_biaya.setBounds(400, 15, 100, 30);

        add(label_nocekin);
        add(label_biaya);
        add(button_checkout);
        add(button_back);
        add(text_nocekin);
        add(text_bayar);
        add(scroll_pane);
        setVisible(true);
    }
}
