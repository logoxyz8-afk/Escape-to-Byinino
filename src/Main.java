import java.util.Random;
import java.util.Scanner;

public class Main {
    void main() {
        String castle = "\uD83C\uDFF0";
        int step = 0;
        int sizeBoard = 10;

        Person person = new Person(sizeBoard);


        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        int castleY = 1;

        String[][] board = new String[sizeBoard][sizeBoard];

        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }

        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        Monster[] monsters = new Monster[countMonster];
        int count = 0;

        while (count < countMonster) {
            Monster monster;

            if (random.nextBoolean()) {
                monster = new Monster(sizeBoard);
            } else {
                monster = new BigMonster(sizeBoard);
            }

            int row = monster.getX() - 1;
            int column = monster.getY() - 1;

            if (board[row][column].equals("  ")) {
                board[row][column] = monster.getImage();
                monsters[count] = monster;
                count++;
            }
        }

        board[castleY - 1][castleX - 1] = castle;


        System.out.println("Привет, ты готов отправится в Бынино!(Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
            case "да":
                System.out.println("Выбери сложность игры (от 1 до 5)");
                int difficulty = scanner.nextInt();
                System.out.println("Выбранная сложность:\t" + difficulty);

                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();

                    outputBoard(board, person.getLive());


                    System.out.println("Введите новые координаты персонажа (ход возможен только по вертикали и горизонтали на одну клетку" +
                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + ")");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.println(x + " " + y);

                    if (person.isMoveCorrect(x, y)) {
                        if (board[y - 1][x - 1].equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            step++;

                            System.out.println("Ход корректный; Новые координаты: " +
                                    person.getX() + ", " + person.getY() + "\nХод номер: " + step);
                        } else if (board[y - 1][x - 1].equals(castle)) {
                            System.out.println("Ты дошел до Бынино живым!");
                            break;
                        } else {
                            for (Monster monster: monsters) {
                                if (monster.conflictPerson(x, y)) {
                                    if (monster.taskMonster(difficulty)) {
                                        board[person.getY() - 1][person.getX() - 1] = "  ";
                                        person.move(x, y);
                                        step++;
                                    } else {
                                        person.downLive();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Некорректный ход");
                    }

                    if (person.getLive() <= 0) {
                        System.out.println("Тебя поймала полиция, походу до Бынино ты не доберешься");
                        break;
                    }
                }
                break;

            case "нет":
                System.out.println("Ну и пока");
                break;

            default:
                System.out.println("Слушай, теперь другой вопрос, ты тупой?");
        }
    }

    static void outputBoard(String[][] board, int live) {
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";

        for (String[] row : board) {
            System.out.println(wall);

            for (String cell : row) {
                System.out.print(leftBlock);
                System.out.print(cell);
            }

            System.out.println(rightBlock);
        }

        System.out.println(wall);

        System.out.println("Количество жизней:\t" + live);

    }
}
