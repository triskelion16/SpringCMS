package pl.triskelion16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.triskelion16.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	//List<Category> findAllById(Long id);
}
