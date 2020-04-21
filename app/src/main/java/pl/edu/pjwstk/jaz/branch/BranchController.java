package pl.edu.pjwstk.jaz.branch;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Map;

@Named
@RequestScoped
public class BranchController {



    @Inject
    BranchRequest branchRequest;

    @Inject
    BranchRepository branchRepository;

    public String add(){
        BranchEntity branchEntity = new BranchEntity(branchRequest.getName());
        branchRepository.add(branchEntity);
        return "index.xhtml?faces-redirect=true";
    }

    public String edit(){

        BranchEntity branchEntity = branchRepository.get(branchRequest.getId());
        branchEntity.setName(branchRequest.getName());
        branchRepository.add(branchEntity);
        return "branch_all.xhtml?faces-redirect=true";
    }

    public String remove(){

        branchRepository.remove(branchRequest.getId());

        return "branch_all.xhtml?faces-redirect=true";
    }


}

