/*




*/

import groovy.io.*
import groovy.io.FileType


import groovy.transform.SourceURI
import java.nio.file.Path
import java.nio.file.Paths

class Test{

	static def listFiles(){

		//User Input of where the files are within your computer
		def path = System.console().readLine "What is the file path? (Press Enter if unsure):"

		if(!path?.trim()){

			//If unsure of the file path this program
			//will output all groovy files within 
			//your computer and where they are located.
			def files = []
			new File(".").eachFile { 
    		if (it.name.endsWith(".groovy") ) files << it 
			}
			println("File project:"+files)
			println("File Location:"+ new File("..").absolutePath)

		}else{

		//Concatenated parent directory to where you want to go.
		def full_path = "../${path}"
		println("")
		println("Full path:"+full_path);

		//Created an empty list to Store all the file names within a directory
		def list = []
		def dir = new File(full_path)
		dir.eachFileRecurse (FileType.FILES) { file ->
  		list << file
		}

		//Printed out file names
		list.each {
  			println it.path
		}


		}


	}

	static def getFileInfo(){

		//User Input on what file you want information from
		def file_name = System.console().readLine "What is the name of the file?:"

		//Concatenated '.txt' extension just in case the user forgot to place it
		//when looking for a text file
		if(file_name.contains('.txt')){
		}else{
			file_name = "${file_name}.txt"
		}

		File file = new File(file_name)
		
		//Prints out information of the file and or directory you are looking into.
		println("File information:")
   		println("Is this a File: ${file.isFile()}");
   		println("Is this a Directory: ${file.isDirectory()}");
   		println("File Size : ${file.length()} bytes");
   		println(' ');


   		//Prints out content of the text file
   		println "Below is the content of the file:"
   		println(" ");
     	def line
      	file.withReader { reader ->
         	while ((line = reader.readLine())!=null) {
            println "${line}"

         	}
     	}

	}

	static def createFile(){

		//User input of name you want for new file to be created
		def file_name = System.console().readLine "Name of new file to create:"
		
		//Concatenated '.txt' extension just in case the user forgot to place it
		//when creating a new text file
		if(file_name.contains('.txt')){
		}else{
			file_name = "${file_name}.txt"
		}


		def newFile = new File(file_name)
		newFile.createNewFile()

		//User input as too what the file will contain. Since it is a text file
		//It will only contains Strings and text. The user is done adding to the text
		//once they hit enter.
		def message = System.console().readLine "Enter contents of new file (press Enter to exit out):\n"
		newFile.write message
	}

	static def editFile(){

		//User input on what file they want to edit.
		def file_name = System.console().readLine "Choose a file you want to edit: "

		//Concatenated '.txt' extension just in case the user forgot to place it
		//when editing their new text file
		if(file_name.contains('.txt')){
		}else{
			file_name = "${file_name}.txt"
		}

		File file = new File(file_name)

		//User input whether or not they want to rewrite the entire file
		//with new text or just add new words/Sentences at the end of the text file.
		//By default, if rewrite or add is not chosen, then the user can specify
		//a specific word or sentence in the program they want to search and replace
		//with a new word or sentence of their own choice. 
		def choice = System.console().readLine "Rewrite/or Add (Type 'R' or 'r' for Rewrite / 'A' or 'a' for Add or Enter for none ):"

		if(choice.toLowerCase() =='r'){
			def message = System.console().readLine "Enter content for file:\n"
			file.write message
		}else if (choice.toLowerCase() == 'a'){
			def message = System.console().readLine "Enter content for file:\n"
			file.append("\n"+message)
		}else{

			//Default case within the if-else statements
			//Searches and replaces words/sentences in the text file from
			//user input choices.
			println("Instead we will replace words within the text file here")
			def toSearch = System.console().readLine "What word are your searching for?:"
			def toReplace = System.console().readLine "What word do you want to replace it with?:"
			file.text  = file.text.replace(toSearch,toReplace);


		}

	}

	 

