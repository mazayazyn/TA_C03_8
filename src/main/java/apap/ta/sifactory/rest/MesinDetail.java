package apap.ta.sifactory.rest;

import apap.ta.sifactory.model.ProduksiModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
