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
    @Column(name = "id_delivery")
    private Integer idDelivery;

    //Relasi dengan Pegawai
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_kurir", referencedColumnName = "id_pegawai", nullable = false)
    private PegawaiModel pegawai;

    //Merujuk ke id_cabang di SI-Retail
    @NotNull
    @Column(name = "id_cabang", nullable = false)
    private Integer idCabang;

    @Column(name = "tanggal_dibuat", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalDibuat;

    @Column(name = "tanggal_dikirim", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalDikirim;

    @NotNull
    @Column(name = "sent", nullable = false)
    @ColumnDefault(value = "false")
    private Boolean sent;

    //Relasi dengan Request Update Item
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private RequestUpdateItemModel requestUpdate;
}