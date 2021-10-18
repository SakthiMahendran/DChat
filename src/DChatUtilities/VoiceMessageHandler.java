package DChatUtilities;

import DChatSocket.Connection;

import javax.sound.sampled.*;
import java.io.*;

public class VoiceMessageHandler {

    private boolean send = false;
    private final Connection con;

    public VoiceMessageHandler(Connection con) {
        this.con = con;
    }

    public void startAudioRecording() {
        var audioSendingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    var audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
                    var dataInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
                    var sourceDataLine = (TargetDataLine) AudioSystem.getLine(dataInfo);

                    sourceDataLine.open();
                    sourceDataLine.start();

                    var audioInputStream = new AudioInputStream(sourceDataLine);

                    var audioFile = new File("tem.wav");

                    AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, audioFile);

                } catch (LineUnavailableException | IOException e) {
                    e.printStackTrace();
                }

            }
        }, "AudioSendingThread");

        audioSendingThread.start();
    }
/*
    public void playReceivedAudio() {
        var audioPlayingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    var audioStream = AudioSystem.getAudioInputStream(inputStream);
                    var audioClip = AudioSystem.getClip();

                    audioClip.open(audioStream);
                    audioClip.loop(0);

                    audioClip.start();

                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }, "AudioPlayingThread");

        audioPlayingThread.start();
    }*/
}
