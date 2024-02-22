package tech.xserver.springt1;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getOneMovie(@PathVariable String id) {
        return new ResponseEntity<Optional<Movie>>(movieService.oneMovie(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createOneMovie(@RequestBody Movie movie) {
        return new ResponseEntity<Movie>(movieService.createMovie(movie), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateOneMovie(@PathVariable String id,  @RequestBody Movie movie) {
        return new ResponseEntity<Movie>(movieService.updateMovie(id, movie), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

}
