
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;  




////////////////////////// this class used as jason object manage class and helper class to game logic and main servalet///////

public class S {

// these 52 objects are map to intger(convert to string) using hashmap

static HashMap<String , JSONObject> ob = new HashMap<String , JSONObject>(); 

 public static void ini(){


int i=0,j=0,k=0;

    for (i=0; i<4; i++ ) {

      for (j=2; j<14 ; j++) {
        
        JSONObject obj = new JSONObject(); 
        obj.put("image", "cards/" + i + "_" + j + ".png");
        ob.put(Integer.toString(k+j-1),obj);
        
      }

        JSONObject obj = new JSONObject(); 
        obj.put("image", "cards/" + i + "_1.png");
        ob.put(Integer.toString(k+j-1),obj);
        k = k + j-1; 
    } 

}

	public static void deal(int[][] p){  // this method used to shuffle a given array

		int [] array = new int[52];

	  	for (int a = 0; a < array.length; a++) {
    		array[a] =  a+1;
  		}

  		Sarray.shuffleArray(array);
  		int k=0;

  		for(int j=0;j<4;j++){
    	for (int i = 0; i < p[j].length; i++,k++) {
      		p[j][i] = array[k];
    	}
      }
	}


	public static String getKeyFromValue(JSONObject value) {

    for (String o : ob.keySet()) {
      if (ob.get(o).equals(value)) {
        return o;
      }
    }
    return null;
  }


	public static void main(String[] args) {

		int [][] array = new int[4][13];
		deal(array);
		printGrid(array);
  }

public static synchronized JSONObject getdeal(JSONObject obj,int p,int[][] a,int trump){  // using this can get last jason object containing maps cards locations(13 cards).

		JSONArray arr = new JSONArray();
		ini();
		Sarray.sortarray(a);

		for(int i=0 ;i<=12;i++){
		
			if(a[p][i]!=100)
			 arr.add(ob.get(Integer.toString(a[p][i])));
			
		}
		obj.put("cards",arr);
		obj.put("showCards" , true);
		obj.put("showHand" , true);

		if(trump<14){
		  obj.put("trump","cards/diamond.jpg");
		}
		if(14<=trump && trump<27){
		  obj.put("trump","cards/club.jpg");
		}
		if(27<=trump && trump<40){
		  obj.put("trump","cards/Hart.jpg");
		}
		if(40<=trump && trump<53){
		  obj.put("trump","cards/spade.jpg");
		}
		return obj;
	}

 public static int trickwinner(int[] a,int trump,int first){

   int k=0; int i = 5;int j=-1;int trumpcard = 0;

  for (Integer card : a) {

  	if(card == Sarray.getcheck(first,card) && j<card && trumpcard == 0 && card != Sarray.getcheck(trump,card)){
  		i=k;j=card;
  	}

  	else if(card == Sarray.getcheck(trump,card) && trumpcard<card){
  		i=k;trumpcard=card;  
  	}

  	k++;

    }

   return i;

  }



  public static void getplayers(JSONObject obj,int[] a,int i){
 
  if(a[i]!=100)
  	obj.put("mycard",(ob.get(Integer.toString(a[i]))).get("image"));

  if(a[(i+1)%4]!=100)
  	obj.put("card1",ob.get(Integer.toString(a[(i+1)%4])).get("image"));

  if(a[(i+2)%4]!=100)
  	obj.put("card2",ob.get(Integer.toString(a[(i+2)%4])).get("image"));

  if(a[(i+3)%4]!=100)
  	obj.put("card3",ob.get(Integer.toString(a[(i+3)%4])).get("image"));

  }

  public static void printGrid(int[][] a) {   // this method is used to print 2d array(to check)

   for(int i = 0; i < 4; i++)
   {
      for(int j = 0; j < a[i].length; j++)
      {
         System.out.print( a[i][j] + "\t");
      }
      System.out.println();
   }
}


}