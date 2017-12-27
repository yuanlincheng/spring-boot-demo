package com.ylc;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/12/27 20:35
 * @description: xxx
 * own: Aratek
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    public DataSource dataSource;
//
//    // tag::readerwriterprocessor[]
//    @Bean
//    public FlatFileItemReader<Person> reader() {
//        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
//        reader.setResource(new ClassPathResource("sample-data.csv"));
//        reader.setLineMapper(new DefaultLineMapper<Person>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[] { "firstName", "lastName" });
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                setTargetType(Person.class);
//            }});
//        }});
//        return reader;
//    }
//
//    @Bean
//    public PersonItemProcessor processor() {
//        return new PersonItemProcessor();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Person> writer() {
//        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
//        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
//        writer.setDataSource(dataSource);
//        return writer;
//    }
//    // end::readerwriterprocessor[]
//
//    // tag::jobstep[]
//    @Bean
//    public Job importUserJob(JobCompletionNotificationListener listener) {
//        return jobBuilderFactory.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1())
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<Person, Person> chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer())
//                .build();
//    }
    // end::jobstep[]
}
