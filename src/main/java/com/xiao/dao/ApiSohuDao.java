package com.xiao.dao;

import com.xiao.bean.Episode;
import com.xiao.bean.VideoDrama;
import com.xiao.bean.VideoRecommend;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carl-Xiao 2019-03-14
 */
@Component
@Mapper
public interface ApiSohuDao {

    @Insert("insert into video_episode_info(vid,source_url,play_url,episode_text) values(#{vid},#{sourceUrl},#{playUrl},#{episodeText} )")
    int insertIntoEpisode(Episode episode);

    @Select(" select * from video_episode_info where vid = #{0} ")
    @Results({
            @Result(property = "vid", column = "vid"),
            @Result(property = "sourceUrl", column = "source_url"),
            @Result(property = "playUrl", column = "play_url"),
    })
    Episode getEpisodeByVid(String vid);


    @Insert("insert into video_drama_info(vid,name,showName,`desc`) values(#{vid},#{name},#{showName},#{desc})")
    int insertIntoVideoDrama(VideoDrama videoDrama);


    @Select("select * from  video_drama_recommend limit 4 ")
    List<VideoRecommend> recommendVideoDrama();

    @Select("select count(1) from video_drama_recommend where playlist_id=#{0}")
    int dramaPlayEpsiodes(String playListId);

}
