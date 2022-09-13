package personal.ivan.spring.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryAnnotation implements IRepository {

    private List<Car> lst = new ArrayList<>();

    @Override
    public void save(Car car) {
        lst.add(car);
    }

    @Override
    public Car findById(int id) {
        return lst.get(id);
    }
}

