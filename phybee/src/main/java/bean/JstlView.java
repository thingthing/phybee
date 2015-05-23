package bean;

import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Eric on 07/05/2015.
 */
public class JstlView extends InternalResourceView {
    @Override
    protected void renderMergeOutputModel(
            Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String dispatcherPath = prepareForRendering(request, response);

        request.setAttribute("partial", dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view/template.jsp");
        requestDispatcher.include(request, response);
    }
}