	static def makeBackupFile(file, backup_file){

		//helper method called in the deleteFile() method
		//helps create new back_up files for files you are about to delete
		//if chosen too in the if-else statement.

		//creates a new file from the argument backup_file that you
		//passed in, which is a string.

		File newFile = new File(backup_file)
		newFile.createNewFile()

		//concats file data from the file argument passed in,
		//which is the file that is about to be deleted in the
		//deleteFile() method.
		newFile << file.text
	}

	static def deleteFile(){

		//User input of what file they want to delete
		def file_name = System.console().readLine "Choose a file to delete:"

		//Concatenated '.txt' extension just in case the user forgot to place it
		//when deleting a new text file
		if(file_name.contains('.txt')){
		}else{
			file_name = "${file_name}.txt"
		}
		
		def file = new File(file_name)

		//Asks users if they want to create a backup file for the text file
		//they are about to delete.
		def choice = System.console().readLine "Do you want to make a back up? (Y/N):"
		if(choice.toLowerCase() =='y'){
			file_name = "backup_${file_name}"

			//helper method to create back up file, passes the file that is 
			//going to be deleted and new file name.

			makeBackupFile(file, file_name)

			//after making up a backup file, the main file gets deleted.
			file.delete()
	
		}else if (choice.toLowerCase() == 'n'){
			//file that is specified by user gets deleted without making
			//a backup.
			file.delete()
		}

	}

	static int get_menu_choice(){

		//The get_menu_function displays the menu of the program
		//and gets a validated choice from the user.
		println("")
		println("Menu")
		println("---------------------")
		println("1. List Files in directory")
		println("2. Get File Information")
		println("3. Create New File")
		println("4. Edit an Existing File")
		println("5. Delete a File")
		println("6. List Files Recently Modified")
		println("7. Quit Program")

		def choice = System.console().readLine "Enter your choice: "
		//coverts user input into an integer.
		int i = Integer.parseInt(choice);  	
		

		//validates whether or not the user input is from 1-7,
		//if otherwise, input a number within that range.
		while(i < 1 || i > 7){
			choice = System.console().readLine "Please Enter a valid choice: "
			i = Integer.parseInt(choice); 
		}

		//returns the user-inputted choice.
		return i;

	}

	//List the date and time of when the files where last modified
	static def listModifiedFiles(){

		//User Input of where the files are within your computer
		def path = System.console().readLine "What is the file path?:"

		//Concatenated parent directory to where you want to go.
		def full_path = "../${path}"
		println("")
		println("Full path:"+full_path);

		//Prints out the files in descending order of recently modified files.
		//It gives the date and when exactly the time in the day 
		//where the files modified.
		new File('../Groovy Projects').listFiles().sort{a,b -> b.name.compareToIgnoreCase(a.name)}.each{ File f ->
    			def dateToString = String.format('%tm-%<td-%<tY %<tI:%<tM:%<tS', f.lastModified())
    			println f.name + " "+ dateToString
		}
	}

	public static void main(String[] args){


		//listFiles();
		//getFileInfo();
		//createFile();
		//editFile();
		//listModifiedFiles();
		//deleteFile();

		//Global variables and choices
		//the user can pick when using the 
		//program
		def LIST = 1;
		def FILE_INFO= 2;
		def CREATE = 3;
		def CHANGE = 4;
		def DELETE = 5;
		def RECENT = 6
		def QUIT = 7;


		def choice = 0;		
		
		//A loop that asks a user's choice
		//a menu will display that will prompt
		//a user to choose several choices
		//and depending on the choice,
		//6 different events will happen in the program.
		while (choice != QUIT){
			choice = get_menu_choice()
			println(choice)
			if (choice == LIST){
				listFiles();
			}else if (choice == FILE_INFO){
				getFileInfo();
			}else if (choice == CREATE){
				createFile();
			}else if (choice == CHANGE){
				editFile();
			}else if (choice == RECENT){
				listModifiedFiles();
			}else if (choice == DELETE){
				deleteFile();
			}
		}


	}
		

}

