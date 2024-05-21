package com.example.bibliotecaapiv2;

import com.example.bibliotecaapiv2.classes.users.Address;
import com.example.bibliotecaapiv2.classes.users.User;
import com.example.bibliotecaapiv2.enums.BookCategory;
import com.example.bibliotecaapiv2.enums.Gender;
import com.example.bibliotecaapiv2.enums.Profile;
import com.example.bibliotecaapiv2.enums.Status;
import com.example.bibliotecaapiv2.files.BookFileManipulation;
import com.example.bibliotecaapiv2.files.UserFileManipulation;
import com.example.bibliotecaapiv2.services.BookServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private final RestTemplate restTemplate;

    public Controller() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/sla")
    @CrossOrigin(origins = "*")
    public String testando() {
        return "sla porra";
    }

    @GetMapping("/teste-cep")
    @CrossOrigin(origins = "*")
    public Object consultaCep() {
        String url = "https://brasilapi.com.br/api/cep/v1/" + "91530110";
        return restTemplate.getForObject(url, Address.class);
    }

    @GetMapping("/teste-user")
    @CrossOrigin(origins = "*")
    public Object consultaUser() throws IOException {
        Address address = new Address.Builder()
                .withStreet("Rua Exemplo")
                .withCity("Porto Exemplo")
                .withState("Grande Exemplo do Sul")
                .withPostalCode("91530110") // Aqui definimos o CEP
                .build();

        // Criando uma lista de livros favoritos
        List<BookCategory> favGenres = new ArrayList<>();
        favGenres.add(BookCategory.FICTION);
        favGenres.add(BookCategory.FANTASY);

        // Criando um usuário usando o padrão Builder
        User user = new User.Builder()
                .withUserName("Exemplo de Usuário")
                .withBirthDate("01011990")
                .withUserCPF("12345678901")
                .withUserEmail("exemplo@dominio.com")
                .withUserPhone("5551999999999")
                .withUserCEP("99999999")
                .withUserProfile(Profile.STUDENT)
                .withUserStatus(Status.ACTIVE)
                .withUserGender(Gender.MALE)
                .withUserFavGenres(favGenres)
                .withUserAddress(address)
                .build();
        UserFileManipulation registrate = new UserFileManipulation(user);
        registrate.writer();
        return user;
    }

    @GetMapping("/teste-book")
    @CrossOrigin(origins = "*")
    public Object consultaBook() throws IOException {
        BookServices livro = new BookServices ();
        livro.BookRegister("9788545702870");
        BookFileManipulation registrate = new BookFileManipulation(livro.getBookReg());
        registrate.writer();
        return  livro.getBookReg();
    }

    @GetMapping("/teste-book/{isbn}")
    @CrossOrigin(origins = "*")
    public Object consultaBookISBN(@PathVariable String isbn) throws IOException {
        BookServices livro = new BookServices();
        livro.BookRegister(isbn);
        BookFileManipulation registrate = new BookFileManipulation(livro.getBookReg());
        registrate.writer();
        return livro.getBookReg();
    }
}
