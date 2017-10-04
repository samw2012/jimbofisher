public class Song {
    String name;
    String artist;
    float playtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public float getPlaytime() {
        return playtime;
    }

    public void setPlaytime(float playtime) {
        this.playtime = playtime;
    }

    public Song(String name, String artist, float playtime){
        this.name = name;
        this.artist = artist;
        this.playtime = playtime;
    }

    public boolean equals(Song s){
        if(this == s){
            return true;
        }
        return false;
    }

    public String toString(){
        String s = "";

        s+= "song: " + this.name + ", artist: " + this.artist + ", playtime: " + this.playtime;

        return s;
    }
}
