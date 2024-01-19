import java.util.HashMap;

//SubscriptionDataクラス
//クラスのインスタンスを配列に格納
public class SubscriptionData {


    public int SubscriptionId;

    public String SubscriptionName;

    public int SubscriptionType;

    public int SubscriptionPrice;

    //コンストラクタ
    SubscriptionData(int id, String name, int type, int price) {
        this.SubscriptionId = id;
        this.SubscriptionName = name;
        this.SubscriptionType = type;
        this.SubscriptionPrice = price;
    }

    public SubscriptionData(String name, int type, int price) {
        this.SubscriptionName = name;
        this.SubscriptionType = type;
        this.SubscriptionPrice = price;
    }

    //        情報を出力するメソッド
    public String getRow() {

        HashMap<Integer, String> subscriptionType = new HashMap<>();

        if (SubscriptionType == 1) {
            subscriptionType.put(SubscriptionType, "年");
        } else if (SubscriptionType == 2) {
            subscriptionType.put(SubscriptionType, "月");
        }
        return "|" + SubscriptionId + "|" + SubscriptionName + "|" + subscriptionType.get(SubscriptionType) + "|" + SubscriptionPrice;
    }

    //        月の合計計算メソッド
    public int getMonthlyPrice() {

        int monthlyPrice;

        if (SubscriptionType == 1) {
//                        年を月に変換
            monthlyPrice = SubscriptionPrice / 12;
        } else {
            monthlyPrice = SubscriptionPrice;
        }
        return monthlyPrice;
    }

    //      年の合計計算メソッド
    public int getYearlyPrice() {

        int yearlyPrice;
//      タイプ月を年に変換
        if (SubscriptionType == 2) {
            yearlyPrice = SubscriptionPrice * 12;
        } else {
            yearlyPrice = SubscriptionPrice;
        }
        return yearlyPrice;
    }

//    public static void countString(String str) {
//        //戻り値
//        int ret = 0;
//
//        //全角半角判定
//        char[] c = str.toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            if (String.valueOf(c[i]).getBytes().length <= 1) {
//                ret += 1; //半角文字なら＋１
//            } else {
//                ret += 2; //全角文字なら＋２
//            }
//        }
//        System.out.println(ret);
//    }

    // サブスクIDを取得するメソッド
    public int getSubscriptionId() {
        return SubscriptionId;
    }

    public String convertToCSV() {
        return SubscriptionId + "," + SubscriptionName + "," + SubscriptionType + "," + SubscriptionPrice;
    }
}