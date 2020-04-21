package controller;

import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao implements PlayerList {
    MySQLConnector mySql;
    Connection connection;
    PreparedStatement prepStatement;
    ResultSet resultSet;

    public PlayerDao() {
        this.mySql = new MySQLConnector();
        this.connection = null;
        this.prepStatement = null;
        this.resultSet = null;
    }

    @Override
    public List<Player> getAllScores(String sort) {
        List<Player> playerList = new ArrayList<>();
        try {
            connection = mySql.getConnection();
            String sql;
            if (sort == null) {
                sql = "SELECT * FROM player ORDER BY score DESC";
            } else {
                sql = "SELECT * FROM player ORDER BY score";
            }
            prepStatement = connection.prepareStatement(sql);
            resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                Player player = new Player(resultSet.getLong("id"), resultSet.getString("username"), resultSet.getLong("score"));
                playerList.add(player);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception" + e.getMessage());
        } finally {
            mySql.closeResources(connection, prepStatement, resultSet);
        }
        return playerList;
    }

    @Override
    public boolean addNewScore(Player player) {
        boolean successful = false;
        try {
            connection = mySql.getConnection();
            String sql = "INSERT INTO player(username, score) VALUES(?, ?)";
            prepStatement = connection.prepareStatement(sql);
            prepStatement.setString(1, player.getUsername().trim());
            prepStatement.setLong(2, player.getScore());
            int rowsAffected = prepStatement.executeUpdate();
            if (rowsAffected > 0) {
                successful = true;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception " + e.getMessage());
        } finally {
            mySql.closeResources(connection, prepStatement, resultSet);
        }
        return successful;
    }
}
