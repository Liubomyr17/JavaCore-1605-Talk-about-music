package com.company;

/*

1605. Level 16 Lection 3. Talk about music
1. Change the Violin class so that it becomes a task for the thread. Use the MusicalInstrument interface
2. Implement the necessary method in the Violin thread. The implementation should be as follows:
2.1. Count the start time of the game - startPlaying () method.
2.2. Wait 1 second - sleepNSeconds (int n) method, where n is the number of seconds.
2.3. Count the end time of the game - stopPlaying () method.
2.4. Print the duration of the game in milliseconds to the console.
Example "Playing 1002 ms".

Requirements:
1. The Violin class should not be inherited from any additional class.
2. The Violin class must implement the MusicalInstrument interface.
3. The run method of the Violin class should call the startPlaying method.
4. The run method of the Violin class must call the sleepNSeconds method with a parameter of 1 second.
5. The run method of the Violin class must call the stopPlaying method.
6. The run method of the Violin class should print to the console the duration of the game in milliseconds. Use the format from the example.

 */

import java.util.Date;

/*
Поговорим о музыке
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " starts playing");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " stops playing");
            return new Date();
        }

        @Override
        public void run() {
            Date start = startPlaying();
            sleepNSeconds(1);
            Date finish = stopPlaying();

            System.out.println("Playing " + (finish.getTime() - start.getTime()) + " ms");
        }
    }
}


