package Model;

import javax.swing.JTextField;

public class NPM07028_Checkin {

    public String tipekamar;
    public int nocekin;
    public String idcekin;
    public int biayakamar;
    public String tanggal;

    public NPM07028_Checkin(int nocekin, String idcekin, String tipekamar, int biayakamar, String tanggal) {
        this.tipekamar = tipekamar;
        this.nocekin = nocekin;
        this.idcekin = idcekin;
        this.biayakamar = biayakamar;
        this.tanggal = tanggal;
    }
}
