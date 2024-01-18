import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubscriptionList {

    public static ArrayList<SubscriptionData> list;

    private static String filePath = "Resources/subscriptionList.csv";

    /*
     *CSV読み込み
     */
    public static void readFile() {
        List<SubscriptionData> tempList = new ArrayList<>(); // 一時的なリストを作成
//        list = new ArrayList<>();
        Path path = Paths.get(filePath);

        //csvファイルの読み込み
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length == 4) {
                try {
                    int subscriptionId = Integer.parseInt(data[0]);
                    String subscriptionName = data[1];
                    int subscriptionType = Integer.parseInt(data[2]);
                    int subscriptionPrice = Integer.parseInt(data[3]);

                    //subscriptionDataに入れる
                    SubscriptionData subscriptionData = new SubscriptionData(subscriptionId, subscriptionName, subscriptionType, subscriptionPrice);
                    tempList.add(subscriptionData);
//                    addList(subscriptionData);
                } catch (NumberFormatException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        // ファイル読み込みが終わったら tempList の内容を list に追加
        list = new ArrayList<>(tempList);
    }

    /*
     *CSV書き込み, ソート
     */
    public static void writeFile() {
        Comparator<SubscriptionData> subscriptionDataComparator = new Comparator<SubscriptionData>() {
            @Override
            public int compare(SubscriptionData o1, SubscriptionData o2) {
                return Integer.valueOf(o1.SubscriptionId).compareTo(Integer.valueOf(o2.SubscriptionId));
            }
        };
        Collections.sort(list, subscriptionDataComparator);
        String csvData = convertToCSV();
        //FileWriterインスタンス生成
        try {
            FileWriter csvWriter = new FileWriter(filePath);
            csvWriter.append(csvData);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     *csv形式の文字列に変換する
     */
    public static String convertToCSV() {
        String csvData = "";
        // 各行をループし、最後の行以外改行をはさむ
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                csvData = csvData + list.get(i).convertToCSV();
            } else {
                csvData = csvData + list.get(i).convertToCSV() + "\n";
            }
        }
        return csvData;
    }

    /*
     *
     */
    public static void addList(SubscriptionData newData) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(newData);
    }

    public ArrayList<SubscriptionData> getSubscriptionList() {
        return list;
    }

    //ID検索
    public static SubscriptionData selectSubscriptionList(int nextAction) {

//         条件に合致する SubscriptionData オブジェクトを抽出
        SubscriptionData foundItem = null;
        for (SubscriptionData item : list) {
            // IDが入力された内容の要素を探す
            if (item.SubscriptionId == nextAction) {
                foundItem = item;
                break; // 見つかったらループを抜ける
            }
        }
        return foundItem;
    }

    public static void deleteSubscriptionList(int i) {

        // 条件に合致する要素を削除
        list.removeIf(item -> item.getSubscriptionId() == i);

        writeFile();
        System.out.println("削除しました。");
        writeFile();
        Indication.summaryOutput();
    }
}
