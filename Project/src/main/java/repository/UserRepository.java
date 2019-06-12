package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String > {
    List<User> findByNickName(String nickName);
}
