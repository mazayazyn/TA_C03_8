package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pegawai")
public class PegawaiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pegawai;

    @NotNull
    @Size(max=50)
    @Column(nullable= false)
    private String nama;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggal_lahir;

    @NotNull
    @Column(nullable = false)
    @ColumnDefault(value = "0") //kepikiran ini di set 0, perlu ngga ya?
    private Integer counter;

    //Relasi dengan Role
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)
    private RoleModel role;

//    //Relasi dengan Delivery
//    @OneToMany(mappedBy = "pegawai", fetch = FetchType.LAZY)
//    private List<DeliveryModel> listDelivery;

    //Relasi dengan Produksi
    @OneToMany(mappedBy = "pegawai", fetch = FetchType.LAZY)
    private List<ProduksiModel> listProduksi;
}
