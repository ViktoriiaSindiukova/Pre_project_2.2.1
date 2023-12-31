package hiber.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   //@Fetch(FetchMode.JOIN)
   @OneToOne (cascade = CascadeType.ALL)
   @JoinColumn (name = "car_series")
   private Car empCar;

   public User() {}
   
   public User(String firstName, String lastName, String email, Car empCar) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.empCar = empCar;
   }

   public void setEmpCar(Car emlCar) {
      this.empCar = emlCar;
   }

   public Car getEmpCar() {
      return empCar;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public String toString() {
      return "id = " + id +
              ", firstName = '" + firstName + '\'' +
              ", lastName = '" + lastName + '\'' +
              ", email = '" + email + '\'' +
              ", empCar = " + empCar;
   }
}
