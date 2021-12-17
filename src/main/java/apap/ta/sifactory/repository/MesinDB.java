package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.MesinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface MesinDB extends JpaRepository<MesinModel, Integer>{
    Optional<MesinModel> findByIdMesin(Integer idMesin);
    Optional<MesinModel> findNamaMesinByIdMesin(Integer idMesin);
}