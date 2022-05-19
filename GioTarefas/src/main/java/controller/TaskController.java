package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {

    public void save(Task task) {

        String sql = "INSERT INTO tasks (idList,"
                + " name,"
                + " description,"
                + " completed,"
                + " notes,"
                + " deadline,"
                + " createdAt,"
                + " updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdList());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar tarefa "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Task task) {

        String sql = "UPDATE taks SET"
                + "idList = ?,"
                + "name = ?,"
                + "description = ?,"
                + "notes = ?,"
                + "completed = ?,"
                + "deadline = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, task.getIdList());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));

            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atulizar tarefa "
                    + ex.getMessage(), ex);
        } finally {

            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public void removeById(int TaskId) throws SQLException {

        String sql = "DELETE FROM tasks WHERE ID = ?";

        Connection connection = null;
        // Para prepara o comando sql 
        PreparedStatement statement = null;

        try {

            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(sql);
            statement.setInt(1, TaskId);
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar tarefa "
                    + ex.getMessage(), ex);
        } finally {

            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public List<Task> getAll(int idList) {
        
        String sql = "SELECT * FROM task where idList = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        // Lista de tarefas que sera devolvida quando a chamada
        List<Task> tasks = new ArrayList<Task>();
        
        try{
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idList);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                Task task = new Task();
                
                task.setId(resultSet.getInt("id"));
                task.setIdList(resultSet.getInt("idList"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("Description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                
                tasks.add(task);
                
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao Abrir tarefas "
                    + ex.getMessage(), ex);
        } finally {

            ConnectionFactory.closeConnection(connection, statement);

        }
        
        
        return null;

    }

}
