package bwei.com.jingddab.BeanUtils;

/**
 * Created by huoxuebin on 2018/4/23.
 */

public class CountPriceBean {

    private String priceString;
    private int count;

    public CountPriceBean(String priceString, int count) {
        this.priceString = priceString;
        this.count = count;
    }

    public String getPriceString() {
        return priceString;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
