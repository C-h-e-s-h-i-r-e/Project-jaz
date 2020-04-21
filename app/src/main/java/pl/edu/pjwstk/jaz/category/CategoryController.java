package pl.edu.pjwstk.jaz.category;

import pl.edu.pjwstk.jaz.branch.BranchEntity;
import pl.edu.pjwstk.jaz.branch.BranchRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named
@RequestScoped
public class CategoryController {



    @Inject
    CategoryRequest categoryRequest;

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    BranchRepository branchRepository;

    public String add(){
        CategoryEntity categoryEntity = new CategoryEntity(categoryRequest.getName(),branchRepository.findByName(categoryRequest.getBranchName()));
        categoryRepository.add(categoryEntity);
        return "index.xhtml?faces-redirect=true";
    }

    public List<String> getBranches(){
        List<String> list = new ArrayList();
        for(BranchEntity be : branchRepository.getAll()){
            list.add(be.getName());
        }
        return list;
    }
}