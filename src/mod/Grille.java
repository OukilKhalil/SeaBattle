/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

/**
 *
 * @author badr
 */
public class Grille {
    
    private static Case_Grille grille[][] = new Case_Grille[10][10];

    public Grille() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new Case_Grille();
            }
        }
    }
    
    public static void intialisation(){
        Navire nav[] = new Navire[5];
        nav[0] = porteAvions();
        nav[1] = sousMarin();
        nav[2] = cuirasses("H",3,4);
        nav[3] = cuirasses("V",1,4);
        nav[4] = zodiac();
        
        
        
        for (int i = 0; i < 5; i++) {
            int  x = nav[i].getCoordonneeX()-1;
            int  y = nav[i].getCoordonneeY()-1;
            if(nav[i].getPosition().equals("V")){
                for (int j = 0; j < nav[i].getTaille(); j++) {
                    grille[x][y+j].setEtat("plein");
                }
            }
            else{
                for (int j = 0; j < nav[i].getTaille(); j++) {
                    grille[x+j][y].setEtat("plein");
                }
            }
        }
        
        for (int i = 9; i >= 0; i--) {
            for (int j = 9; j >= 0; j--) {
                if(grille[j][i].getEtat().equals("Vide")){
                    System.out.print("X  ");
                }
                else{
                    System.out.print("O  ");
                }
            }
            System.out.println();
        }
    }
    
    private static PorteAvions porteAvions(){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Position de la porte-avions :");
        String pos = sc.nextLine();
        System.out.println("X de la porte-avions :");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("y de la porte-avions :");
        int y = sc.nextInt();*/
        return new PorteAvions(2, 3, "H");
    }
    
    private static SousMarin sousMarin(){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Position de la Sous-Marin :");
        String pos = sc.nextLine();
        System.out.println("X de la Sous-Marin :");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("y de la Sous-Marin :");
        int y = sc.nextInt();*/
        return new SousMarin(3, 4, "V");
    }
    
    private static Cuirasses cuirasses(String pos, int x, int y){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Position de la Cuirasses"+nbr+" :");
        String pos = sc.nextLine();
        System.out.println("X de la Cuirasses"+nbr+" :");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("y de la Cuirasses"+nbr+" :");
        int y = sc.nextInt();*/
        return new Cuirasses(x, y, pos);
    }
    
    private static Zodiac zodiac(){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Position de la Zodiac :");
        String pos = sc.nextLine();
        System.out.println("X de la Zodiac :");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("y de la Zodiac :");
        int y = sc.nextInt();*/
        return new Zodiac(6, 6, "V");
    }
}
