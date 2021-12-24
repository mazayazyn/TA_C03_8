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
@Table(name = "requestupdateitem")
public class RequestUpdateItemModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request_update_item")
    private Integer idRequestUpdateItem;

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

    //Relasi dengan Produksi
    @OneToOne(mappedBy = "requestUpdateItem",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProduksiModel produksi;

    //Relasi dengan Delivery
    @OneToOne(mappedBy = "requestUpdate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_delivery", referencedColumnName = "id_delivery", nullable = true)
    private DeliveryModel delivery;
}
