/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author LEGION
 */
public class compressor {
    public static void method(File file)throws IOException{
        String fileDirectory= file.getParent();
        
        FileInputStream fis= new FileInputStream(file);
        FileOutputStream fos= new FileOutputStream(fileDirectory+"CompressedFile.gz");
        GZIPOutputStream gzip= new GZIPOutputStream(fos);
         int x=1024*1024;
        byte[] buffer= new byte[x];
        int len;
        
        while((len=fis.read(buffer))!=-1){
            gzip.write(buffer, 0, len);
        }
        
        gzip.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String[] args) throws IOException{
        File path= new File("/Users/LEGION/Downloads/Compressor/compressordecompressor/Testfile");
        method(path);
    }
}
