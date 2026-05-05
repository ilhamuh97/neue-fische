public class MediaController {
    void playMedia (Playable playable, String title) {
        playable.play(title);
    }

    void playNextRandomMedia (Playable playable) {
        playable.playNextRandom();
    }


    void addMedia(MediaLibrary mediaLibrary, String title) {
        mediaLibrary.add(title);
    }

    void removeMedia(MediaLibrary mediaLibrary, String title) {
        mediaLibrary.remove(title);
    }
}
