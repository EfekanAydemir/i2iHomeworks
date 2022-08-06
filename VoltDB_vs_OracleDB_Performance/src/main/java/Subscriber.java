public class Subscriber {
    private String packageName = "Her yöne 5000 dk";

    public String getPackageName() {
        return packageName;
    }

    public String randomTelNo() {
        String[] array = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String randomtelNo = "05";
        boolean isFull = false;
        while (!isFull) {
            int random = (int) Math.ceil(Math.random() * 9);
            randomtelNo = randomtelNo + array[random];
            if (randomtelNo.length() == 11) break;
        }
        return randomtelNo;
    }
    public int randomUsage(){
        int randomUsage = (int)Math.ceil(Math.random()*4999);
        return randomUsage;
    }

}
