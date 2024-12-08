package PetCoffee.PetCoffee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@ServletComponentScan
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("PetCoffee.PetCoffee.Mybatis_interface")
public class PetCoffeeApplication {

	public static void main(String[] args) {
		disableWarning();
		SpringApplication.run(PetCoffeeApplication.class, args);
	}

	/* 禁止控制台由于JDK版本过高而显示的警告 */
	public static void disableWarning() {
		try {
			Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafe.setAccessible(true);
			Unsafe u = (Unsafe) theUnsafe.get(null);

			Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
			Field logger = cls.getDeclaredField("logger");
			u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
		} catch (Exception e) {
			// ignore
		}
	}
}


