package Model;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NPM07028_Modelregis {
    private Koneksi koneksi;
    
    public NPM07028_Modelregis(){
        this.koneksi = new Koneksi();
    }
    
    public void insert(String nama, String alamat, String noTelp){
        String sql = "INSERT INTO booking_07028 (id_booking, nama_pengunjung, alamat_pengunjung, "
                + "telp_pengunjung) VALUES (id_booking.NEXTVAL, '" + nama + "', '" + alamat 
                + "', '" + noTelp + "')";
        this.koneksi.ManipulasiData(sql);
    }
    
    public DefaultTableModel viewTabel() throws SQLException{
        DefaultTableModel modelRegis = new DefaultTableModel();
        modelRegis.addColumn("Nama Pengunjung");
        modelRegis.addColumn("Telp Pengunjung");
        modelRegis.addColumn("Alamat Pengunjung");
        
        ResultSet rs = this.koneksi.GetData("SELECT nama_pengunjung, telp_pengunjung, "
                + "alamat_pengunjung FROM booking_07028");
        while (rs.next()) {
            Object[] temp = new Object[3];
            temp[0] = rs.getString("nama_pengunjung");
            temp[1] = rs.getString("telp_pengunjung");
            temp[2] = rs.getString("alamat_pengunjung");
            modelRegis.addRow(temp);
        }
        return modelRegis;
    }
}
