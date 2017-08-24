package com.learning.springboot.configuration;

import com.learning.springboot.batch.BookReader;
import com.learning.springboot.model.entity.Book;
import com.learning.springboot.model.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by krvh271 on 8/18/17.
 */
@Configuration
@EnableSwagger2
public class ApplicationConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    BookRepository bookRepository;

    @Bean
    public Job bookBatchJob() throws Exception {
        return jobBuilderFactory.get("bookBatchJob").incrementer(new RunIdIncrementer())
                .start(bookStep())
                .build();
    }

    @Bean(name = "bookStep")
    public Step bookStep() throws JAXBException {
        return stepBuilderFactory.get("bookStep")
                .chunk(5)
                .reader(getBookReader())
                .writer(books -> bookRepository.save((List<Book>) books))
                .build();
    }

    @Bean
    BookReader getBookReader() throws JAXBException {
        return new BookReader();
    }

    @Bean
    ArrayList<Book> getBooks(){
        return new ArrayList<Book>();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.learning.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
