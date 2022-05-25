package katas;

import model.MovieList;
import util.DataUtil;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Integer> lista = movieLists.stream()
                .map(element -> element.getVideos())
                .flatMap(video -> video.stream())
                .map(element -> element.getId())
                .collect(Collectors.toList());

        return lista;
    }
}
