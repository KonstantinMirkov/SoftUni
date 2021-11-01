import javax.persistence.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EntityManager entityManager = emf.createEntityManager();

        Manager manager = new Manager(entityManager);
        Engine engine = new Engine(manager, reader);
        engine.run();
    }
}