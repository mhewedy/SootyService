import java.util.ArrayList;
import java.util.List;

import spark.Spark;

import com.google.gson.Gson;

import domain.Track;

public class Main {

	public static void main(String[] args) {

		Spark.staticFileLocation("/");

		Spark.get("/list", (req, resp) -> {
			
			String host = "http://" + req.host();

			List<Track> list = new ArrayList<Track>();

			Track t1 = new Track();
			t1.setId("1");
			t1.setTitle("kayan band");
			t1.setStreamURL(host + "/kayan_band.mp3");

			Track t2 = new Track();
			t2.setId("2");
			t2.setTitle("west elbalad");
			t2.setStreamURL(host + "/west_elbalad.mp3");

			list.add(t1);
			list.add(t2);

			Gson g = new Gson();

			return g.toJson(list);
		});
	}
}
