package personal.ivan.spring.repository;

public interface IRepository {
    public void save(Car car);

    public Car findById(int id);
}
