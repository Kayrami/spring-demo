package FunctionalTests;

import kaurami.me.t.springdemo.tacos.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCTemplate {
    JdbcTemplate jdbcTemplate;

    public Optional<Ingredient> findById(String id){
        List<Ingredient> results = jdbcTemplate.query("SELECT id, name, type FROM Ingredient WHERE id=?", this::mapRowToIngredient, id);
        return results.size()==0? Optional.empty():Optional.of(results.get(0));
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }
}
