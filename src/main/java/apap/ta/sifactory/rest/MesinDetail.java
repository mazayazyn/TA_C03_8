package apap.ta.sifactory.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
    private LocalDate tanggalDibuat;

    @JsonProperty("kapasitas")
    private Integer kapasitas;

}
