package test.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author liufei
 * @description: 实现LRU算法
 * @date 2020/5/19 10:28
 **/
public class LRUCache<K,V> {
    private int cacheSize;
    private LinkedHashMap<K,V> map;
    private static final float hashFloat = 0.75f;

    public LRUCache(int cacheSize){
        this.cacheSize = cacheSize;
        int initialCapacity = (int)Math.ceil(cacheSize / hashFloat)+1;
        map = new LinkedHashMap<K,V>(initialCapacity,hashFloat,true) {
            private static final long serialVersionUID = 1;
            @Override
            //重写removeEldestEntry方法当缓存满的时候触发删除一段时间内访问最少的数据
            public boolean removeEldestEntry(Map.Entry eldest){
                return size() > LRUCache.this.cacheSize;
            }
        };
    }
    public void put(K key ,V val){
        map.put(key,val);
    }

    public V get(K key){
        return map.get(key);
    }

    public void clear(){
        map.clear();
    }

    public int size(){
        return map.size();
    }

    public void print(){
        Iterator<Entry<K,V>> iterator = map.entrySet().iterator();
        System.out.println("输出缓存里的所有数据：");
        while (iterator.hasNext()){
            Entry<K,V> entry = iterator.next();
            System.out.println("key="+entry.getKey()+",value ="+entry.getValue());
        }
    }

    public static void main(String[]args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.print();
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.print();
//        LRUCache<Integer, Integer> lru = new LRUCache<>(2);
//
//        for (int i = 0; i < 2; i++) {
//            lru.put(i, i);
//        }
//
//       lru.get(0);
//
//        lru.put(5, 5);
//
//        lru.print();

    }
}
