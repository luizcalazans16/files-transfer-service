package br.com.calazans.file;

import br.com.calazans.file.properties.FileUploadProperties;
import br.com.calazans.file.service.FileUploadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(FileUploadProperties.class)
public class FileTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileTransferApplication.class, args);
    }

    @Bean
    CommandLineRunner init(FileUploadService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

}
