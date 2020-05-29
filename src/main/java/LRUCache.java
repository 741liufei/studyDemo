import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liufei
 * @description:
 * @date 2020/5/26 14:51
 * 设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 )
 **/
public class LRUCache {
        private int cacheSize;
        private LinkedHashMap<Integer,Integer> map;
        private static final float hashFloat=0.75f;

        public LRUCache(int cacheSize){
            this.cacheSize = cacheSize;
            //linkedhashmap 达到0.75的时候会扩容
            int capacity = (int)Math.ceil(cacheSize / hashFloat)+1;
            //重写removeEldestEntry 的返回条件删除最近最少的数据
            map = new LinkedHashMap<Integer,Integer>(cacheSize,hashFloat,true){
                @Override
                public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                    return size() >LRUCache.this.cacheSize;
                }
            };

        }

        public int size(){
            return map.size();
        }
        public int get(int key){
            return map.get(key)==null?-1:map.get(key);
        }

        public void put(int key,int value){
            map.put(key,value);
        }

        public static void main(String[]args){
            LRUCache cache = new LRUCache(2);
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1));       // 返回  1
            cache.put(3, 3);    // 该操作会使得关键字 2 作废
            System.out.println(cache.get(2));       // 返回 -1 (未找到)
            cache.put(4, 4);    // 该操作会使得关键字 1 作废
            System.out.println(cache.get(1));       // 返回 -1 (未找到)
            System.out.println(cache.get(3));       // 返回  3
            System.out.println(cache.get(4));       // 返回  4

        }
}
