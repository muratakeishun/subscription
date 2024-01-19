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

    public static int nextId;

    public static ArrayList<SubscriptionData> list;

    private static String filePath = "Resources/subscriptionList.csv";

    /*
     *CSV読み込み
     */
    public static void readFile() {
        list = new ArrayList<>(); // 初期化
        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

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
                        list.add(subscriptionData);
                    } catch (NumberFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     *CSV書き込み, ソート
     */
    public static void writeFile() {
        Comparator<SubscriptionData> subscriptionDataComparator = new Comparator<SubscriptionData>() {
            @Override
            public int compare(SubscriptionData o1, SubscriptionData o2) {
                return Integer.compare(o1.SubscriptionId, o2.SubscriptionId);
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
     *listに追加するメソッド
     */
    public static void addList(SubscriptionData newData) {
        if (list == null) {
            list = new ArrayList<>();
        }
        nextId = calculateNextId();

        //穴埋め処理を実行
        fillGap();
        newData.SubscriptionId = nextId++;
        list.add(newData);
    }

    /*
     *listをgetするメソッド
     */
    public ArrayList<SubscriptionData> getSubscriptionList() {
        return list;
    }

    /*
     *ID検索
     */
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

    /*
     *削除と上書き
     */
    public static void deleteSubscriptionList(int i) {

        // 条件に合致する要素を削除
        list.removeIf(item -> item.getSubscriptionId() == i);

        System.out.println("削除しました。");
        writeFile();
        Indication.summaryOutput();
    }

    /*
     *リストから削除されたIDに対する穴を埋める処理
     */
    public static void fillGap() {
        List<Integer> usedIds = new ArrayList<>();
        for (SubscriptionData data : list) {
            usedIds.add(data.SubscriptionId);
        }
        for (int i = 1; i < nextId; i++) {
            if (!usedIds.contains(i)) {
                nextId = i;
                return;
            }
        }
    }

    /*
     *最大値のID判定
     */
    public static int calculateNextId() {
        int maxId = 0;
        for (SubscriptionData data : list) {
            maxId = Math.max(maxId, data.SubscriptionId);
        }
        return maxId + 1;
    }
}
