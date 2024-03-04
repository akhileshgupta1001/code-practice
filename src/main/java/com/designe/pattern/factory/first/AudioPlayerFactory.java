package com.designe.pattern.factory.first;

public class AudioPlayerFactory {
    public static AudioPlayer getPlayer( MediaFormat format, int volume, double playBackRate){
        switch(format){
            case MP3 : return new MP3Player(volume, playBackRate);
            case FLAC : return new FLACPlayer(volume, playBackRate);
            case WAV : return new WAVPlayer(volume,  playBackRate);
        }
        return null;
    }
}
