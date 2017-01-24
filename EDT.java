import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;
public class Project3
{
  public static void main(String [] args)throws IOException
  {
    try
    {
      FileSystemView fsv = FileSystemView.getFileSystemView();
      String x=" ";
      x=x+("Home directory: " + fsv.getHomeDirectory())+"\n";
      File[] f = File.listRoots();
      for (int i = 0; i < f.length; i++)
      {
        if(i>=4)
          x=x+("\nNEW DRIVE DETECTED:")+"\n";
        if(fsv.isDrive(f[i])==true)
        {
            x=x+("\nDrive: " + f[i])+"\n";
            x=x+("Display name: " + fsv.getSystemDisplayName(f[i]))+"\n";
            x=x+("Readable: " + f[i].canRead())+"\n";
            x=x+("Writable: " + f[i].canWrite())+"\n";
        }
        if(fsv.isFloppyDrive(f[i])==true)
        {
         x=x+("\nDrive: " + f[i])+"\n";
         x=x+("Display name: " + fsv.getSystemDisplayName(f[i]))+"\n";
         x=x+("Readable: " + f[i].canRead())+"\n";
         x=x+("Writable: " + f[i].canWrite())+"\n";
        }
      }
      JOptionPane.showMessageDialog(null,x);
      int v=0;
  while(v==0)
   {  String q=JOptionPane.showInputDialog("\n select your choice 1.Show total space 2.Show used space 3.Show files and folders 4.Copy 5.Exit 6.Invalid Drive Selected, Check carefully");
      int i=Integer.parseInt(q);
      if(i==1)
      {
        checkTotal();
      }
      else if(i==2)
      {
        checkUsed();
      }
      else if(i==3)
      {
        find();
      }
      /*else if(i==4)
      {
        copy();
      }*/
      else if(i==5)
      {
        v++;
       break;
      }
   }
 }
   catch(Exception e)
   {
       System.out.println("Invalid Drive Selected, Check carefully");
   }
 }
  public static void find()throws IOException
    {
     String k=JOptionPane.showInputDialog("\n enter the drive name");
       String v=" ";
       File f2=new File(k+":/");
       String f[]=f2.list();
       for(int i=0;i<f.length;i++)
       {
         String p=f[i];
          int a=p.indexOf('.');
          if(a>0)
          {
            v=v+(f[i]+"\t \t<FILE> \n");
          }
          else{
            v=v+(f[i]+"\t \t<DIR> \n");
         }
        }
        JOptionPane.showMessageDialog(null,v);
    }
    public static void checkUsed()throws IOException   {
        String z=JOptionPane.showInputDialog("\n enter the drive name");
        String v=" ";
        File diskPartition = new File(z+":");
        long totalCapacity = diskPartition.getTotalSpace(); 
        long freePartitionSpace = diskPartition.getFreeSpace(); 
        long usablePatitionSpace = totalCapacity-freePartitionSpace; 
        v=v+("Used Space : " + usablePatitionSpace / (1024 *1024*1024) + " GB")+"\n";
        v=v+("Free Space : " + freePartitionSpace / (1024 *1024*1024) + " GB")+"\n";
        JOptionPane.showMessageDialog(null,v);
    }
    public static void checkTotal()throws IOException   {
        String z=JOptionPane.showInputDialog("\n enter the drive name");
        String v=" ";
        File diskPartition = new File(z+":");
        long totalCapacity = diskPartition.getTotalSpace(); 
        long freePartitionSpace = diskPartition.getFreeSpace(); 
        long usablePatitionSpace = totalCapacity-freePartitionSpace; 
        v=v+("Total partition size : " + totalCapacity / (1024*1024*1024) + " GB")+"\n";
        JOptionPane.showMessageDialog(null,v);
    }
    public static void copy()
  {
    try
    { String drive=JOptionPane.showInputDialog("\n Enter the drive name from where file will be copied");
      String file=JOptionPane.showInputDialog("\n Enter the file name");
      String drivecopy=JOptionPane.showInputDialog("\n Enter drive you want to copy");
      FileInputStream fin=new FileInputStream(drive+":/"+file);
      FileOutputStream fout=new  FileOutputStream(drivecopy+":/"+file);
      while(true)
      {
        int r=fin.read();
        if(r==-1)
          break;
        else
          fout.write((char)r);
      }
    }
    catch(Exception e)
    {

    }
  }
}