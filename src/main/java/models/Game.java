package models;
import  java.util.*;
public class Game {
    Deque<Player> playerList;
    Board gameboard;
    Scanner sc = new Scanner(System.in);
    public Game(){
        InitializeGame();
    }
    public void InitializeGame(){

        System.out.println("Please enter the size of board");
        int size = sc.nextInt();
        playerList= new LinkedList<>();
        pieceX x = new pieceX();
        Player p1 = new Player("Player1",x);
        pieceY y = new pieceY();
        Player p2 = new Player("Player2",y);
        playerList.add(p1);playerList.add(p2);
        gameboard = new Board(size);

    }

    public String StartGame(){
        boolean noWinner = true;
//        String name = ""
        while(noWinner){
            Player playerturn = playerList.removeFirst();
//            gameboard.printBoard();
            if(!gameboard.freeSpace()){
               break;
            }
            System.out.print(playerturn.name + " " + " Please enter the position like 1,1 or 3,2 " );
//            System.out.println(gameboard.board.length);
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] arr= input.split(",");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            if(x>=gameboard.getSize() || y>=gameboard.getSize())
            {   playerList.addFirst(playerturn);
                System.out.println("Please enter correct coordinates");
                continue;
            }
            gameboard.board[x][y] = playerturn.p;
            gameboard.printBoard();
            if(winner(gameboard.getSize(),x,y,playerturn))
            {
                System.out.println(playerturn.name + " is the Winner ");
                noWinner = false;
                return playerturn.name;
            }
            playerList.add(playerturn);

        }
        return "tie";
    }

    public boolean winner(int size, int row, int col, Player playerturn) {
        boolean ans = true;
        for(int i=0;i<size;i++){
            if(gameboard.board[row][i]==null || gameboard.board[row][i]!=playerturn.p)
            {ans = false;break;}
        }
        if(ans==true)return true;
        ans = true;
        for(int i=0;i<size;i++){
            if(gameboard.board[i][col]==null || gameboard.board[i][col]!=playerturn.p)
            {ans = false;break;}
        }
        if(ans==true)return true;
        ans = true;
        for(int i=0;i<size;i++){
            if(gameboard.board[i][i]==null ||gameboard.board[i][i]!=playerturn.p)
            {ans = false;break;}
        }
        if(ans==true)return true;
        ans = true;
        for(int i=size-1;i>=0;i--) {
            if (gameboard.board[i][size-i-1]==null ||gameboard.board[i][size - i - 1] != playerturn.p) {
                ans = false;
                break;
            }
        }

//        System.out.println(ans);
        return ans;
    }

}
