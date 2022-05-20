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
            // Criando a conexão BD
            connection = ConnectionFactory.getConnection();
            
            // Preparando a query
            statement = connection.prepareStatement(sql);
            
            // Setando os valores
            statement.setInt(1, task.getIdList());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            
            // Executando a query
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar tarefa "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Task task) {

        String sql = "UPDATE tasks SET "
                + "idList = ?,"
                + "name = ?,"
                + "description = ?,"
                + "notes = ?,"
                + "completed = ?,"
                + "deadline = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?"
                + " WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Estabelencendo conexão
            connection = ConnectionFactory.getConnection();
            
            // Preparando a query
            statement = connection.prepareStatement(sql);
            
            // Setando os valores
            statement.setInt(1, task.getIdList());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            // executando a query
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atulizar tarefa "
                    + ex.getMessage(), ex);
        } finally {

            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public void removeById(int TaskId) {

        String sql = "DELETE FROM tasks WHERE ID = ?";
        
        Connection connection = null;
        
        PreparedStatement statement = null;

        try {
            // Criando conexão BD
            connection = ConnectionFactory.getConnection();
            
            // preparando a query
            statement = connection.prepareStatement(sql);
            
            // Setando os valores
            statement.setInt(1, TaskId);
            
            // Executando a query
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar tarefa "
                    + ex.getMessage(), ex);
        } finally {

            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public List<Task> getAll(int idList) {
        
        String sql = "SELECT * FROM tasks where idList = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        // Lista de tarefas que sera devolvida quando a chamada
        List<Task> tasks = new ArrayList<Task>();
        
        try{
            // Criando conexão BD
            connection = ConnectionFactory.getConnection();
            
            // Preparando a query
            statement = connection.prepareStatement(sql);
            // Setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idList);
            // Valor retornado pela execução da query
            resultSet = statement.executeQuery();
            // Enquanto houverem valores a serem pecorridos no resultSet
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
        
        // Lista de tarefas que foi criada e carregada do BD
        return tasks;

    }

}
