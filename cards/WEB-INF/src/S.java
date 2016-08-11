
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;  
import java.util.Arrays; 

public class S {


// 52 crd mapping json object are created because of jaon object can't keep duplicate key values. "image" can't use as key to 2 values.
// these 52 objects are map to intger(convert to string) using hashmap

static HashMap<String , JSONObject> ob = new HashMap<String , JSONObject>(); 

 public static void ini(){
JSONObject obj01 = new JSONObject(); obj01.put("image", "cards/0_1.png"); ob.put("13",obj01);			JSONObject obj11 = new JSONObject(); obj11.put("image", "cards/1_1.png"); ob.put("26",obj11);	
JSONObject obj02 = new JSONObject(); obj02.put("image", "cards/0_2.png"); ob.put("1",obj02);			JSONObject obj12 = new JSONObject(); obj12.put("image", "cards/1_2.png"); ob.put("14",obj12);	
JSONObject obj03 = new JSONObject(); obj03.put("image", "cards/0_3.png"); ob.put("2",obj03);			JSONObject obj13 = new JSONObject(); obj13.put("image", "cards/1_3.png"); ob.put("15",obj13);	
JSONObject obj04 = new JSONObject(); obj04.put("image", "cards/0_4.png"); ob.put("3",obj04);			JSONObject obj14 = new JSONObject(); obj14.put("image", "cards/1_4.png"); ob.put("16",obj14);	
JSONObject obj05 = new JSONObject(); obj05.put("image", "cards/0_5.png"); ob.put("4",obj05);			JSONObject obj15 = new JSONObject(); obj15.put("image", "cards/1_5.png"); ob.put("17",obj15);	
JSONObject obj06 = new JSONObject(); obj06.put("image", "cards/0_6.png"); ob.put("5",obj06);			JSONObject obj16 = new JSONObject(); obj16.put("image", "cards/1_6.png"); ob.put("18",obj16);	
JSONObject obj07 = new JSONObject(); obj07.put("image", "cards/0_7.png"); ob.put("6",obj07);			JSONObject obj17 = new JSONObject(); obj17.put("image", "cards/1_7.png"); ob.put("19",obj17);	
JSONObject obj08 = new JSONObject(); obj08.put("image", "cards/0_8.png"); ob.put("7",obj08);			JSONObject obj18 = new JSONObject(); obj18.put("image", "cards/1_8.png"); ob.put("20",obj18);	
JSONObject obj09 = new JSONObject(); obj09.put("image", "cards/0_9.png"); ob.put("8",obj09);			JSONObject obj19 = new JSONObject(); obj19.put("image", "cards/1_9.png"); ob.put("21",obj19);	
JSONObject obj010 = new JSONObject() ;obj010.put("image", "cards/0_10.png"); ob.put("9",obj010);		JSONObject obj110 = new JSONObject(); obj110.put("image", "cards/1_10.png"); ob.put("22",obj110);	
JSONObject obj011 = new JSONObject() ;obj011.put("image", "cards/0_11.png"); ob.put("10",obj011);		JSONObject obj111 = new JSONObject(); obj111.put("image", "cards/1_11.png"); ob.put("23",obj111);	
JSONObject obj012 = new JSONObject() ;obj012.put("image", "cards/0_12.png"); ob.put("11",obj012);		JSONObject obj112 = new JSONObject(); obj112.put("image", "cards/1_12.png"); ob.put("24",obj112);	
JSONObject obj013 = new JSONObject() ;obj013.put("image", "cards/0_13.png"); ob.put("12",obj013);		JSONObject obj113 = new JSONObject(); obj113.put("image", "cards/1_13.png"); ob.put("25",obj113);	

JSONObject obj21 = new JSONObject(); obj21.put("image", "cards/2_1.png"); ob.put("39",obj21);			JSONObject obj31 = new JSONObject(); obj31.put("image", "cards/3_1.png"); ob.put("52",obj31);	
JSONObject obj22 = new JSONObject(); obj22.put("image", "cards/2_2.png"); ob.put("27",obj22);			JSONObject obj32 = new JSONObject(); obj32.put("image", "cards/3_2.png"); ob.put("40",obj32);	
JSONObject obj23 = new JSONObject(); obj23.put("image", "cards/2_3.png"); ob.put("28",obj23);			JSONObject obj33 = new JSONObject(); obj33.put("image", "cards/3_3.png"); ob.put("41",obj33);	
JSONObject obj24 = new JSONObject(); obj24.put("image", "cards/2_4.png"); ob.put("29",obj24);			JSONObject obj34 = new JSONObject(); obj34.put("image", "cards/3_4.png"); ob.put("42",obj34);	
JSONObject obj25 = new JSONObject(); obj25.put("image", "cards/2_5.png"); ob.put("30",obj25);			JSONObject obj35 = new JSONObject(); obj35.put("image", "cards/3_5.png"); ob.put("43",obj35);	
JSONObject obj26 = new JSONObject(); obj26.put("image", "cards/2_6.png"); ob.put("31",obj26);			JSONObject obj36 = new JSONObject(); obj36.put("image", "cards/3_6.png"); ob.put("44",obj36);	
JSONObject obj27 = new JSONObject(); obj27.put("image", "cards/2_7.png"); ob.put("32",obj27);			JSONObject obj37 = new JSONObject(); obj37.put("image", "cards/3_7.png"); ob.put("45",obj37);	
JSONObject obj28 = new JSONObject(); obj28.put("image", "cards/2_8.png"); ob.put("33",obj28);			JSONObject obj38 = new JSONObject(); obj38.put("image", "cards/3_8.png"); ob.put("46",obj38);	
JSONObject obj29 = new JSONObject(); obj29.put("image", "cards/2_9.png"); ob.put("34",obj29);			JSONObject obj39 = new JSONObject(); obj39.put("image", "cards/3_9.png"); ob.put("47",obj39);	
JSONObject obj210 = new JSONObject() ;obj210.put("image", "cards/2_10.png"); ob.put("35",obj210);		JSONObject obj310 = new JSONObject(); obj310.put("image", "cards/3_10.png"); ob.put("48",obj310);	
JSONObject obj211 = new JSONObject() ;obj211.put("image", "cards/2_11.png"); ob.put("36",obj211);		JSONObject obj311 = new JSONObject(); obj311.put("image", "cards/3_11.png"); ob.put("49",obj311);	
JSONObject obj212 = new JSONObject() ;obj212.put("image", "cards/2_12.png"); ob.put("37",obj212);		JSONObject obj312 = new JSONObject(); obj312.put("image", "cards/3_12.png"); ob.put("50",obj312);	
JSONObject obj213 = new JSONObject() ;obj213.put("image", "cards/2_13.png"); ob.put("38",obj213);		JSONObject obj313 = new JSONObject(); obj313.put("image", "cards/3_13.png"); ob.put("51",obj313);	

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


	public static void sortarray(int[][] a){   // sort a 2d int array.
	for(int i=0;i<4;i++)
	 Arrays.sort(a[i]);
	}


	public static void main(String[] args) {

		int [][] array = new int[4][13];
		deal(array);
		printGrid(array);
  }

public static synchronized JSONObject getdeal(JSONObject obj,int p,int[][] a,int trump){  // using this can get last jason object containing maps cards locations(13 cards).

		JSONArray arr = new JSONArray();
		ini();
		sortarray(a);
		for(int i=0 ;i<=12;i++){
			//System.out.println(i);
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
  	if(card == Sarray.getcheck(first,card) && j<card && trumpcard == 0){
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