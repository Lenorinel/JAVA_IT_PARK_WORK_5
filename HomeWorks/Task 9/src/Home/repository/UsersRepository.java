package Home.repository;

import Home.models.User;

public interface UsersRepository {
    User find(int id);

    void delete(int id);

    void save(User user);

    void update(User user);


}
