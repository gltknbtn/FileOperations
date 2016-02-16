package fileoperations;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileOperation4Test {
    
    public static void main(String[] args) {
        createFileLabelDirectory("C:/Users/gultekin.butun.GORKEM/Desktop/feretDups/probe_dup1_aging");
        
    }

    private static void createFileLabelDirectory(String path) {
        String[] exts = new String[6];
        exts[0] = "png";
        exts[1] = "PNG";
        exts[2] = "jpg";
        exts[3] = "JPG";
        exts[4] = "jpeg";
        exts[5] = "JPEG";
        
        Collection<File> fileCollection = FileUtils.listFiles(new File(path), exts, true);
        
        List<File> fileList = new ArrayList<>(fileCollection);
        
        
        for (int i = 0; i < fileList.size(); i++) {
            String fileLabel = extractFileLabel(fileList.get(i));
            String parentDir = fileList.get(i).getParent();
            File createdDir = new File(parentDir + "/" + fileLabel);
            
            if (!createdDir.exists()) {
                if (createdDir.mkdir()) {
                    System.out.println(createdDir.getPath() + " directory created");
                    fileList.get(i).renameTo(new File(createdDir+"/" + fileList.get(i).getName()));
                }else System.out.println(parentDir + "/" + fileLabel +" directory could not created");
            }else{
                fileList.get(i).renameTo(new File(createdDir+"/" + fileList.get(i).getName()));
            }
        }
        
    }

    private static String extractFileLabel(File file) {
        String fileLabel = "";
        fileLabel = file.getName().substring(0, 5);
        return fileLabel;
    }
    

}
