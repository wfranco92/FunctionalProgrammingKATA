package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;
import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        Optional<BoxArt> largeBoxart = movies.stream()
                .map(video -> video.getBoxarts())
                .flatMap(boxArts -> boxArts.stream())
                .reduce((box1, box2) -> box1.getWidth() > box2.getWidth() ? box1 : box2);

        String result = largeBoxart.get().getUrl();

        return result;
    }
}
