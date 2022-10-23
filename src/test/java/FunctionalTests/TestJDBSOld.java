package FunctionalTests;

import java.sql.*;
import java.util.Optional;
import kaurami.me.t.springdemo.tacos.Ingredient;

public class TestJDBSOld{
    public Optional<Ingredient> findById (String id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("");
            statement = connection.prepareStatement("SELECT id, name, type FROM Ingredirnt WHERE id=?");
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            Ingredient ingredient = null;
            if (resultSet.next()){
                ingredient = new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type")));


            }
            return Optional.of(ingredient);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return Optional.empty();
    }
}
