package ch.suva.restdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntranetApplication {
    
    @Autowired
    private DataLoader dataLoader;
    
    public static void main(String[] args) {
        SpringApplication.run(IntranetApplication.class, args);
    }
    
    @Bean
    public void setupData() {
        dataLoader.setup();
    }
}
