package Model;

public class Board {
    PlayingPiece[][] playingPieces;
    int n;
    public Board(int size) {
        playingPieces = new PlayingPiece[size][size];
        this.n=size;
    }

    public boolean addPiece(int row, int col, Player player){
        playingPieces[row][col] = player.playingPiece;
        return true;
    }

    public boolean isValidEntry(int row, int col){
        if(row<0 || col<0 || row >=n || col >=n || playingPieces[row][col]!=null)
            return false;
        return true;
    }

    public boolean isFreeSpaceLeft(){
        boolean isSpaceLeft = false;
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(playingPieces[i][j] == null)
                    isSpaceLeft = true;
            }
        }

        return isSpaceLeft;
    }

    public boolean isWinner(int row, int col, PIECETYPE piecetype){
        boolean cr = true, cc= true, cd= true, crd = true;
        System.out.println(row+" "+col+" "+piecetype);
        for(int i=0;i<n;i++){
            if(playingPieces[row][i]==null || !playingPieces[row][i].piecetype.equals(piecetype))
                cr=false;
            if(playingPieces[i][col]==null || !playingPieces[i][col].piecetype.equals(piecetype))
                cc=false;
            if(playingPieces[i][i]==null || !playingPieces[i][i].piecetype.equals(piecetype))
                cd=false;
            if(playingPieces[i][n-i-1]==null || !playingPieces[i][n-i-1].piecetype.equals(piecetype))
                crd=false;
        }
        System.out.println(cr+" "+cc+" "+cd+" "+crd);
        return(cr||cc||cd||crd);
    }

    public void printBoard(){
        for(int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                if(playingPieces[i][j] == null)
                    System.out.print(" "+" |");
                else
                    System.out.print(playingPieces[i][j].piecetype+" |");
            }
            System.out.println();
            System.out.println("____________");
        }
    }
}
