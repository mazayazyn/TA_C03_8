package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    //Merujuk ke SI-Item
    @NotNull
    @Column(name = "id_item", nullable = false)
    private String idItem;

    @NotNull
    @Column(name = "id_kategori", nullable = false)
    private Integer idKategori;

    @NotNull
    @Column(name = "tambahan_stok", nullable = false)
    private Integer tambahanStok;

    @Column(name = "tanggal_produksi", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalProduksi;

    //Relasi dengan Request Update Item
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_request_update_item", referencedColumnName = "id_request_update_item", nullable = true)
    private RequestUpdateItemModel requestUpdateItem;

    //Relasi dengan Mesin
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_mesin", referencedColumnName = "id_mesin", nullable = false)
    private MesinModel mesin;

    //Relasi dengan Pegawai
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", nullable = false)
    private PegawaiModel pegawai;
}
