//SubscriptionDataクラス
//クラスのインスタンスを配列に格納
public class SubscriptionData {
        int sbsc_id ;

        String sbsc_name ;

        int sbsc_type ;

        int sbsc_price ;

//コンストラクタ
        SubscriptionData(int id, String name, int type, int price){
                this.sbsc_id = id;
                this.sbsc_name = name;
                this.sbsc_type = type;
                this.sbsc_price = price;
        }
//        情報を出力するメソッド
        public String getRow(){
                return "|"+sbsc_id+"|"+sbsc_name+"|"+sbsc_type+"|"+sbsc_price;
        }

//        月の合計計算メソッド
        public int getMonthlyPrice(){

                int monthlyPrice = 0;

                if (sbsc_type == 1){
//                        年を月に変換
                        monthlyPrice = sbsc_price / 12;
                }else {
                        monthlyPrice = sbsc_price;
                }
                return  monthlyPrice;
        }

//      年の合計計算メソッド
        public int getYearlyPrice(){

                int yearlyPrice =0;
//      タイプ月を年に変換
                if (sbsc_type == 2){
                        yearlyPrice = sbsc_price * 12;
                }else {
                        yearlyPrice = sbsc_price;
                }
        return yearlyPrice;
        }
}