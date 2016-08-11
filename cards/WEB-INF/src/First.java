

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
/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 HashMap<String , Integer> map = new HashMap<String , Integer>();  // use to keep sessions
	 
    static int i=0;
    static int id=0;
    static int gotfirst=1;
    static int First = -1;
     static int nextpaly = 0; 

   
    int [][] array = new int[4][13];   // arrat that maps to cards
    int []  now = new int[4];
    int []  trick = new int[4];
    int trump = 1;						// map to trump card
    int d = 1;

     private String mutex = "";
     private String object = "";
   
    public First() {
        super();
 
    }

    		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("yes");

		 HttpSession session = request.getSession(true);

		 
		String str = session.getId();      
		if(map.get(str)==null){
		synchronized (mutex)
    	{    
			map.put(str,i);
			i++;
		}
		}

			id = map.get(str);

	

PrintWriter printwriter = null;
JSONObject obj2 = new JSONObject();


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

//S.printGrid(array);
for(i=0;i<4;i++){
	System.out.println(now[i]);
}
  System.out.println("first :" + First);



obj2=S.getdeal(obj2,map.get(str),array,trump);
S.getplayers(obj2,now,map.get(str));

obj2.put("id" , id);

if(id==nextpaly){
obj2.put("canplay" , true);
obj2.put("message","you can play now");


		}
}

		response.setContentType("text/event-stream ; charset=UTF-8"); 
		printwriter  = response.getWriter();
		printwriter.println("data: " + obj2.toString() + "\n\n");
		System.out.println(obj2);
		response.flushBuffer();

		if(Sarray.checknow(now)==true && gotfirst==1){
			gotfirst=0;

		synchronized (object) {
			if(Sarray.checknow(now)==true){
        try {
            object.wait(2500);
        } catch (Throwable e) {
            e.printStackTrace();
        }
	  System.out.println("fulllllllllllllllllllllllllllllllll");
	  if(S.trickwinner(now,trump,First)==5){
	  	First =-1;
	  }
	  else{
	  nextpaly = S.trickwinner(now,trump,First);
	  trick[nextpaly]=trick[nextpaly]++;
	  System.out.println(First);
	  Sarray.init(now);
	  First = -1;
		}
	  }
	}
	gotfirst= 1;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
	  		}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	

		HttpSession session = request.getSession(true);
		String str = session.getId();    
		response.setContentType("text/plain");

		String number = request.getParameter("number");


		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject() ;obj.put("image", number);
		String s =S.getKeyFromValue(obj);

		if(map.get(str)==nextpaly){
		
		if(First!=-1 && Integer.parseInt(s)!=Sarray.getcheck(First,Integer.parseInt(s)) && Sarray.cardisthere(array[map.get(str)],First)==1)
				out.println("please enter a correct card");

		else{
		

		if(First==-1 && Sarray.cardisthere(array[map.get(str)],First)==1)
			First = Integer.parseInt(s);

		Sarray.arrayreplace(array,map.get(str),Integer.parseInt(s));
		now[map.get(str)]=Integer.parseInt(s);
		System.out.println(map.get(str));
		if(nextpaly == 3)nextpaly=0;
		else nextpaly++;
		out.println( "1");
			}
		}

		else out.println("you can't play now");
		System.out.println( "You added no : " + number + " to the name : " );
	}



}