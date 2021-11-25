package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Integer id_request_update_item;

    //merujuk ke siitem
//    @NotNull
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    private Integer id_item;

    @NotNull
    @Column(nullable = false)
    private Integer id_kategori;

    @NotNull
    @Column(nullable = false)
    private Integer tambahan_stok;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggal_request;

    @NotNull
    @Column(nullable = false)
    private Integer id_cabang;

    @NotNull
    @Column(nullable = false)
    private boolean executed;

    @NotNull
    @Column(nullable = false)
    private Integer id_delivery;

    //Relasi dengan Produksi
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produksi", referencedColumnName = "id_produksi", nullable = false)
    private ProduksiModel produksi;

    //Relasi dengan Delivery
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_delivery", referencedColumnName = "id_delivery", nullable = false)
    private DeliveryModel delivery;
}
