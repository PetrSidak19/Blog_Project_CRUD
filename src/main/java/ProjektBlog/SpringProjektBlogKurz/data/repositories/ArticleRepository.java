package ProjektBlog.SpringProjektBlogKurz.data.repositories;

import ProjektBlog.SpringProjektBlogKurz.data.entities.ArticleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> {
}
