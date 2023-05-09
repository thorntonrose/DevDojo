class LruCache {
   int capacity
   Map<Integer, String> data
   List<Integer> keys

   LruCache(int capacity) {
      this.capacity = capacity
      data = new HashMap<Integer, String>()
      keys = new ArrayList()
   }

   String lookup(int key) {
      return "$key"
   }

   String get(int key) {
      // ???: LinkedHashMap may do all this.
      String item = data.get((Integer) key)
      println "$key, $item"

      if (item == null) {
         item = lookup(key)
         if (keys.size() == capacity) { data.remove(keys.remove(0)) }
         data.put(key, item)
      } else {
         keys.removeAll(Arrays.asList(key))
      }

      keys.add(key)
      return item
   }

   String toString() {
      return "keys: $keys, data: $data"
   }
}

cache = new LruCache(2)

[1, 2, 3, 2, 4].each { key ->
   cache.get(key)
   println cache
}
