package PetCoffee.PetCoffee.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSource {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")  //全局配置文件通过此方法放入DruidDataSource实例中
    public DruidDataSource getDruid(){
        return new DruidDataSource();
    }
}
