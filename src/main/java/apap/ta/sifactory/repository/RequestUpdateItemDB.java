package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestUpdateItemDB extends JpaRepository<RequestUpdateItemModel, Integer>{
}