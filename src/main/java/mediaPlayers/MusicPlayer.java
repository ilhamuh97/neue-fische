package mediaPlayers;

import interfaces.MediaLibrary;
import interfaces.Playable;

import java.util.ArrayList;
import java.util.Random;

public class MusicPlayer implements Playable, MediaLibrary {
    ArrayList<String> musics = new ArrayList<>();
    @Override
    public void play(String musicTitle) {
        System.out.println("Play song: " + musicTitle);
    }

    @Override
    public void playNextRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(musics.size());

        play(musics.get(randomIndex));
    }

    @Override
    public void add(String item) {
        musics.add(item);
    }

    @Override
    public void remove(String item) {
        musics.remove(item);
    }

    @Override
    public void showList() {
        for(String item: musics) {
            System.out.println(item);
        }
    }

    @Override
    public ArrayList<String> getAll() {
        return musics;
    }
}

