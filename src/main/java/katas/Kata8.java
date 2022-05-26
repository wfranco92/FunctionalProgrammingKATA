package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import util.DataUtil;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<ImmutableMap<String, Integer>> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        var moviesId = movies.stream().map(key -> key.getId());
        var bookMarksId = bookMarks.stream().map(key -> key.getId());

        var merge = StreamUtils.zip(moviesId, bookMarksId, (a, b) -> ImmutableMap.of("videoId", a, "bookmarkId", b)).collect(Collectors.toList());

        return merge;

    }
}
