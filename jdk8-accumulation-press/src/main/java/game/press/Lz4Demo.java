package game.press;

import houzm.accumulation.jdk8.JsonUtil;
import java.io.IOException;
import java.util.Arrays;

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
//        compress();
//        decompress();
        compressStr();
    }

    private static void compressStr() {
        String srcStr = "我是中国人";
        byte[] srcStrBytes = srcStr.getBytes();
        byte[] compressedBytes = Lz4Util.compressedByte(srcStrBytes);
        System.out.println("压缩后字节码："+Arrays.toString(compressedBytes));
        System.out.println("压缩后字节码转换为string："+ Arrays.toString(compressedBytes));
        System.out.println("压缩后字节码转换为string再转换为bytes："+ JsonUtil.jsonToPojo(JsonUtil.objectToJson(compressedBytes), byte[].class));
//        System.out.println(""+ );
        byte[] decompressorBytes = Lz4Util.decompressorByte(JsonUtil.objectToJson(compressedBytes).getBytes(), srcStrBytes.length);
        System.out.println("解压后："+new String(decompressorBytes));

    }

    private static void decompress() {
        try {
            byte[] src = Lz4Util.returnFileByte("E:/batchflight.txt");
            byte[] srcbytes = Lz4Util.returnFileByte("E:/batchflight-after.txt");
            byte[] bytes1 = Lz4Util.decompressorByte(srcbytes, src.length);
            Lz4Util.createFile(bytes1, "E:/batchflight-after-de.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
