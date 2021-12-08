package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.MesinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MesinDB extends JpaRepository<MesinModel, Integer>{
    Optional<MesinModel> findByIdMesin(Integer idMesin);
//    List<MesinModel> findAllById_kategori();
}