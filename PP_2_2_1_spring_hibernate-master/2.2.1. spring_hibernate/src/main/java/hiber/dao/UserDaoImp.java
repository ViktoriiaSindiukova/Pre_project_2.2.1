package hiber.dao;

import com.mysql.cj.Query;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> getUserByCar(Car car) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where empCar.model = :model and empCar.series = :series", User.class);
      query.setParameter("model", car.getModel());
      query.setParameter("series", car.getSeries());
      List<User> user = query.getResultList();
      return user;
   }

}
