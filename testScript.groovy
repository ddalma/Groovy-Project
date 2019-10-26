/*
Console console=System.console();
def name=console.readLine("What is your name? ")
println "Welcome to Groovy, $name!"
*/

class GroovyTut{
	
	static void main(String[] args){
		/*
		def age = "Dog";
		age = 40;

		def randNum = 2.0;
		
		#Math 
		println("Biggest Int "+ Integer.MAX_VALUE);
		println("Smallest Int "+ Integer.MIN_VALUE);

		println("Biggest Float "+ Float.MAX_VALUE);
		println("Smallest Float "+ Float.MIN_VALUE);

		println("Biggest Double "+ Double.MAX_VALUE);
		println("Smallest Double "+ Double.MIN_VALUE);
		
		println("Math.abs(-2.45) = "+Math.abs(-2.45));
		println("Math.round(-2.45) = "+Math.round(-2.45));	
		println("randNum.pow(3) = "+randNum.pow(3));		
		println("3.0.equals(2.0) = "+3.0.equals(2.0));		

		println("randNum.equals(Float.NaN) = "+randNum.equals(Float.NaN));		
		println("Math.sqrt(9) = "+Math.sqrt(9));
		println("Math.cbrt(27) = "+Math.cbrt(27));
		println("Math.ceil(2.45) = "+Math.ceil(2.45));
		println("Math.floor(2.45) = "+Math.floor(2.45));
		println("Math.min(2,3) = "+Math.min(2,3));
		println("Math.max(2,3) =" +Math.max(2,3));

		println("Math.abs(new Random.nextInt() % 100) + 1 = "+Math.abs(new Random().nextInt() % 100) + 1);

		
		
		#String Manipulation
		def name = "Derek";
		println("I am ${name}\n");
		println('I am ${name}\n');
		println("3rd Index of Name "+name[3]);
		println("Index of r "+name.indexOf('r'));
		println("1st 3 chars "+ name[0..2])
		println("Every Other Character "+ name[0,2,4]);
		println("Substring(1) = "+name.substring(1));
		println("Substring(1,4) = "+name.substring(1,4));
		println("My name "+name);
		println("My name ".concat(name));
		println("Length "+name.length());

		def repeatStr = "What I said is "*2;
		println(repeatStr - "What");
		println(repeatStr.split(" "));
		println(repeatStr.toList());

		println(repeatStr.replaceAll('I','she'));
		println("Uppercase "+name.toUpperCase());
		println("Lowercase "+name.toLowerCase());

		

		def randString = "Random";
		println("A $randString string");
		printf("A %s string \n",randString);
		printf("%-10s %d %.2f %10s \n",['Stuff',10,1.234,'Random']);

		def fName = System.console().readLine();
		println("Hello "+fName);

		print("Enter a number ");
		def num1 = System.console().readLine().toDouble();

		print("Enter another number ");
		def num2 = System.console().readLine().toDouble();

		printf("1st #: %.2f",num1);
		printf("2nd #: %.2f",num2);
		printf("%.2f + %.2f = %.2f \n",[num1,num2,num1+num2]);
		
		
		#List and Arrays
		def primes = [2,3,5,7,11,13];
		println("2nd Prime "+primes[1]);
		println("3rd Prime "+primes[2]);
		println("3rd Prime different way "+primes.get(2));

		def employee = ['Derek',40,6.25,[1,2,3]];

		println("2nd Number "+employee[3][1]);
		println("Length "+primes.size());
		primes.add(17);
		primes<<19;
		println(primes);
		primes + [29,31];
		println("Is Empty "+primes.isEmpty());
		println("1st 3 "+primes[0..2]);
		println("Matches "+primes.intersect([2,3,7]));
		println("Reverse "+primes.reverse());
		println("Sort "+primes.sort());
		println("Last "+primes.pop());


		#Maps
		def paulMap = [

		'name': 'Paul',
		'age' : 35,
		'address': '123 Main St',
		'list':[1,2,3]
		];

		println("Name "+paulMap['name']);
		println("Age "+paulMap.get('age'));
		println("List Item "+paulMap['list'][1]);

		paulMap.put('city','Los Angelos');
		println('Has City '+paulMap.containsKey('city'));
		println("Size "+paulMap.size());

		
		#Ranges
		def oneTo10 = 1..10;
		def aToZ = 'a'..'z';
		def zToA = 'z'..'a';
		//print(oneTo10);
		//print(aToZ);
		//print(zToA);
		print("Size "+oneTo10.size());
		println("Contains 11 "+oneTo10.contains(11));
		println("Get Last "+oneTo10.getTo());
		println("Get First "+oneTo10.getFrom());
	
		
		#conditionals
		def ageOld = 6;
		if(ageOld == 5){
			println("Go to Kindergarten");

		}else if((ageOld > 5) && (ageOld < 18)){
			printf("Go to grade %d \n",(ageOld - 5));
		}else{
			println("Go to College");
		}

		def canVote = true;

		println(canVote ? "Can Vote":"Can't Vote");

		switch(ageOld) {
			case 16: 
				println("You can drive");
				break;

			case 18:
				println("You can vote");
				break;

			default: println("Have Fun");
				break;
		}

		switch(ageOld) {
			case 0..6: println("Child"); break;
			case 7..12: println("Teenager"); break;
			case 13..18: println("Young Adult"); break;
			default: println("Adult");	
			
		}

		
		#while and for loops
		def i = 0;
		while(i < 10){
			if(i % 2){
				i++;
				continue;
			}
			if(i ==8){
				break;
			}
			println(i);
			i++;
		}

		for(i = 0; i < 5; i++){
			println(i);
		}

		for(j in 10..30){
			println(j);
		}
		
		
		def randList = [10,12,13,14];

		for(j in randList){
			println(j);
		}

		def custs = [
			100: "Paul",
			101: "Sally",
			102: "Sue",
		];

		for(cust in custs){
			println("$cust.value : $cust.key");
		}

		
		#Creating functions
		sayHello();

		println("5 + 4 = "+ getSum(5,4));

		def myName = "Derek";
		passByValue(myName);
		println("In Main "+ myName);

		def listToDouble = [1,2,3,4];
		listToDouble = doubleList(listToDouble);
		println(listToDouble);

		def nums = sumAll(1,2,3,4);
		println("Sum : "+nums)

		def fact4 = factorial(4);
		println("Factorial 4 = "+fact4);

		
	
		#Closures
		def greeting = "Goodbye";

		def sayGoodbye = {theName -> 
			println("$greeting $theName")}

		sayGoodbye("Derek");


		def numList = [1,2,3,4];
		numList.each {println(it)};

		def employees = [
		'Paul':34,
		'Sally':35,
		'Sam':36
		];

		employees.each{println("$it.key : $it.value");}

		def randNums = [1,2,3,4,5,6];


		def namelist = ['Doug','Sally','Sue'];
		def matchEle = namelist.find {item -> item =="Sue"}

		println(matchEle);

		def randNumList = [1,2,3,4,5,6];
		def numMatches = randNumList.findAll {
			item -> item > 4}

		println(numMatches);

		println("> 5:"+randNumList.any { item -> item > 5});

		println("> 1:"+randNumList.each { item -> item > 1});

		println("Double: "+randNumList.collect {item -> item *2});

		def getEven = {num -> return(num % 2 ==0)}
		def eveNums = listEdit(randNumList, getEven);
		println("Evens :"+eveNums);

		*/

		//File I/O

		//Reads the files
		new File("test.txt").eachLine {
			line -> println "$line";
		}

		//Rewrites the entire file
		new File("test.txt").withWriter('utf-8'){
			writer -> writer.writeLine("Line 4");
		}

		//Appends the new added lines into the end of file
		File file = new File("test.txt");
		file.append("Line 5");

		//print out the entire file in text
		println(file.text);

		//gives length of file in bytes
		println("File Size : ${file.length()} bytes");

		//Is it a file or not?
		println("File: ${file.isFile()}");

		//Is it a Directory or not?
		println("Dir: ${file.isDirectory()}");

		//creates a new file
		def newFile = new File("test2.txt");

		//copies contents from a different file to new file
		newFile << file.text;

		//deletes file
		newFile.delete();

		//list files in directory
		def dirFiles = new File("").listRoots();
		dirFiles.each {
			item -> println file.absolutePath;
		}

		new File("test.txt").eachFile() { file->  
    		println file.getName()}  


	}

	
	/*




	#creating functions
	static def sayHello(){
		println("Hello");
	}

	static def listEdit(list, clo){
		return list.findAll(clo);
	}

	static def getSum(num1=0,num2=0){
		return num1 + num2;
	}


	static def passByValue(name){
		name = "In Function";
		println("Name : "+name);
	}

	static def doubleList(list){
		def newList = list.collect{it * 2};
		return newList;
	}

	static def sumAll(int...num){
		def sum = 0;
		num.each{ sum += it;}
		return sum;
	}

	static def factorial(num){
		if(num <= 1){
			return 1;
		}else{
			return (num * factorial(num - 1));
		}
	}

	*/







}