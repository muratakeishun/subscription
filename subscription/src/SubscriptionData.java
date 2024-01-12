import java.util.HashMap;

//SubscriptionDataクラス
//クラスのインスタンスを配列に格納
public class SubscriptionData {
    int sbsc_id;

    String sbsc_name;

    int sbsc_type;

    int sbsc_price;

    //コンストラクタ
    SubscriptionData(int id, String name, int type, int price) {
        this.sbsc_id = id;
        this.sbsc_name = name;
        this.sbsc_type = type;
        this.sbsc_price = price;
    }

    //        情報を出力するメソッド
    public String getRow() {

        HashMap<Integer, String> subscriptionType = new HashMap<>();

        if (sbsc_type == 1) {
            subscriptionType.put(sbsc_type, "年");
        } else if (sbsc_type == 2) {
            subscriptionType.put(sbsc_type, "月");
        }
        return "|" + sbsc_id + "|" + sbsc_name + "|" + subscriptionType.get(sbsc_type) + "|" + sbsc_price;
    }

    //        月の合計計算メソッド
    public int getMonthlyPrice() {

        int monthlyPrice;

        if (sbsc_type == 1) {
//                        年を月に変換
            monthlyPrice = sbsc_price / 12;
        } else {
            monthlyPrice = sbsc_price;
        }
        return monthlyPrice;
    }

    //      年の合計計算メソッド
    public int getYearlyPrice() {

        int yearlyPrice;
//      タイプ月を年に変換
        if (sbsc_type == 2) {
            yearlyPrice = sbsc_price * 12;
        } else {
            yearlyPrice = sbsc_price;
        }
        return yearlyPrice;
    }

    public static void countString(String str){
        //戻り値
        int ret = 0;

        //全角半角判定
        char[] c = str.toCharArray();
        for(int i=0;i<c.length;i++) {
            if(String.valueOf(c[i]).getBytes().length <= 1){
                ret += 1; //半角文字なら＋１
            }else{
                ret += 2; //全角文字なら＋２
            }
        }

        System.out.println(ret);
    }
}