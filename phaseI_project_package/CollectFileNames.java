package phaseI_project_package;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class CollectFileNames {
	String Location;
	File[] listOfFiles;
	String[] filename;
	String[] subdirname;
	String[] newfilename;
	String[] newsubdirname;
	int filecount=0;
	int subdircount=0;
	public void filecheck(String Loc) {
		File folder = new File(Loc);
		if (folder.exists()){
		listOfFiles = folder.listFiles();
		filename = new String[listOfFiles.length];
		subdirname = new String[listOfFiles.length];
		filecount=0;
		subdircount=0;
		
// Add names to the Arrays
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  filename[filecount] = listOfFiles[i].getName();
			  filecount +=1 ;
		    //System.out.println("File: " + listOfFiles[i].getName());
		    
		    
		  } else if (listOfFiles[i].isDirectory()) {
			  subdirname[subdircount] = listOfFiles[i].getName();
			  subdircount +=1 ;
		    //System.out.println("SubDirectory: " + listOfFiles[i].getName());
		    
		  }
		}
		
		//Clearing the unwanted space in the Array, by copying the Array to New Array & later nulling the Original Array.
		// This step will leave it for the garbage collector to delete the Array.
		//Added for Efficient Space Usage
		newfilename = new String[filecount];
		newsubdirname = new String[subdircount];
	
		for (int i=0; i<filecount; i++) {
			newfilename[i] = filename[i];
			//System.out.println(newfilename[i]);
		}
	
		for (int i=0; i<subdircount; i++) {
			newsubdirname[i] = subdirname[i];
			//System.out.println(newsubdirname[i]);
		}
		
		filename = null;
		subdirname = null;
		}
		else {
			System.out.println("Enter a valid Directory");
			Scanner sc=new Scanner(System.in);
			Location=sc.next();
		}
	}
	
	
	public static void main(String[] args) {
		
	CollectFileNames fn = new CollectFileNames();
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Application Name: File Handler");
	System.out.println("Developer Name: Bharathy K");
	System.out.println("User Interface lets you specify the Root Directory for the application. All operations happens on this root directory"
			+ "\n"+ "Kindly provide a valid Directory Location in your system. " + "You can later choose one of the features");
	System.out.println("/////////////////////////////////////////////////");
	
	System.out.println("Enter the Root Directory location to pick:  ");
	System.out.println("For example type: C:\\Users\\<YourUserName>\\Desktop\\<FolderName>");
	

	fn.Location=sc.next();
	File folder = new File(fn.Location);
	while (folder.exists()==false) {
		
		System.out.println("Enter a valid Directory");
		fn.Location=sc.next();
		folder = new File(fn.Location);
		
		
		
	}
	fn.filecheck(fn.Location);
	
	System.out.println("Enter the option(1,2,3), you like to perform:");
	System.out.println("1. Retrieving the file names in an ascending order");
	System.out.println("2. Business-level operations");
	System.out.println("3. Option to close the application");
	int option = sc.nextInt();
	
	
	
	FileOutputStream Stream=null;
	
		
		
		while(option <=3) {
		
		if(option==1) {
		//Quick Sort Algorithm
		System.out.println("/////////////////////////////////////////////////");
		System.out.println("Sorting - Starts");
		
		QuickSortNames.quickSort(fn.newfilename, 0, fn.filecount - 1);
		System.out.println("Sorted File Names: ");
		QuickSortNames.printArray(fn.newfilename, fn.filecount);

		QuickSortNames.quickSort(fn.newsubdirname, 0, fn.subdircount - 1);
		System.out.println("Sorted Directory Names: ");
		QuickSortNames.printArray(fn.newsubdirname, fn.subdircount);
		}
		else if(option ==2) {
			
			System.out.println("Enter the sub-option:");
			System.out.println("1. Option to add a user specified file to the application\r\n"
					+ "\r\n"
					+ "2. Option to delete a user specified file from the application\r\n"
					+ "\r\n"
					+ "3. Option to search a user specified file from the application\r\n"
					+ "\r\n"
					+ "4. Navigation option to close the current execution context and return to the main context");
			int suboption = sc.nextInt();
			while (suboption <= 4) {
			
			if (suboption==3) {
				System.out.println("Enter file name to search:");
				String searchablefile=sc.next();
				fn.filecheck(fn.Location);
				QuickSortNames.quickSort(fn.newfilename, 0, fn.filecount - 1);
				String[] sa = QuickSortNames.sorted(fn.newfilename);
				
				
				 int result = BinarySearchNames.binarySearch(sa, searchablefile);
				 
			        if (result == -1)
			            System.out.println("Element not present");
			        else
			            System.out.println("Element found at "
			                              + "index " + result);
		}
			else if(suboption==2) {
				System.out.println("Enter the name of the File, to be deleted: ");
				String filetod=sc.next();
				String Location1 = fn.Location.replace("\\", "\\\\");
				String Location2 = Location1.concat("\\\\").concat(filetod);
				File file=new File(Location2);
				boolean contains = file.exists();
				System.out.println("File present:"+contains);
				if(Stream != null) { 
				try {
					Stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(contains==true ) {
					System.out.println("File Deleted:");
					System.out.println(file.delete());
				
				//boolean yes=file.exists();
				
				}
				//fn.filecheck(fn.Location);

				
			}
			else if(suboption==1) {
				System.out.println("Enter the name of the File, to be added: ");
				String filetoa=sc.next();	
				
				String Location3 = fn.Location.replace("\\", "\\\\");
				String Location4 = Location3.concat("\\\\").concat(filetoa);
				try {
					Stream = new FileOutputStream(Location4, true);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
				
			}
			else if(suboption==4) {
				System.out.println("Returning to main program");
				break;
			}
			System.out.println("Enter the sub-option:");
			System.out.println("1. Option to add a user specified file to the application\r\n"
					+ "\r\n"
					+ "2. Option to delete a user specified file from the application\r\n"
					+ "\r\n"
					+ "3. Option to search a user specified file from the application\r\n"
					+ "\r\n"
					+ "4. Navigation option to close the current execution context and return to the main context");
			suboption = sc.nextInt();
			fn.filecheck(fn.Location);
			}
			}
		else if(option==3) {
			System.out.println("Exiting application. You can close the window");
			break;
		}
		System.out.println("Enter the option(1,2,3), you like to perform:");
		System.out.println("1. Retrieving the file names in an ascending order");
		System.out.println("2. Business-level operations");
		System.out.println("3. Option to close the application");
		option = sc.nextInt();
		
		}
		}
}
