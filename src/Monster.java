import java.util.Random;
import java.util.Scanner;

public class Monster {


    private String image = "\uD83D\uDC6E\u200D♂\uFE0F";
    private
    int x, y;

    Monster(int sizeBoard)  {
        Random random = new Random();

        x = 1 + random.nextInt(sizeBoard);
        y = 1 + random.nextInt(sizeBoard - 1);

    }
    public int getX()   {
        return x;
    }

    public int getY()   {
        return y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image)  {
        this.image = image;
    }

    public boolean conflictPerson(int personX, int personY) {
        return personX == x && personY == y;
    }

    public boolean taskMonster(int difficulty) {
        if (difficulty == 1)    {
            Random random = new Random();
            int a = random.nextInt(300);
            int b = random.nextInt(300);
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + "+ " + b + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();

            if (trueAnswer == ans) {
                System.out.println("Круто! Ты победил мента");
                System.out.println("Клёво ты его там отработал");
                return true;
            }
        }   else {
            System.out.println("Ты проиграл эту дуэль, нищ");
            return false;



        }
        return false;
    }




























}

