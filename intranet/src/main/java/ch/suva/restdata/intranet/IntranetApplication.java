package ch.suva.restdata.intranet;

import ch.suva.restdata.intranet.converter.AddressTypeSerializer;
import ch.suva.restdata.intranet.converter.KundenportalBenutzerSerializer;
import ch.suva.restdata.intranet.entities.AddressType;
import ch.suva.restdata.intranet.entities.KundenportalBenutzer;
import ch.suva.restdata.intranet.listeners.EventHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class IntranetApplication {
    
    @Autowired
    private DataLoader dataLoader;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IntranetApplication.class, args);
        
        RepositoryRestConfiguration restConfiguration = context.getBean(RepositoryRestConfiguration.class);
        
        // Remark:  override response body > default 204 no content
        restConfiguration.setReturnBodyOnUpdate(true);
        
        // Remark:  override paging and sorting ?page=1&size=1
        restConfiguration.setMaxPageSize(5);
    }
    
    @Bean
    public void setupData() {
        dataLoader.setup();
    }
    
    @Bean
    public ObjectMapper customObjectMapper() { // Remark:  custom converters
        SimpleModule module = new SimpleModule();
        module.addSerializer(KundenportalBenutzer.class, new KundenportalBenutzerSerializer());
        module.addSerializer(AddressType.class, new AddressTypeSerializer());
        return new ObjectMapper().registerModule(module);
    }
    
    @Bean
    EventHandler personEventHandler() { // Remark:  custom event handlers
        return new EventHandler();
    }
}
