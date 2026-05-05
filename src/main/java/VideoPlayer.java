import java.util.ArrayList;
import java.util.Random;

public class VideoPlayer implements Playable, MediaLibrary {
    ArrayList<String> videos = new ArrayList<>();
    @Override
    public void play(String songTitle) {
        System.out.println("Play video: " + songTitle);
    }

    @Override
    public void playNextRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(videos.size());

        play(videos.get(randomIndex));
    }

    @Override
    public void add(String item) {
        videos.add(item);
    }

    @Override
    public void remove(String item) {
        videos.remove(item);
    }

    @Override
    public ArrayList<String> getAll() {
        return videos;
    }
}
