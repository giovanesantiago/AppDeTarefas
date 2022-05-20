package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConnectionFactory;
import java.util.List;
import model.Lista;

public class ListController {

    public void save(Lista lista) {

        String sql = "INSERT INTO lists (name,"
                + "description,"
                + "createdAt,"
                + "updatedAt) "
                + "VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Criando conexão BD
            connection = ConnectionFactory.getConnection();

            // Preparando query
            statement = connection.prepareStatement(sql);

            // Setando valores
            statement.setString(1, lista.getName());
            statement.setString(2, lista.getDescription());
            statement.setDate(3, new Date(lista.getCreatedAt().getTime()));
            statement.setDate(4, new Date(lista.getUpdatedAt().getTime()));

            //Executando query
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar Lista de Tarefas "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Lista lista) {

        String sql = "UPDATE lists SET"
                + " name = ?,"
                + "description = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Criando conexão BD
            connection = ConnectionFactory.getConnection();

            // Preparando query
            statement = connection.prepareStatement(sql);

            // Setando valores
            statement.setString(1, lista.getName());
            statement.setString(2, lista.getDescription());
            statement.setDate(3, new Date(lista.getCreatedAt().getTime()));
            statement.setDate(4, new Date(lista.getUpdatedAt().getTime()));
            statement.setInt(5, lista.getId());

            //Executando query
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar Lista de Tarefas "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int ListId) {
        String sql = "DELETE FROM lists WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Criando conexão BD
            connection = ConnectionFactory.getConnection();

            // preparando a query
            statement = connection.prepareStatement(sql);

            // Setando os valores
            statement.setInt(1, ListId);

            // Executando a query
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar Lista de tarefas "
                    + ex.getMessage(), ex);
        } finally {

            ConnectionFactory.closeConnection(connection, statement);

        }
    }

    public List<Lista> getAll() {

        String sql = "SELECT * FROM lists";

        List<Lista> listas = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        // Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;

        try {
            // Carregando conexão 
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {

               Lista lista = new Lista();
               
               lista.setId(resultSet.getInt("id"));
               lista.setName(resultSet.getString("name"));
               lista.setDescription(resultSet.getString("description"));
               lista.setCreatedAt(resultSet.getDate("createdAt"));
               lista.setUpdatedAt(resultSet.getDate("updatedAt"));
               
               listas.add(lista);

            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao abrir Listas de tarefas "
                    + ex.getMessage(), ex);
        } finally {

            ConnectionFactory.closeConnection(connection, statement);

        }

        return listas;
    }

}
