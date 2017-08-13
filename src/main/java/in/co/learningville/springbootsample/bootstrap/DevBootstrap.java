package in.co.learningville.springbootsample.bootstrap;

import in.co.learningville.springbootsample.model.Author;
import in.co.learningville.springbootsample.model.Book;
import in.co.learningville.springbootsample.model.Publisher;
import in.co.learningville.springbootsample.repositories.AuthorRepository;
import in.co.learningville.springbootsample.repositories.BookRepository;
import in.co.learningville.springbootsample.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by pra_pri on 13-Aug-17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData(){

        Publisher publisher1 = new Publisher();
        publisher1.setName("Piersons");
        publisher1.setAddress("UK");
        publisherRepository.save(publisher1);

        Author rowling = new Author("JK","Rowling");
        Book hp1 = new Book("Harry Potter And Chambers Of Secret" , "38891829", publisher1);
        rowling.getBooks().add(hp1);
        hp1.getAuthors().add(rowling);
        authorRepository.save(rowling);
        bookRepository.save(hp1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Worx");
        publisher2.setAddress("US");
        publisherRepository.save(publisher2);

        Author rod = new Author("Rod" , "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB" , "1231234", publisher2);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        //noEJB.getAuthors().add(rod);

    }

}
