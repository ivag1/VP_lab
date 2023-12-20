package mk.finki.ukim.mk.labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class LabsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabsApplication.class, args);
    }

}
