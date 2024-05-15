package cs.vsu.app.servlet;

import cs.vsu.app.dao.EventDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete-event")
public class DeleteEventServlet extends HttpServlet {
    private EventDAO eventDAO = new EventDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("eventId"));

        try {
            eventDAO.deleteEvent(eventId);
            response.sendRedirect(request.getContextPath() + "/events");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
