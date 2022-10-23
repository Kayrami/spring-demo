package kaurami.me.t.springdemo.tacos;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient/* implements Persistable<String> */{

    @Id
    final private String id;
    final private String name;
    final private Type type;

    public enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
