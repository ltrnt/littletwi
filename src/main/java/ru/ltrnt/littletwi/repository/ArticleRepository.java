package ru.ltrnt.littletwi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ltrnt.littletwi.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
