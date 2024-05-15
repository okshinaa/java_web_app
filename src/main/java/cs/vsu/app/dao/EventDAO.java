package cs.vsu.app.dao;

import cs.vsu.app.model.Event;
import cs.vsu.app.utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    private Connection connection;
    private EventDAO eventDAO = new EventDAO();

    public EventDAO() {
        try {
            this.connection = DatabaseUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Event event = new Event();
                event.setId(resultSet.getInt("id"));
                event.setType(resultSet.getString("type"));
                event.setDate(resultSet.getDate("date"));
                event.setDescription(resultSet.getString("description"));
                events.add(event);
            }
        }
        return events;
    }

    public void addEvent(Event event) throws SQLException {
        String sql = "INSERT INTO events (type, date, description) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, event.getType());
            statement.setDate(2, new java.sql.Date(event.getDate().getTime()));
            statement.setString(3, event.getDescription());
            statement.executeUpdate();
        }
    }

    public void updateEvent(Event event) throws SQLException {
        String sql = "UPDATE events SET type=?, date=?, description=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, event.getType());
            statement.setDate(2, new java.sql.Date(event.getDate().getTime()));
            statement.setString(3, event.getDescription());
            statement.setInt(4, event.getId());
            statement.executeUpdate();
        }
    }

    public void deleteEvent(int eventId) throws SQLException {
        String sql = "DELETE FROM events WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventId);
            statement.executeUpdate();
        }
    }
}
