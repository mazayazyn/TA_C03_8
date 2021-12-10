package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(name = "id_produksi")
    private Integer idProduksi;

    //merujuk ke siitem
    @NotNull
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String idItem;

    @NotNull
    @Column(name = "id_kategori", nullable = false)
    private Integer idKategori;

    @NotNull
    @Column(name = "tambahan_stok", nullable = false)
    private Integer tambahanStok;

//    @NotNull
    @Column(name = "tanggal_produksi", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalProduksi;

//    @NotNull
    @Column(name = "id_request_update_item", nullable = true)
    private Integer idRequestUpdateItem;

    //Relasi dengan Request Update Item
    @OneToOne(mappedBy = "produksi",fetch = FetchType.LAZY)
    private RequestUpdateItemModel requestUpdateItem;

    //Relasi dengan Mesin
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "id_mesin", referencedColumnName = "id_mesin", nullable = true)
    @JoinColumn(name = "id_mesin", referencedColumnName = "id_mesin", nullable = false)
    private MesinModel mesin;

    //Relasi dengan Pegawai
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", nullable = false)
    private PegawaiModel pegawai;
}
