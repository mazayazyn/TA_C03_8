package apap.ta.sifactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_role;

    @NotNull
    @Size(max=20)
    @Column(nullable= false)
    private String nama_role;

    @NotNull
    @Column(nullable = false)
    private Integer baseWages;

    //Relasi dengan Role
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<PegawaiModel> listPegawai;
}
