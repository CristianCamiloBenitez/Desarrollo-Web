package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.entity.Editorial;
import co.edu.javeriana.libreria.service.EditorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editorial")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @PostMapping("/add")
    public Editorial addNewEditorial(@RequestBody Editorial editorial) {
        return editorialService.addEditorial(editorial);
    }

    @GetMapping("/all")
    public Iterable<Editorial> getAllEditorial() {
        return editorialService.findAllEditorial();
    }

    @PutMapping("/updateAll/{id}")
    public Editorial updateEditorial(@RequestBody @Validated Editorial editorial, @PathVariable("id") final Integer id) {
        return editorialService.updateAllEditorial(editorial, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteEditorial(@PathVariable("id") final Integer id) {
        return editorialService.deleteEditorial(id);
    }
}
