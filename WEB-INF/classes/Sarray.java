import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays; 





//////////////////////////////////////////////// this class contains all array logics used to game logic //////////////////////



public class Sarray {
  public static void shuffleArray(int[] a) { // used to suffle int elements in a given array.
    int n = a.length;
    Random random = new Random();
    random.nextInt();
    for (int i = 0; i < n; i++) {
      int change = i + random.nextInt(n - i);
      swap(a, i, change);
    }
  }


  private static void swap(int[] a, int i, int change) {
    int helper = a[i];
    a[i] = a[change];
    a[change] = helper;
  }

  public static void sortarray(int[][] a){   // sort a 2d int array.
  for(int i=0;i<4;i++)
   Arrays.sort(a[i]);
  }

  public static void init(int[] a){
    int i=0;
  for (Integer n : a) {
       
      a[i]=100;
        i++;
    }
  }

  public static int youwon(int[] a){
    int i =0;
  for (Integer n : a) {
       
      if(n==3)
        return i;
      i++;
    }
   return -1;
  }


  public static void initmarks(int[] a){
    int i=0;
  for (Integer n : a) {
       
      a[i]=0;
        i++;
    }
  }


  public static int getcheck(int trump,int card){  
    if(trump<14 && card<14)
      return card;

   else if(14<=trump && trump<27 && 14<=card && card<27 )
      return card;

   else if(27<=trump && trump<40 && 27<=card && card<40)
      return card;
    
   else  if(40<=trump && trump<53 && 40<=card && card<53)
      return card;
   else return -1;
 }

  public static int cardisthere(int[] a,int trump){  
   for (Integer n : a) {
    if(trump<14 && n<14)
      return 1;

   else if(14<=trump && trump<27 && 14<=n && n<27 )
      return 1;

   else if(27<=trump && trump<40 && 27<=n && n<40)
      return 1;
    
   else  if(40<=trump && trump<53 && 40<=n && n<53)
      return 1;
 }
  return 0;
 }

 
public static boolean checknow(int[] a){
    int i=0;
  for (Integer n : a) {
       
     if( a[i]!=100);
       else return false;
      i++;
    }
    return true;
  }

public static int getroundwinner(int[] a){

if(getsum(a)==3){
      int max = max(a);
      if(checkduplicate(a,max)==0)
       return (roundwinner(a,max));
      return -1;
    }
    return -1;
}

public static int getroundraw(int[] a){

if(getsum(a)==3){
      int max = max(a);
      if(checkduplicate(a,max)>0)
       return 1;

      return -1;
    }
    return -1;
}



public static int roundwinner(int[] a,int max){
  int i = 0;int j=0;
  for (Integer n : a) {
    if(n==max)
      return j;
     j++;
        
    }
    return -1;
  }

public static int checkduplicate(int[] a,int max){
  int i = 0;int j=0;
  for (Integer n : a) {
    if (max==n)
      i++;
    }
    if(i>1)return 1;
      else return 0;
  }

public static int getsum(int[] a){
  int sum=0;
  for (Integer n : a) {
    sum=sum+n;
    }
    return sum;
  }

public static int max(int[] a){
  int i = 0;
  for (Integer n : a) {
    if (i<n)
      i=n;
    }
    return i;
  }

  public static void arrayreplace(int[][] array,int p,int no){
  int i=0;
  for (Integer number : array[p]) {
        if (number == no) {
           array[p][i]=100;
            break;
        }
        i++;
    }
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

  public static void main(String[] args) {
  
    int []  a= new int[4];
    a[0] = 2;
    a[1] = 5;
    a[2] = 3;
    a[3] = 3;
    System.out.println(getroundwinner(a));
  }

}
