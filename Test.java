public class Test {
    void main() {
        int level = 0
        increaseLevel(level);
        System.out.println(level);
    }

    int increaseLevel(int lvl) {
        return lvl++;
    }
}

