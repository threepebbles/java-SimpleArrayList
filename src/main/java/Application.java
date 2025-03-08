public class Application {
    public static void main(String[] args) {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.remove(3);
    }
}
