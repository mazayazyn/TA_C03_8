package apap.ta.sifactory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private Long id_role;

    @NotNull
    @Size(max=20)
    @Column(nullable= false)
    private String nama_role;

    @NotNull
    @Column(nullable = false)
    private Integer baseWages;

//    //Relasi dengan Pegawai
//    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//    private List<PegawaiModel> listPegawai;

    //Relasi dengan Pegawai
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<PegawaiModel> pegawaiRole;
}
