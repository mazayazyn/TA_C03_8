package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "requestupdateitem")
public class RequestUpdateItemModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request_update_item")
    private Integer idRequestUpdateItem;

    //merujuk ke siitem
    @NotNull
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Integer idItem;

    @NotNull
    @Column(name = "id_kategori", nullable = false)
    private Integer idKategori;

    @NotNull
    @Column(name = "tambahan_stok", nullable = false)
    private Integer tambahanStok;

    @NotNull
    @Column(name = "tanggal_request", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalRequest;

    @NotNull
    @Column(name = "id_cabang", nullable = false)
    private Integer idCabang;

    @NotNull
    @Column(name = "executed", nullable = false)
    private boolean executed;

//    @NotNull
//    @Column(nullable = false)
//    private Integer id_delivery;

    //Relasi dengan Produksi
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produksi", referencedColumnName = "id_produksi")
    private ProduksiModel produksi;

    //Relasi dengan Delivery
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_delivery", referencedColumnName = "id_delivery")
    private DeliveryModel delivery;
}
