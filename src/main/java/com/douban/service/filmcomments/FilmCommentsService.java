package com.douban.service.filmcomments;

import com.douban.entity.po.FilmComments;
import com.douban.entity.vo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lhw2 on 2017/5/3.
 */
public interface FilmCommentsService {

    /**
     * 分页查询短评
     * @param filmId 电影id
     * @param page 分页信息
     * @return
     */
    Map<String,Object> getFilmCommentsList(Long filmId, Page page);

    /**
     * 插入短评
     * @param filmComments 电影短评
     * @return
     */
    int insertFilmComments(FilmComments filmComments);

    /**
     *删除短评
     * @param id 短评id
     * @return
     */
    int deleteFilmCommentsById(Long id);

}
