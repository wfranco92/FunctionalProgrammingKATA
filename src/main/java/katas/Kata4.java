package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> list = null;

        list = movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(element -> element.stream())
                .map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), "boxart", new BoxArt(150, 200, video.getUri())))
                .collect(Collectors.toList());

        return list;

    }
}
