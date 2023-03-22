package ProjektBlog.SpringProjektBlogKurz.models.services;

import ProjektBlog.SpringProjektBlogKurz.models.DTO.ArticleDTO;

import java.util.List;



public interface ArticleService {
    void create(ArticleDTO article);

    List<ArticleDTO> getAll();

    ArticleDTO getById(long articleId);

    void edit(ArticleDTO article);

    void remove(long articleId);
}
