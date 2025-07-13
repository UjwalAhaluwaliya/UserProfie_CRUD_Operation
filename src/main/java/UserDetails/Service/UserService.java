package UserDetails.Service;

import UserDetails.Model.UserDetails;
import UserDetails.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    public void save(UserDetails ud){
        repo.save(ud);
    }
    public List<UserDetails> findByUsernameAndPassword(UserDetails ud){

      return  repo.findByUsernameAndPassword(ud.getUsername(), ud.getPassword());
    }
  public Optional<UserDetails> findById(int uid){
        return repo.findById(uid);
  }
  public void deleteById(int uid){
        repo.deleteById(uid);
  }

    public List<UserDetails> findAll() {
        return repo.findAll();
    }
}
