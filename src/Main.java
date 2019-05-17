import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    final static int NUM = 1* 1000;
    final static String PATH1 = "/home/sain/log/test/test.text";
    final static String PATH2 = "/home/sain/log/test/test2.text";
    static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        System.out.println("Hello World!");

        Random random = new Random();

        for (int i =0; i < NUM; i ++) {
            int j = random.nextInt(NUM);
            numList.add(j);
            write(j + "", PATH1);
        }


        for (int i =0; i < NUM; i ++) {
            Collections.sort(numList);
            int m = numList.get(i);
            write(m + "", PATH2);
        }
    }


    static void write(String content, String path) throws IOException {
        RandomAccessFile file = new RandomAccessFile(new File(path), "rw");
        long len = file.length();
        file.seek(len);
        file.write(content.getBytes());
        file.writeBytes("\r\n");
    }
}
