/**
 * @author Vishal Gaurav
 * 
 */
package algos;

import java.io.File;
import java.net.URL;

public class Tree {

    public static void main(String[] args) {
        File dir = getFileFromArgs(args);
        tree(dir,1);
    }
    
    private static void tree(File dir,int level) {
        String prefix = getLevelPrefix(level);
        //printCurrentDirectory(prefix,dir);
        if(checkForValid(dir)){
            File[] fileList = dir.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                 printFile(prefix,fileList[i]);
                 if(fileList[i].isDirectory()){
                     tree(fileList[i], level+1);
                 }
            }
        }
    }
    
    private static String getLevelPrefix(int level){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
    
    private static void printCurrentDirectory(String prefix, File dir) {
        System.out.println(prefix + " " + dir.getAbsolutePath());
    }

    private static void printFile(String prefix,File file){
        System.out.println(prefix + " " + file.getName());
    }
    private static File getFileFromArgs(String[] args) throws SecurityException{
        File resultFile = null;
        if(args.length > 0){
            resultFile = new File(args[0]);
        }else{
            resultFile = getDefault();
        }
        return resultFile;
    }
    
    private static File getDefault(){
        URL location = Tree.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(location.getFile());
        return new File(location.getFile());
    }
    
    private static boolean checkForValid(File dir){
        boolean result = true;
        if(!dir.isDirectory()){
            result = false;
            System.out.println("Not a directory :- " + dir.getAbsolutePath());
        }
        return result;
    }
    
}
