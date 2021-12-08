package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.MesinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesinDB extends JpaRepository<MesinModel, Integer>{
//    List<MesinModel> findAllById_kategori();
}