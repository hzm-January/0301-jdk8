package game.press;

import java.io.IOException;

/**
 * Package: game.press
 * Author: houzm
 * Date: Created in 2018/10/9 16:28
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class Lz4Demo {
    public static void main(String[] args) {
        compress();
    }

    private static void compress() {
        try {
            byte[] bytes = Lz4Util.returnFileByte("E:/batchflight.txt");
            byte[] bytes1 = Lz4Util.compressedByte(bytes);
            Lz4Util.createFile(bytes1, "E:/batchflight-after.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
