package perpustakaan.form;

public class UserID {
    private static String kd;
    
    public static void setUserLogin(String kode) {
        kd = kode;
    }
    
    public static String getUserLogin() {
        return kd;
    }   
    
    private static String nm;
    public static void setUserName(String nama) {
        nm = nama;
    }
    
    public static String getUserName() {
        return nm;
    }   
}
