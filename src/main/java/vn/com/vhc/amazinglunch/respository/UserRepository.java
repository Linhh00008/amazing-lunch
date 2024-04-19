package vn.com.vhc.amazinglunch.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.vhc.amazinglunch.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from users where user_id = : user_id", nativeQuery = true)
    List<User> findUserWithUserId(@Param("user_id") int user_id);

    User findById(int userId);

    User findByUsername(String username);

    User save(User user);

    User saveAndFlush(User user);

    void delete(User user);
}
