package ProjektBlog.SpringProjektBlogKurz.models.services;

import ProjektBlog.SpringProjektBlogKurz.data.entities.ArticleEntity;
import ProjektBlog.SpringProjektBlogKurz.data.repositories.ArticleRepository;
import ProjektBlog.SpringProjektBlogKurz.exceptions.ArticleNotFoundException;
import ProjektBlog.SpringProjektBlogKurz.models.DTO.ArticleDTO;
import ProjektBlog.SpringProjektBlogKurz.models.DTO.mappers.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ArticleServiceImpl implements ArticleService {


    private final ArticleRepository articleRepository;


    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(@Autowired ArticleRepository articleRepository, @Autowired ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public void create(ArticleDTO article) {
        ArticleEntity newArticle = articleMapper.toEntity(article);
        articleRepository.save(newArticle);
    }

    @Override
    public List<ArticleDTO> getAll() {
        return StreamSupport.stream(articleRepository.findAll().spliterator(), false)
                .map(i -> articleMapper.toDTO(i))
                .toList();
    }

    @Override
    public ArticleDTO getById(long articleId) {
        ArticleEntity fetchedArticle = getArticleOrThrow(articleId);

        return articleMapper.toDTO(fetchedArticle);
    }

    @Override
    public void edit(ArticleDTO article) {
        ArticleEntity fetchedArticle = getArticleOrThrow(article.getArticleId());

        articleMapper.updateArticleEntity(article, fetchedArticle);
        articleRepository.save(fetchedArticle);
    }

    @Override
    public void remove(long articleId) {
        ArticleEntity fetchedEntity = getArticleOrThrow(articleId);
        articleRepository.delete(fetchedEntity);
    }

    private ArticleEntity getArticleOrThrow(long articleId) {
        return articleRepository
                .findById(articleId)
                .orElseThrow(ArticleNotFoundException::new);
    }

}




