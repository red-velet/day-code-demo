import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author red-velvet
 * @since 2024/3/4
 */


public class RenameMP3Files {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\96946\\Music";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            renameFiles(directory);
            System.out.println("文件重命名完成！");
        } else {
            System.out.println("指定的目录不存在或不是一个文件夹。");
        }
    }

    public static void renameFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    renameFiles(file); // 递归处理子文件夹
                } else {
                    if (file.getName().contains("[www.slider.kz]")) {
                        String newName = file.getName().replace("[www.slider.kz]", "");
                        File newFile = new File(file.getParent(), newName);
                        if (file.renameTo(newFile)) {
                            System.out.println("文件重命名成功：" + file.getName() + " -> " + newName);
                        } else {
                            System.out.println("文件重命名失败：" + file.getName());
                        }
                    }
                }
            }
        }
    }
}

