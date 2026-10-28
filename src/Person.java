import java.util.Random;

public class Person {
    int x, y;
    String image = "\uD83E\uDD77";
    int live = 5;

    Person(int sizeBoard) {
        Random random = new Random();
        x = 1 + random.nextInt(sizeBoard);
        y = 10 ;
    }

    Person(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Person() {
        this(1, 1);
    }

    public int getX()   {
        return x;
    }

    public int getY()   {
        return y;
    }
    public int getLive()   {
        return live;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image)  {
        this.image = image;
    }








    public boolean isMoveCorrect(int x, int y) {
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }

    void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }


    public void downLive() {
        if (live <= 0) {
            live = 0;
        } else {
            live--;
        }
    }
}
