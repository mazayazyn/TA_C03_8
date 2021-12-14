package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RequestUpdateItemDB extends JpaRepository<RequestUpdateItemModel, Integer>{
    RequestUpdateItemModel findByIdRequestUpdateItem(Integer id);
}