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

    //情報を取ってくるメソッド
    public String getRowFormatted(String format) {
        return String.format(format, SubscriptionId, SubscriptionName, getSubscriptionTypeString(), SubscriptionPrice);
    }

//    }    public String getRow() {
//
//        HashMap<Integer, String> subscriptionType = new HashMap<>();
//
//        if (SubscriptionType == 1) {
//            subscriptionType.put(SubscriptionType, "年");
//        } else if (SubscriptionType == 2) {
//            subscriptionType.put(SubscriptionType, "月");
//        }
//        return "|" + SubscriptionId + "|" + SubscriptionName + "|" + subscriptionType.get(SubscriptionType) + "|" + SubscriptionPrice;
//    }

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

    // サブスクIDを取得するメソッド
    public int getSubscriptionId() {
        return SubscriptionId;
    }

    public String getSubscriptionName() {
        return SubscriptionName;
    }

    public String getSubscriptionTypeString() {
        if (SubscriptionType == 1) {
            return "年";
        } else if (SubscriptionType == 2) {
            return "月";
        } else {
            return "失敗です。削除してください";
        }
    }

    public int getSubscriptionPrice() {
        return SubscriptionPrice;
    }

    public String convertToCSV() {
        return SubscriptionId + "," + SubscriptionName + "," + SubscriptionType + "," + SubscriptionPrice;
    }
}