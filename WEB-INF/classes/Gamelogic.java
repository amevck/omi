import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;  

public class Gamelogic {


    static int gotfirst=1;
    static int First = -1;
    static int nextpaly = 0; 
    static int nexttrickpaly = -1; 
    static int won = -1;
    static int [][] array = new int[4][13];  
    static int []  now = new int[4];
    static int []  trick = new int[4];
    static int []  marks = new int[4];
    static int trump = 1;						
    static int d = 1;
    private static String object = "";
	public static void main(String[] args) {

		
		
	}

	public static JSONObject getobject(int id,String str,int i,HashMap<String , Integer> map){

		JSONObject obj2 = new JSONObject();

		if(nexttrickpaly == -1){

			Sarray.initmarks(marks); // initialy set marks to zero
		}

		if(i<4){

			obj2.put("message","wait until 4 plyers connected. "+i+" players connected"); // dont show cards untill all players join
			obj2.put("showCards" , false);
			obj2.put("showHand" , false);

		}

		else{

		if(d==1){

			S.deal(array);
			Sarray.init(now);
			Sarray.initmarks(trick);
			trump = array[3][12];                     // shuffle the mapping array and catch the last element as trump
			d=0;
		}

		

		obj2=S.getdeal(obj2,map.get(str),array,trump);
		S.getplayers(obj2,now,map.get(str));

			// update the mark while game playing.

		obj2.put("id" , id);
		obj2.put("trick" , "Won hands  : "+ " you : " + trick[id] + "    player-1 : " + trick[(id+1)%4]  + "    player-2 : " + trick[(id+2)%4] + "    player-3 : " + marks[(id+3)%4]);
		obj2.put("round" , "Won Rounds : "+ " you : " + marks[id] + "    player-1 : " + marks[(id+1)%4]  + "    player-2 : " + marks[(id+2)%4] + "    player-3 : " + marks[(id+3)%4]);

		if(id==nextpaly){

			obj2.put("canplay" , true);
			obj2.put("message","you can play now");

			}
		}


		if(Sarray.getroundwinner(trick)!=-1){ // this block choose next player and update score
			d=1;

			if(nexttrickpaly==3)
				nexttrickpaly=0;

			else
				nexttrickpaly++;

			marks[Sarray.getroundwinner(trick)]++;
			nextpaly = nexttrickpaly;
			}


		if(Sarray.youwon(marks)!=-1) { 
		        							// if anyone is won end the game and display the winner
			won = Sarray.youwon(marks);
			obj2.put("showCards" , false);
			obj2.put("showHand" , false);
		}

		if(id==won)
				obj2.put("message","Congratulations you won the match");

		else if(0 <= won && won <= 3)
				obj2.put("message","sorry you are defeated");



		if(won==-1){ // if no winner yet

		if(Sarray.getroundraw(trick)==1){

			d=1;
			if(nexttrickpaly==3)
				nexttrickpaly=0;  					// if there are no winner yet continue the game.get the next player

			else
				nexttrickpaly++;
				nextpaly = nexttrickpaly;
		}



			if(Sarray.checknow(now)==true && gotfirst==1){  //this  is cheking whether all players are play or not.
				gotfirst=0;

			synchronized (object) {
				if(Sarray.checknow(now)==true){  // wait untill all players are update
	        try {
	            object.wait(2000);
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
		 
		  if(Sarray.trickwinner(now,trump,First)==5){
		   												// initially set zeros to marks array.
		  	First =-1;
		  	Sarray.init(now);

		  }

		  else{

		  	nextpaly = Sarray.trickwinner(now,trump,First); // while game play checking the trick winner.
		  	trick[nextpaly]++;
		  	System.out.println(First);
		 	Sarray.init(now);
		  	First = -1;

			}

		  }
		}

		gotfirst= 1; // synchronize method

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
		  		}
			}
			
		}

		return obj2;      // return the last completed jason object.

	}


	public static String addcard(String str,String number,HashMap<String , Integer> map){

		JSONObject obj = new JSONObject() ;obj.put("image", number);
		String s =S.getKeyFromValue(obj);

		if(map.get(str)==nextpaly){ // if the correct player add a card continue else return
		
		// checking the array if has same cards.if wrong card has been played alert.
		if(First!=-1 && Integer.parseInt(s)!=Sarray.getcheck(First,Integer.parseInt(s)) && Sarray.cardisthere(array[map.get(str)],First)==1)
			return("please enter a correct card");

		else{ // if all are correct reemove the card from temprary hash map and update to now array.
		
			if(First==-1)
				First = Integer.parseInt(s);

			if(nexttrickpaly==-1)
				nexttrickpaly = map.get(str);

			Sarray.arrayreplace(array,map.get(str),Integer.parseInt(s));
			now[map.get(str)]=Integer.parseInt(s);
			
			if(nextpaly == 3)
				nextpaly=0; // update the next trick player.

			else 
				nextpaly++;

			return( "1"); // this means all are correctly done

			}
		}

		else return("you can't play now"); // if wrong player plays alert this.
	}
}