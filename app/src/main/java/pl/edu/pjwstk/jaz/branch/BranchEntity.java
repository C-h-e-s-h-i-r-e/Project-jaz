package pl.edu.pjwstk.jaz.branch;

import jdk.jfr.Category;
import pl.edu.pjwstk.jaz.category.CategoryEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "branch")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(
            mappedBy = "branch",
            cascade = CascadeType.ALL
    )
    private List<CategoryEntity> categories;

    BranchEntity(){super();}

    public BranchEntity(String name){
        this.name=name;
    }


    @Override
    public String toString() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
