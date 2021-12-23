package apap.ta.sifactory.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StokDetail {
    @JsonProperty("stok")
    private int stok;
}
