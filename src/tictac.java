import java.util.Scanner;




 class tictac {
	Scanner input=new Scanner(System.in);
	public int userinput=1;
	int[] checkRepeat =new int[10];
	public char player;
	boolean booleanRepCheck=false;
	int m=0;
	public boolean check=true;
	char[][] board = {{' ','|',' ' ,'|',' ' },{'-','+','-','+','-'},{' ','|',' ','|',' ' },{'-','+','-','+','-'},{' ','|',' ','|',' ' }};;


	tictac(){
	}



	void Board(){
    	for(int i=0;i<5;i++){
        	for(int j=0;j<5;j++){
            	System.out.print(board[i][j]);
        	}
        	System.out.print("\n");
    	}
	}

	public void userInput(){m++;

    	
    	do{


    		System.out.print("Please give a no to place your turn:");
        	userinput=input.nextInt();
        	for (int i=0;i<=m;i++){

            	if(userinput==checkRepeat[i]) {
                	booleanRepCheck=true;
                	System.out.print("This space is already taken. ");
                	break;


            	}
         	   else  booleanRepCheck=false;
        	}



    	} while (booleanRepCheck==true);

    	checkRepeat[m]=userinput;

    	if(player=='X')
        	player='O';
    	else
        	player='X';


    	switch (userinput) {
        	case 1:
            	board[0][0] = player;
            	break;
        	case 2:
            	board[0][2] = player;
            	break;
        	case 3:
            	board[0][4] = player;
            	break;
        	case 4:
 	           board[2][0] = player;
            	break;
        	case 5:
            	board[2][2] = player;
            	break;
        	case 6:
            	board[2][4] = player;
            	break;
        	case 7:
            	board[4][0] = player;
            	break;
        	case 8:
            	board[4][2] = player;
            	break;
        	case 9:
            	board[4][4] = player;
            	break;

    	}

	}

	public boolean rules(){
        checkColumns();
    	checkRows();
    	checkDiagonals();
    	return winner();
	}


	public boolean winner() {
        return (checkRows() || checkColumns() || checkDiagonals());
	}


	public boolean checkRows() {
    	for (int i = 0; (i < 5); i++) {
        	if (checkRowCol(board[i][0], board[i][2], board[i][4]) == true &&(i%2==0) ) {
            	return true;
        	}
    	}
    	return false;
	}
	private boolean checkDiagonals()
	{
    	return ((checkRowCol(board[0][0], board[2][2], board[4][4]) == true) || (checkRowCol(board[0][4], board[2][2], board[4][0]) == true));
	}

	private boolean checkColumns()
	{
    	for (int i = 0; (i < 5); i++)
    	{
        	if (checkRowCol(board[0][i], board[2][i], board[4][i]) == true &&(i%2==0))
        	{
            	return true;
        	}
    	}
    	return false;
	}

	boolean checkRowCol(char c1, char c2, char c3)
	{
    	return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
	}
	
	
	public void playTicTac(){
		int count=0;
    	
    	Board();
    	while(count<9) {
        	userInput();
        	Board();
        	rules();
        	if(winner()){
   	         System.out.println("Winner");
            	break;
        	}
        	count++;
    	}
		
	}
}


