package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> list = movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(element -> element.stream())
                .map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), "boxart", video.getBoxarts().stream().reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b)))
                .collect(Collectors.toList());

        return list;

    }
}
