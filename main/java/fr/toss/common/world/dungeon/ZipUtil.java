package fr.toss.common.world.dungeon;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import fr.toss.common.Main;

public class ZipUtil
{
	public static OS getPlatform()
	{
	    String osName;
	    
	    osName = System.getProperty("os.name").toLowerCase();
	    if (osName.contains("win"))
	    	return OS.WINDOWS;
	    if (osName.contains("mac"))
	    	return OS.MACOS;
	    if (osName.contains("linux"))
	    	return OS.LINUX;
	    if (osName.contains("unix"))
	    	return OS.LINUX;
	    return OS.UNKNOWN; 
	}
	
	static String dirpart(String name)
	{
		int s;
		
		s = name.lastIndexOf(File.separatorChar);
		return s == -1 ? null : name.substring(0, s);
	}
	
	public static void unzip(InputStream inputStream, File outDir)
	{
	    ThreadZip thread;
	    
	    thread = new ThreadZip(inputStream, outDir);
	    thread.start();
	}
	
	static void extractFile(ZipInputStream in, File outdir, String name) throws IOException
	{
		byte[] 					buffer;
		BufferedOutputStream 	out;
		int						count;
		
		buffer = new byte[4096];
		out = new BufferedOutputStream(new FileOutputStream(new File(outdir, name)));
		count = -1;
		while ((count = in.read(buffer)) != -1)
			out.write(buffer, 0, count);
		out.close();
	}
	
	static void mkdirs(File outdir, String path)
	{
		File d = new File(outdir, path);
		if (!d.exists())
			d.mkdirs();
	}
	
	public static enum OS
	{
		LINUX, MACOS, SOLARIS, UNKNOWN, WINDOWS;
	}
}

class ThreadZip extends Thread implements Runnable
{
	InputStream inputStream;
	File outDir;
	
	public ThreadZip(InputStream inputStream, File outDir)
	{
		this.inputStream = inputStream;
		this.outDir = outDir;
	}

	@Override
	public void run()
	{
		Main.log("Unzipping into: " + outDir.getAbsolutePath());
		try
	    {
	    	ZipInputStream zin;
	    	ZipEntry entry;
	    	
	    	zin = new ZipInputStream(inputStream);
	    	entry = null;
	    	while ((entry = zin.getNextEntry()) != null)
	    	{
	    		String name = entry.getName();
	    		if (entry.isDirectory())
	    			ZipUtil.mkdirs(outDir, name);
	    		else
	    		{
	    			String dir = ZipUtil.dirpart(name);
	    			if (dir != null)
	    				ZipUtil.mkdirs(outDir, dir);
	    			ZipUtil.extractFile(zin, outDir, name);
	    		}
	    	}
	      zin.close();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
		
		Main.log("Unzip done");
	}
}