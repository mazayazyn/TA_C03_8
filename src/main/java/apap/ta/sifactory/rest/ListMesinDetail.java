package apap.ta.sifactory.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import apap.ta.sifactory.rest.MesinDetail;
import java.util.List;


@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListMesinDetail {
    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private List<MesinDetail> listMesin;
}
