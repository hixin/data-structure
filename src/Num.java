import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Description TODO
 * @Author: sain
 * @Date 19-5-13 下午4:15 星期一
 * ================================================================================
 * 温馨提示
 * 代码千万行，注释第一行。
 * 命名不规范，同事泪两行。
 */
public class Num {

    final static int NUM = 1* 1000;
    final  String PATH1 = "/home/sain/log/test/test.text";
    final  String PATH2 = "/home/sain/log/test/test2.text";
    static List<Integer> numList = new ArrayList<>();


    public void generate() throws IOException{
        Random random = new Random();
        for (int i =0; i < NUM; i ++) {
            int j = random.nextInt(NUM);
            numList.add(j);
            write(j + "", PATH1);
        }
    }

    public void getTop100() throws IOException{
        for (int i =0; i < 100; i ++) {
            Collections.sort(numList);
            int m = numList.get(i);
            write(m + "", PATH2);
        }
    }



    void write(String content, String path) throws IOException {
        RandomAccessFile file = new RandomAccessFile(new File(path), "rw");
        long len = file.length();
        file.seek(len);
        file.write(content.getBytes());
        file.writeBytes("\r\n");
    }
}
