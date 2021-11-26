package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "delivery")
public class DeliveryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_delivery;

    //Relasi dengan Pegawai
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_kurir", referencedColumnName = "id_pegawai", nullable = false)
    private PegawaiModel pegawai;

//    //Merujuk ke id_cabang di SI-Retail
//    @NotNull
//    @Column(nullable = false)
//    private Integer id_cabang;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggal_dibuat;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggal_dikirim;

    @NotNull
    @Column(nullable = false)
    @ColumnDefault(value = "false") //kepikiran ini di set false, perlu ngga ya?
    private Boolean sent;

    //Relasi dengan Request Update Item
    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private RequestUpdateItemModel requestUpdate;
}
