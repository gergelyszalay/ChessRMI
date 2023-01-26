package chessrmi;

public class ChessStates {
    private final String DEFAULTSTATE = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w";
    public static ChessStates instance;

    public static synchronized ChessStates getInstance(){
        if(instance==null){
            instance = new ChessStates();
        }
        return instance;
    }
    private String[][] boardArray;
    private String currentState= null;
    public String[][] fenToArray(String fen){
        String[][] board = new String[8][8]; ;
        String[] row = fen.split("/");
        for(int i=0; i<8; i++){
            int charPos=0;
            for(int j=0; j<row[i].length() && j<8; j++){
                char c = row[i].charAt(j);
                if(Character.isDigit(c)){
                    int numberEmpty=Character.getNumericValue(c);
                    while(numberEmpty>0){
                        board[i][charPos]=null;
                        charPos++;
                        numberEmpty--;
                    }
                }else{
                    board[i][charPos]=Character.toString(c);
                    charPos++;
                }
            }
        }
        return board;
    }

    public String[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(String[][] boardArray) {
        this.boardArray = boardArray;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
    public ChessStates(){
        this.currentState=DEFAULTSTATE;
        this.boardArray = fenToArray(currentState);
    }


}
