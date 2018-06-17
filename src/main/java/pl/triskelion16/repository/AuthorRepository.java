package pl.triskelion16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.triskelion16.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
