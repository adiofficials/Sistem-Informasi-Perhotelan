package Model;

import Model.NPM07028_Resepsionis;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NPM07028_Modelinsertresepsionis {

    private Koneksi koneksi;

    public NPM07028_Modelinsertresepsionis() {
        this.koneksi = new Koneksi();
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel modelResepsionis = new DefaultTableModel();
        modelResepsionis.addColumn("Nama Admin");
        modelResepsionis.addColumn("Jenis Admin");
        modelResepsionis.addColumn("Telepon Admin");
        modelResepsionis.addColumn("Alamat Admin");

        ResultSet rs = this.koneksi.GetData("SELECT nama_admin, jenis_admin, telp, alamat "
                + "FROM admin_07028");
        while (rs.next()) {
            Object[] temp = new Object[4];
            temp[0] = rs.getString("nama_admin");
            temp[1] = rs.getString("jenis_admin");
            temp[2] = rs.getString("telp");
            temp[3] = rs.getString("alamat");
            modelResepsionis.addRow(temp);
        }
        return modelResepsionis;
    }
}
