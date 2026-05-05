import controllers.MediaController;
import mediaPlayers.MusicPlayer;
import mediaPlayers.VideoPlayer;

void main() {
    VideoPlayer vp = new VideoPlayer();
    MusicPlayer mp = new MusicPlayer();

    MediaController mc = new MediaController();

    mc.playMedia(vp, "Marvel Endgame");
    mc.addItem(vp, "Despicable Me");
    mc.addItem(vp, "How to Train Your Dragon");
    mc.addItem(vp, "Spider Man");

    mc.playNextRandom(vp);
    mc.playNextRandom(vp);
    mc.playNextRandom(vp);

    mc.playMedia(mp, "Set Fire to the Rain");
    mc.addItem(mp, "Beat It");
    mc.addItem(mp, "Bohemian Rhapsody");
    mc.addItem(mp, "Like a Rolling Stone");
    mc.addItem(mp, "Imagine");

    mc.playNextRandom(mp);
    mc.playNextRandom(mp);
    mc.playNextRandom(mp);

    mc.removeItem(mp, "Imagine");

    mc.showList(vp);
    mc.showList(mp);
}
