package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.entity.Editorial;
import co.edu.javeriana.libreria.repository.EditorialRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    // POST
    public Editorial addEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    // GET ALL
    public List<Editorial> findAllEditorial() {
        return editorialRepository.findAll();
    }

    // PUT
    public Editorial updateAllEditorial(Editorial editorial, Integer editorialID) {

        if(editorialID != editorial.getId())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id from path variable does not match object id");

        if(editorialRepository.findById(editorialID).isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id does not exist");

        return editorialRepository.save(editorial);
    }

    // DELETE
    public String deleteEditorial(Integer id) {

        if(editorialRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id does not exist");
        }

        editorialRepository.deleteById(id);
        return "deleted editorial with id " + id;
    }
}
