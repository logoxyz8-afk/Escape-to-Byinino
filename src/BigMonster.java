import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {
    BigMonster(int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83D\uDD75\uFE0F\u200D♂\uFE0F");
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            return taskMonster();

        } else {
            System.out.println("Выиграй дуэль:");

            Random random = new Random();
            int x = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int y = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int z = random.nextInt(100 * (difficultGame - 1), 100 * difficultGame);

            int trueAnswer = x * y - z;
            System.out.println("Реши пример: " + x +" * " + y + " - " + z + " = ?");

            Scanner sc = new Scanner(System.in);
            int answer = sc.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Круто! Ты победил спецназовца");
                System.out.println("Клёво ты его там отработал");
                return true;
            } else {
                System.out.println("Ты проиграл эту дуэль, нищ");
                return false;

            }
        }
    }

    public boolean taskMonster() {
        return super.taskMonster(1);
    }
}
