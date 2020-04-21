package pl.edu.pjwstk.jaz.branch;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("branch")
public class BranchServlet extends HttpServlet {

    @Inject
    BranchRepository branchRepository;

    @Inject
    BranchRequest branchRequest;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String operation = req.getParameter("operation");
        Long id = Long.valueOf(req.getParameter("id"));


        if(operation.equals("edit")){
            BranchEntity branchEntity = branchRepository.get(id);
            String branchName = branchEntity.getName();
                    Long branchId = branchEntity.getId();
            branchRequest.setName(branchName);
            branchRequest.setId(branchId);

            req.getRequestDispatcher("branch_edit.xhtml").forward(req, resp);

        }
    }
}
