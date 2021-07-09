package pers.zpw.bloomfilter;

/**
 * BloomFilter是二进制向量的数据结构, 它具有很好的空间和时间效率,用来检测一个元素是不是集合的一个成员
 * 如果检测的结果为是,则该元素不一定在集合中;但如果检测的结果为否,该元素一定不在集合中
 *
 * 因此 Bloom Filter 具有100%的召回率。这样每个检测的请求返回有
 * "可能在集合内" "绝对不在集合内" 两种情况
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2021-07-01 10:03
 */
public interface BloomFilter {

    /**
     * @param str 字符串
     * @return 判断一个字符串是否在bitMap中
     */
    boolean contains(String str);

    /**
     * 在boolean filter 中的bitMap中增加一个字符串
     * @param str 字符串
     * @return 是否加入成功, 如果存在返回true 不存在 返回 false
     */
    boolean add(String str);
}
