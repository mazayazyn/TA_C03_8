package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "mesin")
public class MesinModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesin")
    private Integer idMesin;

    @NotNull
    @Size(max=50)
    @Column(name = "nama", nullable= false)
    private String nama;

    //Merujuk ke id_kategori item pada SI-Item
    @NotNull
    @Column(name = "id_kategori", nullable = false)
    private Integer idKategori;

    @NotNull
    @Column(name = "tanggal_dibuat", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalDibuat;

    @NotNull
    @Column(name = "kapasitas", nullable = false)
    private Integer kapasitas;

    //Relasi dengan Produksi
    @OneToMany(mappedBy = "mesin", fetch = FetchType.LAZY)
    private List<ProduksiModel> listProduksi;
}
