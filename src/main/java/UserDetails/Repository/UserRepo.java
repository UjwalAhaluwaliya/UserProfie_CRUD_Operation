package UserDetails.Repository;

import UserDetails.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Integer> {

  List<UserDetails> findByUsernameAndPassword(String username,String password);
  Optional<UserDetails> findById(int uid);
  List<UserDetails> deleteById(int uid);
  List<UserDetails> findAll();

  }

