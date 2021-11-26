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
    private Integer id_mesin;

    @NotNull
    @Size(max=50)
    @Column(nullable= false)
    private String nama;

    //merujuk ke id_kategori item pada si-item
    @NotNull
    @Column(nullable = false)
    private Integer id_kategori;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggal_dibuat;

    @NotNull
    @Column(nullable = false)
    private Integer kapasitas;

    //Relasi dengan Produksi
    @OneToMany(mappedBy = "mesin", fetch = FetchType.LAZY)
    private List<ProduksiModel> listProduksi;
}
