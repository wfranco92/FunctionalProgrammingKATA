package katas;

import com.google.common.collect.ImmutableMap;
import util.DataUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    "id": 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {
    public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        List<Map> boxArts = DataUtil.getBoxArts();
        List<Map> bookmarkList = DataUtil.getBookmarkList();

        return lists.stream().map(element -> ImmutableMap.of("name", element.get("name"), "videos", videos.stream().filter(video -> video.get("listId").equals(element.get("id")))
                .map(video -> ImmutableMap.of("id", video.get("id"), "title", video.get("title"),"time",bookmarkList.stream().filter(list -> list.get("videoId").equals(video.get("id")))
                        .map(listbook -> listbook.get("time")).findAny().get(), "boxart", boxArts.stream().filter(boxarts -> boxarts.get("videoId").equals(video.get("id")))
                        .reduce((box1, box2) -> Integer.parseInt(box1.get("width").toString()) < Integer.parseInt( box2.get("width").toString()) ? box1 : box2)
                        .map(box -> box.get("url")))).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
