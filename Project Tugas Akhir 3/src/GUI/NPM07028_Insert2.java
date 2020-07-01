package GUI;

import Model.NPM07028_Modelinsertresepsionis;
//import static GUI.NPM07028_Insert.list_kamar;
import Model.NPM07028_AllObject;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class NPM07028_Insert2 extends JFrame{
    
    //static ArrayList list_rsp;
    NPM07028_Modelinsertresepsionis modelinsert = new NPM07028_Modelinsertresepsionis();
    
    public NPM07028_Insert2() throws SQLException{
        setSize(700, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        
        
        JFrame frame_menu2 = new JFrame();
        getContentPane().setBackground(Color.PINK);
        JButton button_insert = new JButton("Insert");
        JButton button_view = new JButton("View");
        JButton button_back = new JButton("Back");
        JLabel label_nama = new JLabel("Nama");
        JLabel label_id = new JLabel("Id");
        JLabel label_telepon = new JLabel("Telepon");
        JLabel label_alamat = new JLabel("Alamat");
        JTextField text_nama = new JTextField();
        JTextField text_id = new JTextField();
        JTextField text_telepon = new JTextField();
        JTextField text_alamat = new JTextField();
        TableColumn tc1 = new TableColumn();
        TableColumn tc2 = new TableColumn();
        TableColumn tc3 = new TableColumn();
        TableColumn tc4 = new TableColumn();
        
        String[] field = {"Nama", "View", "Telepon", "Alamat"};
        DefaultTableModel model = new DefaultTableModel(field,0);
        JTable tabel_resepsionis = new JTable(model);
        tc1 = tabel_resepsionis.getColumnModel().getColumn(0);
        tc2 = tabel_resepsionis.getColumnModel().getColumn(1);
        tc3 = tabel_resepsionis.getColumnModel().getColumn(2);
        tc4 = tabel_resepsionis.getColumnModel().getColumn(3);
        tc1.setPreferredWidth(50);
        tc2.setPreferredWidth(50);
        tc3.setPreferredWidth(50);
        tc4.setPreferredWidth(50);
        JScrollPane scroll_pane = new JScrollPane(tabel_resepsionis);
        scroll_pane.setBounds(150,100,480,180);
        
        button_insert.setBounds(25, 100, 100, 30);
        button_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  String nama = text_nama.getText();
                  String id = text_id.getText();
                  String telepon = text_telepon.getText();
                  String alamat = text_alamat.getText();
                try {
                    // update
                    //                  NPM07028_AllObject.dataresepsionis.insert(nama, id, telepon, alamat);
                    tabel_resepsionis.setModel(NPM07028_AllObject.dataresepsionis.viewTabel());
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Insert2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        tabel_resepsionis.setModel(NPM07028_AllObject.dataresepsionis.viewTabel());
                
        button_back.setBounds(25, 150, 100, 30);
        button_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NPM07028_Admin frame_admin = new NPM07028_Admin();
                dispose();
            }
        });
        
        text_nama.setBounds(150, 50, 100, 30);
        text_id.setBounds(275, 50, 100, 30);
        text_telepon.setBounds(400, 50, 100, 30);
        text_alamat.setBounds(525, 50, 100, 30);
        
        label_nama.setFont(new Font("Consolas",Font.BOLD, 12));
        label_nama.setBounds(150, 15, 100, 30);
        label_id.setFont(new Font("Consolas",Font.BOLD, 12));
        label_id.setBounds(275, 15, 100, 30);
        label_telepon.setFont(new Font("Consolas",Font.BOLD, 12));
        label_telepon.setBounds(400, 15, 100, 30);
        label_alamat.setFont(new Font("Consolas",Font.BOLD, 12));
        label_alamat.setBounds(525, 15, 100, 30);
        
        add(label_nama);
        add(label_id);
        add(label_telepon);
        add(label_alamat);
        add(button_insert);
        add(button_view);
        add(button_back);
        add(text_nama);
        add(text_id);
        add(text_telepon);
        add(text_alamat);
        add(scroll_pane);
        setVisible(true);
    }
}
