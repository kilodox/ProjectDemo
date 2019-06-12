import model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class Application {

    private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new User("mani@gmail.com", 46267, "manial", "Manol Manolov", 213132));
            repository.save(new User("jivko22@gmail.com", 462111, "jivak", "Jivko Piskov", 213132));
            repository.save(new User("metoo11@gmail.com", 42221, "meto11", "Metodi Manov", 213132));
            repository.save(new User("sasho55@gmail.com", 45555, "sashy11", "Alex Cankov", 213132));
            repository.save(new User("kris@gmail.com", 4111367, "krisYank", "Kris Yankulov", 213132));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

//            // fetch an individual customer by nickname
////            repository.findByNickName()
////                    .ifPresent(user -> {
////                        log.info("Customer found with findById(1L):");
////                        log.info("--------------------------------");
////                        log.info(User.toString());
////                        log.info("");
////                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByNickName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}
