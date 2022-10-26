package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    static Util Util = new Util();

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String query = "create table if not exists Azimbek(" +
                "id serial primary key," +
                " name varchar not null, " +
                "lastName varchar not null," +
                " age smallint not null);";

        try(Connection connection = Util.getConnection();

            Statement statement = connection.createStatement()){

            statement.executeUpdate(query);

            System.out.println("Table created!");


        }catch (SQLException e){

            System.out.println(e.getMessage());
        }
    }
// СОЗДАТЬ ТАБЛИЦУ


    public void dropUsersTable() {
        String query = "drop table Azimbek;";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table deleted on database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
// ТАБЛИЦНАЫ ЦУДАЛИТ ЭТИП САЛАТ
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "insert into Azimbek(name,lastName,age) values(?,?,?)";

        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
            System.out.println("Azimbek saved!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

// КИШИ КОШОМ (СОХРАНИТ КЫЛГАНЫ)
    }

    public void removeUserById(long id) {
        String query = "delete from Azimbek where id = ?";

        try( Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted user by id!");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


// АЙДИСИН МЕНЕН ОЧУРУУ
    }

    public List<User> getAllUsers() throws SQLException {
        String query = "select * from Azimbek;";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<User> usersList = new ArrayList<>();
            while (resultSet.next()) {
                usersList.add(new User(
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age")));
            }
            return usersList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException();
        }
    }
// ОБЩИЙ ИНФОНУ ЧЫГАРЫП БЕРЕТ
    public void cleanUsersTable() {
        String query = "truncate table Azimbek;";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table is truncate on database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
// ТАБЛИЦАНЫН ИЧИН ТАЗАЛАЙТ
    }
}