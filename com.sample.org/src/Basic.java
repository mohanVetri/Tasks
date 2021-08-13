

public class Basic {
    public String grading (char letter){
        char grade=letter;
        String position="";
        switch (grade) {
            case 'A':
                position= "First class";
                break;
            case 'B':
                position= "Second class";
                break;
            case 'C':
                position="Third class";
                break;
            default:
                System.out.println("Enter valid grade");
                break;
        }
        return position;
    }

	public int sum() {
        int number=0;
        for(int i=1;i<=10;i++){
            number+=i;
        }
        return number;
	}

	public int sumWithBreak(int index) {
        int number=0;
		for(int i=1;i<=10;i++){
            if(i==index)
            break;
            number+=i;
        }
        return number;
	}

	public int sumWithContinue(int index) {
        int number=0;
		for(int i=1;i<=10;i++){
            if(i==index)
            continue;
            number+=i;
        }
        return number;
	}

	public int labelWithBreak(int index) {
		int [][] matrix={{1,2},{3,4}};
        int number=0;
        Row: 
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix[1].length;j++){
                if(i==index)
                    break Row;
                number+=matrix[i][j];
            }
        }
        return number;
	}

	public int labelWithContinue(int index) {
		int [][] matrix={{1,2},{3,4}};
        int number=0;
        Row: 
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix[1].length;j++){
                if(i==index)
                    continue Row;
                number+=matrix[i][j];
            }
        }
        return number;	}
}
