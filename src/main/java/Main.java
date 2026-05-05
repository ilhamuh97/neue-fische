public class Main {
    static void main(String[] args) {
        VideoPlayer vp = new VideoPlayer();
        MusicPlayer mp = new MusicPlayer();

        MediaController mc = new MediaController();

        mc.playMedia(vp, "Marvel Endgame");
        mc.addMedia(vp, "Despicable Me");
        mc.addMedia(vp, "How to Train Your Dragon");
        mc.addMedia(vp, "Spider Man");

        mc.playNextRandomMedia(vp);
        mc.playNextRandomMedia(vp);
        mc.playNextRandomMedia(vp);
    }
}
