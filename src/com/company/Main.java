package com.company;
import java.util.Random;
import java.util.Scanner;
public class Main {
   static final int SIZE = 10;
static final char TOC_O ='O';
static final char TOC_x ='X';
static final char TOC_empty ='.';
static char[][] kort;
static Scanner sc = new Scanner(System.in);
static Random random = new Random();

   public static void main(String[] args) {
      init();
      cellValid(9,9);
      print();
      full();
      check();
      int dcWin;
      while(true) {
         homonyTurn();
         print();
         if (check(TOC_x,dcWin)){
            System.out.println("Победа игрока");
            break;
         }
         if(full()){
            System.out.println("Ничья");
            break;
         }

         intellectTurn();
         print();
         if (check(TOC_O,dcWin)) {
            System.out.println("Победа компьютера");
            break;
         }
         if(full()){
            System.out.println("Ничья");
            break;
         }
      }


   }
   public static void init() {
      kort = new char[SIZE][SIZE];
      for (int i=0;i<SIZE; i++){
         for (int j = 0; j< SIZE; j++){
            kort[i][j] = TOC_empty;
         }
      }
   }
   public static void print(){
      for(int i= 0; i<SIZE; i++){
         System.out.print(i + 1 + " ");
      }

      for(int i=0; i<SIZE; i++){
         System.out.print(i+1+" ");
         for (int j = 0; j<SIZE; j++){
            System.out.printf("%c" , kort[i][j]);
         }
         System.out.println();
      }

   }
   public static void homonyTurn(){
int x;
int y;
do{
   System.out.println("input y x");
   y=sc.nextInt() - 1;
   x=sc.nextInt() - 1;
}while (!cellValid(y,x));
kort[y][x] = TOC_x;
   }
   public static void intellectTurn() {
      int x;
      int y;
      do{
         y = random.nextInt(SIZE);
         x = random.nextInt(SIZE);
      }while (!cellValid(y,x));
         kort[y][x] =TOC_O;
   }
   public static boolean cellValid(int y,int x){
if(x < 0||y < 0 || x >=SIZE||y>=SIZE){
   return false;
}
return kort[y][x] == TOC_empty;
   }
   public static boolean full(){
for (int i = 0; i < SIZE; i++){
   for (int j = 0; j < SIZE; j++){
      if (kort[i][j] == TOC_empty){
         return false;
      }
   }
}
return true;
   }
   static boolean check(int ry, int rx, int ny, int nx, char dc, int dcWin){
      if (rx + nx * (dcWin - 1) > SIZE - 1|| ry + ny *(dcWin - 1) > SIZE - 1 || ry + ny  * (dcWin - 1) < 0){
         return false;
      }
      for (int i; i < dcWin; i++){
         if(kort[ry + i * ny][rx + i * nx] != dc){
            return false;
         }
      }
      return true;
   }
}
