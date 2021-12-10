package apap.ta.sifactory.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MesinDetail {
    @JsonProperty("idMesin")
    private Integer idMesin;

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("idKategori")
    private Integer idKategori;

    @JsonProperty("tanggalDibuat")
    private String tanggalDibuat;

    @JsonProperty("kapasitas")
    private Integer kapasitas;

}
