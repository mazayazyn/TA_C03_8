package apap.ta.sifactory.model;

public enum JenisKategori {
    BUKU("BUKU"),//1
    DAPUR("DAPUR"),//2
    MAKANAN_DAN_MINUMAN("MAKANAN & MINUMAN"),//3
    ELEKTRONIK("ELEKTRONIK"),//4
    FASHION("FASHION"),//5
    KECANTIKAN_DAN_PERAWATAN_DIRI("KECANTIKAN & PERAWATAN DIRI"),//6
    FILM_DAN_MUSIK("FILM & MUSIK"),//7
    GAMING("GAMING"),//8
    GADGET("GADGET"),//9
    KESEHATAN("KESEHATAN"),//10
    RUMAH_TANGGA("RUMAH TANGGA"),//11
    FURNITURE("FURNITURE"),//12
    ALAT_DAN_PERANGKAT_KERAS("ALAT & PERANGKAT KERAS"),//13
    WEDDING("WEDDING");//14

    public final String kategori;

    private JenisKategori(String kategori){
        this.kategori=kategori;
    }

    public String getKategori() {
        return kategori;
    }

}
