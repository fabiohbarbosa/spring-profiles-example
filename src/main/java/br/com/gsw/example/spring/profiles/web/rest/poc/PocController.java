package br.com.gsw.example.spring.profiles.web.rest.poc;

import br.com.gsw.example.spring.profiles.poc.domain.Poc;
import br.com.gsw.example.spring.profiles.poc.repository.PocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@RestController
@RequestMapping("/poc")
public class PocController {
    @Autowired
    private PocRepository repository;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Poc getId(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Poc> get() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long post(final @RequestBody Poc poc) {
        return repository.save(poc).getId();
    }

}
