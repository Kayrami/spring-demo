package kaurami.me.t.springdemo.repository;

import kaurami.me.t.springdemo.tacos.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {


}
