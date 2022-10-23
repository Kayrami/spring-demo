package kaurami.me.t.springdemo.repository;

import kaurami.me.t.springdemo.tacos.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

//@Repository
public class JdbcIngredientRepository /*implements IngredienRepository*/{
   /* private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("SELECT id, name,type FROM ingredient", this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> result = jdbcTemplate.query("SELECT id, name,type FROM ingredient WHERE id=?", this::mapRowToIngredient, id);
        return result.size()==0? Optional.empty(): Optional.of(result.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("INSERT INTO ingtredient(id, name, type) values (?, ?, ?)", ingredient.getId(),
                ingredient.getName(), ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(row.getString("id"), row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }*/
}
