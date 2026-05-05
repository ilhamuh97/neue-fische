package controllers;

import interfaces.MediaLibrary;
import interfaces.Playable;

public class MediaController {
    public void playMedia(Playable playable, String title) {
        playable.play(title);
    }

    public void playNextRandom(Playable playable) {
        playable.playNextRandom();
    }


    public void addItem(MediaLibrary mediaLibrary, String title) {
        mediaLibrary.add(title);
    }

    public void removeItem(MediaLibrary mediaLibrary, String title) {
        mediaLibrary.remove(title);
    }

    public void showList(MediaLibrary mediaLibrary) {
        mediaLibrary.showList();
    }
}
