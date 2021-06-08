package ch.suva.restdata;

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
        
        // Requirement: override response body > default 204 no content
        restConfiguration.setReturnBodyOnUpdate(true);
        
        // Requirement: override paging and sorting ?page=1&size=1
        restConfiguration.setMaxPageSize(5);
//        restConfiguration.setPageParamName("p") // page=1
//            .setLimitParamName("l") // size=1
//            .setSortParamName("s");
    }
    
    @Bean
    public void setupData() {
        dataLoader.setup();
    }
}
