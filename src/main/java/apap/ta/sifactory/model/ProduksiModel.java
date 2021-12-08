package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "produksi")
public class ProduksiModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produksi;

    //merujuk ke siitem
    @NotNull
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Integer id_item;

    @NotNull
    @Column(nullable = false)
    private Integer id_kategori;

    @NotNull
    @Column(nullable = false)
    private Integer tambahan_stok;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggal_produksi;

//    @NotNull
//    @Column(nullable = false)
//    private Integer id_pegawai;

    @NotNull
    @Column(nullable = false)
    private Integer id_request_update_item;

//    @NotNull
//    @Column(nullable = false)
//    private Integer id_mesin;

    //Relasi dengan Request Update Item
    @OneToOne(mappedBy = "produksi",fetch = FetchType.LAZY)
    private RequestUpdateItemModel requestupdate;

    //Relasi dengan Mesin
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_mesin", referencedColumnName = "id_mesin", nullable = true)
    private MesinModel mesin;

    //Relasi dengan Pegawai
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", nullable = false)
    private PegawaiModel pegawai;
}
