/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import Basics.BString;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Matías
 */
public class ZipActions {
    
    public static void zipFile(File F, File Zip, boolean convert) throws FileNotFoundException, IOException{
        if(!Zip.getName().endsWith(".zip"))
            throw new IOException("Destination must to be a zip file");
        try (FileOutputStream fos = new FileOutputStream(Zip); 
                ZipOutputStream zos = new ZipOutputStream(fos);
                FileInputStream fis = new FileInputStream(F)){
            ZipEntry zE = new ZipEntry(F.getName());
            zos.putNextEntry(zE);
            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
        }
        if(convert)
            F.delete();
    }
    
    public static void zipFile(File F, File Zip) throws IOException{
        zipFile(F,Zip,true);
    }
    
    public static void unZipFile(File Z, File destDir) throws FileNotFoundException, IOException{
        byte[] buffer = new byte[1024];
        destDir. mkdir();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(Z.getPath()))) {
            ZipEntry zE = zis.getNextEntry();
            while (zE != null) {
                File newFile = checkNewFile(destDir, zE);
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int length;
                    while ((length = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                }
                zE = zis.getNextEntry();
            }
        }
    }
    
    private static File checkNewFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }
        return destFile;
    }
    
    public static void unZipFile(File Z) throws IOException{
        String FolderName = BString.conv(Z.getName()).removeString(Z.getName().lastIndexOf("."));
        File Here = new File(FolderName);
        Here.mkdir();
        unZipFile(Z,Here);
    }
    
}
