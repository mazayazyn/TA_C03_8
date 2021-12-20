package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface RequestUpdateItemDB extends JpaRepository<RequestUpdateItemModel, Integer>{
    Optional<RequestUpdateItemModel> findByIdRequestUpdateItem(Integer id);
    RequestUpdateItemModel getRequestUpdateItemById(Integer id);
}