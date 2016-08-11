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
    static int nexttrickpaly = -1; 
    private static String lock = "";
   
    public First() {
        super();
 	}
   		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String str = session.getId(); 

		if(map.get(str)==null){    // add to players to a map untill 4 players connected.give them a id.
		synchronized (lock){    
			map.put(str,i);
			i++;
			}
		}

			id = map.get(str);

		PrintWriter printwriter = null;
		JSONObject obj2 = Gamelogic.getobject(id,str,i,map);  // send id to the game logic class and update(json object)  obj2 according to request.(sender) 

		response.setContentType("text/event-stream ; charset=UTF-8");  // this is servaer event listners response type.
		printwriter  = response.getWriter();

		printwriter.println("data: " + obj2.toString() + "\n\n");  // send the jason object to request sender
		response.flushBuffer();	

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true); // find the senders identity by session id.
		String str = session.getId();   

		response.setContentType("text/plain");
		String number = request.getParameter("number"); // get the players played card

		PrintWriter out = response.getWriter();
		out.println(Gamelogic.addcard(str,number,map)); // update the maps according to player and playing card.
		
	}
}
