/** 
* Test.java
*/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.security.SecureRandom;
public class Test1 {
	public static int taskNum;
	public static void  main(String[]  args) {
		Scanner input = new Scanner(System.in);
		SecureRandom random = new SecureRandom();
		
		System.out.println("\n\n Which Type of request do you have   ?");
		System.out.println("\n1) PERIODIC REQUEST\n2) TIME REQUEST\n3) EVENT REQUEST");
		int choice = input.nextInt();
        System.out.println( "Enter the num of Tasks :" );
        taskNum = input.nextInt();

		switch(choice) {
		case 1:
		
			Calendar cal = Calendar.getInstance();
        	SimpleDateFormat sdf = new SimpleDateFormat("HH");
        	SimpleDateFormat sdfm = new SimpleDateFormat("mm");
        	System.out.println( "System Hour = "+sdf.format(cal.getTime()) );
			int baseMinute[] = new int[taskNum];	// Starting Time Minutes
			int taskInterval[] = new int[taskNum];	// Time Interval Bewteen to Successive Tasks
			int endTime[] = new int[taskNum];		// Total Task Time

			System.out.printf("Details of the Tasks : \n\n");
			String tempH=sdf.format(cal.getTime());
			String tempM=sdfm.format(cal.getTime());
			int baseHour = Integer.parseInt(tempH);
			int baseMin = Integer.parseInt(tempM);
			for(int i = 0; i < taskNum; i++) {
				System.out.println("Task-#" + (i+1));

				System.out.printf("Base Minute : ");
				baseMinute[i] = input.nextInt();
				while(baseMinute[i]<=baseMin && baseMinute[i]<=60){
					
					System.out.println("Request Time elapzed Plzzz Re-enter =>");
					baseMinute[i] = input.nextInt();
					
				}

				System.out.printf("Time Interval : ");
				taskInterval[i] = input.nextInt();

				System.out.printf("Total Time To Run : ");
				endTime[i] = input.nextInt();
				endTime[i] /= taskInterval[i];
			}

			int interval[][] = new int[taskNum][60];

			for(int i = 0; i < taskNum; i++) {
				for(int j = 0; j < endTime[i]; j++) {
					//System.out.println(baseMinute[i]+" and "+taskInterval[i]);
					interval[i][j] = baseMinute[i] + taskInterval[i];
					baseMinute[i]=interval[i][j];
					System.out.println(baseHour+":"+interval[i][j]);
				}
			}
	
			try{
				for(int i = 0; i < taskNum; i++) {
					for(int j = 0; j < endTime[i]; j++) {
						for(int k = 0; k < endTime[i]; k++) {
							if(interval[i][k] == interval[i+1][j]) {
								if(interval[i][k]!=0){
								System.out.println("Tasks " + (i+1) + " & " + (i+2) +
								 " Overlapping at " + interval[i][k]);
							 
								sensor(k);}
							}
						}
					}
				}
			}
			catch(Exception e){
				System.out.println(" ");
			}
			break;

		case 2 :
			int newBaseMinute[] = new int[100];
			for(int i = 0; i < taskNum; i++) {
				System.out.println("Task-#" + (i+1));

				System.out.printf("Base Minute : ");
				newBaseMinute[i] = input.nextInt();
			}

			for(int i = 0; i <taskNum; i++) {
				sensor(newBaseMinute[i]);
			}
			break;
		case 3 :
			System.out.printf("Enter the alert temperature(HIGH) : ");
			int	high = input.nextInt();
			System.out.printf("Enter the alert temperature(LOW) : ");
			int	low = input.nextInt();
			int i=1;
			while(i==1){
				int answer = random.nextInt((60 - 15) + 1) + 15;
				if(answer>=high){
					System.out.printf("EVENT ALERT! SCORCHING ("+answer+"'C)\n");
					break;
				}
				else if(answer<=low){
					System.out.printf("EVENT ALERT! FREEZING ("+answer+"'C)\n");
					break;
				}
				else{
					System.out.printf("Temperature is ("+answer+"'C)\n");
					}
			}
			break;

		default :
			break;
		}
	}
	


		public static void sensor(int k) {
			System.out.println("Temp from ANN");
		}
}
