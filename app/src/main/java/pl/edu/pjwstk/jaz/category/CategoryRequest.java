package pl.edu.pjwstk.jaz.category;

import pl.edu.pjwstk.jaz.branch.BranchEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CategoryRequest {
    private String name;
    private String branchName;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}

