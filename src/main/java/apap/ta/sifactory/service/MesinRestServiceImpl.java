package apap.ta.sifactory.service;

import apap.ta.sifactory.rest.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class MesinRestServiceImpl  implements MesinRestService{
//    private final WebClient webClient;
//
//    public MesinRestServiceImpl(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder.baseUrl(Setting.listMesinUrl).build();
//    }

//    @Override
//    public List<MesinDetail> getAllMesin() {
//        ListMesinDetail i = this.webClient.get().uri("/")
//                .retrieve()
//                .bodyToMono(ListMesinDetail.class)
//                .block();
//        return i.getListMesin();
//    }
}
