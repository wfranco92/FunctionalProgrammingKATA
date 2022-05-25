package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<BoxArt> list = movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(element -> element.stream())
                .map(video -> video.getBoxarts())
                .flatMap(boxArts -> boxArts.stream())
                .reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b).stream().collect(Collectors.toList());


                //.map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), video.getBoxarts().stream().reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b), video.getUri()))


        //var otherList = list.stream().map(video -> video.getBoxarts().stream().reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b)).collect(Collectors.toList());

        System.out.println(list);
        return null;

                //ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", "url"));
    }
}
