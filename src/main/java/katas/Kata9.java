package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> list = movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(element -> element.stream())
                .map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), "time", new Date(), "url", video.getBoxarts().stream().reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b)))
                .collect(Collectors.toList());

        return list;

    }
}
