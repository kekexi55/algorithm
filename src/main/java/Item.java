/***
 *
 * @author zhengchunguang
 * @date 2019-05-30 15:05
 */
public class Item implements Comparable<Item>{

    private Integer weight;

    public Item(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Item o) {
        return this.weight>o.weight? 1:-1;
    }
}
