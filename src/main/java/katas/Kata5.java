package katas;

import model.Movie;
import util.DataUtil;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<Double> ratingMovies = movies.stream().map(element -> element.getRating()).collect(Collectors.toList());
        Double result = ratingMovies.stream().reduce(Double.MIN_VALUE, (a,b) -> a > b ? a : b);

        return result;
    }
}
