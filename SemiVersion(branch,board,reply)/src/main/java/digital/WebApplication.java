package digital;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@SpringBootApplication 
@EnableTransactionManagement
@MapperScan("digital.dao")
public class WebApplication {
  
  @Bean
  @ConfigurationProperties("app.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class, args);
  }
}
