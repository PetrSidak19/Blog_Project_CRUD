package ProjektBlog.SpringProjektBlogKurz.models.DTO.mappers;

import ProjektBlog.SpringProjektBlogKurz.data.entities.ArticleEntity;
import ProjektBlog.SpringProjektBlogKurz.models.DTO.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleEntity toEntity(ArticleDTO source);

    ArticleDTO toDTO(ArticleEntity source);

    void updateArticleDTO(ArticleDTO source, @MappingTarget ArticleDTO target);

    void updateArticleEntity(ArticleDTO source, @MappingTarget ArticleEntity target);
}
