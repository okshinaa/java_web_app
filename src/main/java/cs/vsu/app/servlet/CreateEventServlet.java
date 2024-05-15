package cs.vsu.app.servlet;

import cs.vsu.app.dao.EventDAO;
import cs.vsu.app.model.Event;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/create-event")
public class CreateEventServlet extends HttpServlet {
    private EventDAO eventDAO = new EventDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String dateStr = request.getParameter("date");
        String description = request.getParameter("description");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Event event = new Event();
        event.setType(type);
        event.setDate(date);
        event.setDescription(description);

        try {
            eventDAO.addEvent(event);
            response.sendRedirect(request.getContextPath() + "/events");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


