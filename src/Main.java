public class Main {
    static MyArray<String> arr = new MyArray();
    public static void main(String[] args) {
        arr.add("Hej");
        arr.add("Med");
        arr.add("Dig");
        arr.rotateList(-1);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
