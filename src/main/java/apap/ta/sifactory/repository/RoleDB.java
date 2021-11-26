package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleDB extends JpaRepository<RoleModel, Integer>{

}
