package Model;

public class NPM07028_Checkout {
    public NPM07028_Checkin cekin;
    public int nocekin;    
    public String tanggal;

    public NPM07028_Checkout(int nocekin, int biayakamar, String nama, String tipekamar, String tanggal) {
         // update
//        this.cekin = NPM07028_AllObject.datacheckin.cariObjek(nocekin);
        this.nocekin = cekin.nocekin;        
    }
    
    public int getBiayakamar(){
        return cekin.biayakamar;
    }
    
    public String getTipekamar(){
        return cekin.tipekamar;
    }
    
    public String getTanggal(){
        return cekin.tanggal;
    }
    
    public String getNama(){
        return cekin.idcekin;
    }
}