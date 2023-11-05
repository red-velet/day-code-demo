package str;

/**
 * author: chiou
 * createTime: 2023/11/5
 * description: 路径加密
 */
public class PathReplace {
    //把路径的.替换为空格
    public String pathEncryption(String path) {
        char[] charArray = path.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '.') {
                charArray[i] = ' ';
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String res = new PathReplace().pathEncryption("abc bcd ss c c");
        System.out.println("res = " + res);
    }
}
