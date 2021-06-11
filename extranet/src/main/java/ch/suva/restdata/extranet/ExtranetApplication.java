package ch.suva.restdata.extranet;

import ch.suva.restdata.extranet.listeners.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExtranetApplication {
    
    @Autowired
    private DataLoader dataLoader;
    
    public static void main(String[] args) {
        SpringApplication.run(ExtranetApplication.class, args);
    }
    
    @Bean
    public void setupData() {
        dataLoader.setup();
    }
    
    @Bean
    EventHandler personEventHandler() { // Remark:  custom event handlers
        return new EventHandler();
    }
}
