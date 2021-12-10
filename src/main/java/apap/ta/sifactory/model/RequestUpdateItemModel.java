package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
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
    private String idItem;

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
    @ColumnDefault(value = "false")
    private boolean executed;

    //Relasi dengan Produksi
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produksi", referencedColumnName = "id_produksi", nullable = true)
    private ProduksiModel produksi;

    //Relasi dengan Delivery
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_delivery", referencedColumnName = "id_delivery", nullable = true)
    private DeliveryModel delivery;
}
