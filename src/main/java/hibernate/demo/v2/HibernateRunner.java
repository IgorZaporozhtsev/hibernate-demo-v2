package hibernate.demo.v2;

import hibernate.demo.v2.entity.User;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) throws SQLException {
        var configuration = new Configuration();
        configuration.configure(); // знаходить hibernate.cfg.xml або в параметрах іншший path
        //додаємо User класс в sessionFactory або в  hibernate.cfg.xml  <mapping class="hibernate.demo.v2.entity.User"></mapping>
        //configuration.addAnnotatedClass(User.class);
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy()); //allow map birthDate то birth_date

        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()
        ) {

            session.beginTransaction();
            var user = User.builder()
                    .username("minato@gmail.com")
                    .firstname("Minato")
                    .lastname("Hokage")
                    .age(21)
                    .birthDate(LocalDate.of(2000, 1, 19))
                    .build();

            session.persist(user);
            session.getTransaction().commit();
        }

    }
}
