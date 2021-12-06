package apap.ta.sifactory.rest;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDetail {
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("harga")
    private Integer harga;

    @JsonProperty("stok")
    private Integer stok;

    @JsonProperty("kategori")
    private String kategori;
}
