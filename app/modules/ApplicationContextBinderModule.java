package modules;

import com.global.weather.GlobalWeatherSoap;
import com.google.inject.AbstractModule;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextBinderModule extends AbstractModule {

    @Override
    protected void configure() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        applicationContext.start();
        applicationContext.registerShutdownHook();

        // Guice instance binding
        bind(GlobalWeatherSoap.class).toInstance((GlobalWeatherSoap) applicationContext.getBean("globalWeatherSoapClient"));
    }

}
