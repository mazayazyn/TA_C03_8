package apap.ta.sifactory.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import apap.ta.sifactory.rest.ItemDetail;
import java.util.List;


@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListItemDetail {
    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private List<ItemDetail> listItem;
}
