package pl.triskelion16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.triskelion16.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
